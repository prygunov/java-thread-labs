package ru.samgtu.lab4.task3;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileOutputStream;

public class CreateEmployeesXML {

    @Test
    public void test() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element rootElement = document.createElement("company");

            var rootObject = document.createElement("employees");
            rootElement.appendChild(rootObject);
            document.appendChild(rootElement);

            addEmployee(document, rootObject, "1", "Иван", "Иванов", 30, 50000);
            addEmployee(document, rootObject, "2", "Петр", "Петров", 35, 60000);
            addEmployee(document, rootObject, "3", "Мария", "Сидорова", 28, 45000);

            File file = new File("resources/employees.xml");
            FileOutputStream fos = new FileOutputStream(file);
            document.setXmlStandalone(true);
            javax.xml.transform.TransformerFactory.newInstance().newTransformer().transform(new javax.xml.transform.dom.DOMSource(document), new javax.xml.transform.stream.StreamResult(fos));
            fos.close();

            System.out.println("Файл employees.xml успешно создан.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addEmployee(Document document, Element rootElement, String id, String firstName, String lastName, int age, int salary) {
        Element employeeElement = document.createElement("Employee");
        rootElement.appendChild(employeeElement);

        Element idElement = document.createElement("id");
        idElement.appendChild(document.createTextNode(id));
        employeeElement.appendChild(idElement);

        Element firstNameElement = document.createElement("firstName");
        firstNameElement.appendChild(document.createTextNode(firstName));
        employeeElement.appendChild(firstNameElement);

        Element lastNameElement = document.createElement("lastName");
        lastNameElement.appendChild(document.createTextNode(lastName));
        employeeElement.appendChild(lastNameElement);

        Element ageElement = document.createElement("age");
        ageElement.appendChild(document.createTextNode(String.valueOf(age)));
        employeeElement.appendChild(ageElement);

        Element salaryElement = document.createElement("salary");
        salaryElement.appendChild(document.createTextNode(String.valueOf(salary)));
        employeeElement.appendChild(salaryElement);
    }
}
