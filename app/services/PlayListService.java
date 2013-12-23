package services;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import play.Logger;

import com.apple.itunes.Dict;
import com.apple.itunes.False;
import com.apple.itunes.Plist;
import com.apple.itunes.True;

import domain.Library;
import domain.Track;

public class PlayListService {
	public static String parseXMLFile(File file) throws NumberFormatException, JAXBException, ParseException, SAXException, IOException {
		Library library = getLibrary(file);
		Logger.debug(library.toString());
		return "ok";
	}
	private static Map<String, String> getKeysAndValues(Dict dict) {
		Map<String, String> keyMap = new LinkedHashMap<String, String>();
		String key = null;
        for (Object o : dict.getDictOrArrayOrData()) {
        	if (o instanceof JAXBElement) {
        		JAXBElement<?> element = (JAXBElement<?>) o;
        		if (key != null) {
        			keyMap.put(key, element.getValue().toString());
        			key = null;
        		}
        		else if (element.getName().getLocalPart().equals("key")) {
    				key = element.getValue().toString();
    			}
        	}
        	else if (o instanceof True || o instanceof False) {
        		keyMap.put(key, o instanceof True ? "1" : "0");
        		key = null;
        	}
        }
		return keyMap;
	}
	public static Plist getPlist(File file) throws SAXException, JAXBException, NumberFormatException, ParseException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File("conf"+File.separator+"iTunes.xsd"));
		JAXBContext jc = JAXBContext.newInstance(Plist.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		unmarshaller.setSchema(schema);
		Plist plist = (Plist) unmarshaller.unmarshal(file);
		return plist;
	}
	public static Library getLibrary(File file) throws SAXException, JAXBException, NumberFormatException, ParseException {
        Plist plist = getPlist(file);
		Library library = new Library(getKeysAndValues(plist.getDict()));
		library.setTracks(getTracks(plist.getDict()));
		return library;
	}
	private static Map<Integer, Track> getTracks(Dict dict) throws NumberFormatException, ParseException {
		Map<Integer, Track> trackMap = new LinkedHashMap <Integer, Track>();
		boolean foundTracks = false;
		for (Object o : dict.getDictOrArrayOrData()) {
			if (foundTracks && o instanceof Dict) {
				for (Object element : ((Dict) o).getDictOrArrayOrData()) {
					if (element instanceof Dict) {
						Map<String, String> map = getKeysAndValues((Dict) element);
						trackMap.put(Integer.parseInt(map.get("Track ID")), new Track(map));
					}
				}
				break;
			}
			if (o instanceof JAXBElement<?>) {
				JAXBElement<?> element = (JAXBElement<?>) o;
				if (element.getName().getLocalPart().equals("key") && element.getValue().toString().equals(Library.TRACKS)) {
					foundTracks = true;
				}
			}
		}
		return trackMap;
	}
}
