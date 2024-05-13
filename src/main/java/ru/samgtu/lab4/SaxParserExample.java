package ru.samgtu.lab4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.nio.file.Paths;

public class SaxParserExample extends DefaultHandler {
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Обработка начального тега элемента

        System.out.println(localName);
        if (attributes != null){
            String nm = attributes.getValue(0);
            System.out.println(nm);
            String nm1 = attributes.getValue(1);
            System.out.println(nm1);
            System.out.println("_______");
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // Обработка содержимого элемента

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Обработка закрывающего тега элемента
    }

    public static void main(String[] args) {
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new SaxParserExample());
            xmlReader.parse(Paths.get(System.getProperty("user.dir"), "resources/medicine.xsd").toAbsolutePath().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}