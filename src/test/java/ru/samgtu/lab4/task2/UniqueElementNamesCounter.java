package ru.samgtu.lab4.task2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.Set;

public class UniqueElementNamesCounter {
    @Test
    public void countUnique() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("resources/sample.xml");

            Set<String> uniqueElementNames = new HashSet<>();

            NodeList nodeList = document.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    String localName = node.getNodeName();
                    uniqueElementNames.add(localName);
                }
            }

            System.out.println("Количество уникальных локальных имен элементов: " + uniqueElementNames.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
