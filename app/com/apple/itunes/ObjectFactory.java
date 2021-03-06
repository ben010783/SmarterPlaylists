//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.19 at 10:09:50 AM CST 
//


package com.apple.itunes;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.apple.itunes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Integer_QNAME = new QName("", "integer");
    private final static QName _String_QNAME = new QName("", "string");
    private final static QName _Data_QNAME = new QName("", "data");
    private final static QName _Rating_QNAME = new QName("", "rating");
    private final static QName _Date_QNAME = new QName("", "date");
    private final static QName _Key_QNAME = new QName("", "key");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.apple.itunes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Dict }
     * 
     */
    public Dict createDict() {
        return new Dict();
    }

    /**
     * Create an instance of {@link True }
     * 
     */
    public True createTrue() {
        return new True();
    }

    /**
     * Create an instance of {@link False }
     * 
     */
    public False createFalse() {
        return new False();
    }

    /**
     * Create an instance of {@link Array }
     * 
     */
    public Array createArray() {
        return new Array();
    }

    /**
     * Create an instance of {@link Plist }
     * 
     */
    public Plist createPlist() {
        return new Plist();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "integer")
    public JAXBElement<BigInteger> createInteger(BigInteger value) {
        return new JAXBElement<BigInteger>(_Integer_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "data")
    public JAXBElement<byte[]> createData(byte[] value) {
        return new JAXBElement<byte[]>(_Data_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rating")
    public JAXBElement<BigInteger> createRating(BigInteger value) {
        return new JAXBElement<BigInteger>(_Rating_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "date")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createDate(String value) {
        return new JAXBElement<String>(_Date_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "key")
    public JAXBElement<String> createKey(String value) {
        return new JAXBElement<String>(_Key_QNAME, String.class, null, value);
    }

}
