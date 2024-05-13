package ru.samgtu.lab4;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;
import java.nio.file.Paths;

public class DomParserExample {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(Paths.get(System.getProperty("user.dir"), "resources/medicine.xsd").toFile());
            NodeList nodeList = document.getElementsByTagName("xs:element");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element first = (Element)nodeList.item(i);
                if(first.hasAttributes())
                {
                    String nm = first.getAttribute("name");
                    System.out.println(nm);
                    String nm1 = first.getAttribute("type");
                    System.out.println(nm1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}