//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.19 at 10:09:50 AM CST 
//


package com.apple.itunes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}dict" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dict"
})
@XmlRootElement(name = "array")
public class Array {

    @XmlElement(required = true)
    protected List<Dict> dict;

    /**
     * Gets the value of the dict property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dict property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDict().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dict }
     * 
     * 
     */
    public List<Dict> getDict() {
        if (dict == null) {
            dict = new ArrayList<Dict>();
        }
        return this.dict;
    }
	public boolean equals(Object obj) {
	    if (obj == this) {
	        return true;
	    }
	    if (obj == null || obj.getClass() != this.getClass()) {
	        return false;
	    }
	    Array a = (Array) obj;
	    if (this.getDict() == null && a.getDict() != null)
	    	return false;
	    if (this.getDict() != null && a.getDict() != null) {
	    	if (this.getDict().size() != a.getDict().size())
	    		return false;
	    	Iterator<Dict> iter = a.getDict().iterator();
	    	for (Dict d1 : this.getDict()) {
	    		Dict d2 = iter.next();
	    		if (!d1.equals(d2))
	    			return false;
	    	}
	    }
	    return true;
	}
}
