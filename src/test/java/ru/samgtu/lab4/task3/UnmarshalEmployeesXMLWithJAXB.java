package ru.samgtu.lab4.task3;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.junit.Test;
import ru.samgtu.lab4.Company;
import ru.samgtu.lab4.Employee;

import java.io.File;

public class UnmarshalEmployeesXMLWithJAXB {

    @Test
    public void test() {
        try {
            File file = new File("resources/employees.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            var company = (Company) jaxbUnmarshaller.unmarshal(file);

            for (Employee employee : company.employees) {
                System.out.println("ID: " + employee.id);
                System.out.println("First Name: " + employee.firstName);
                System.out.println("Last Name: " + employee.lastName);
                System.out.println("Age: " + employee.age);
                System.out.println("Salary: " + employee.salary);
                System.out.println();
            }

            System.out.println("Макс. зарплата: " + company.employees.stream().mapToDouble((u) -> u.salary).max().getAsDouble());
            System.out.println("Макс. возраст: " + company.employees.stream().mapToDouble((u) -> u.age).max().getAsDouble());
            System.out.println("Средний возраст: " + company.employees.stream().mapToDouble((u) -> u.age).average().getAsDouble());
            System.out.println("Мин. возраст: " + company.employees.stream().mapToDouble((u) -> u.age).min().getAsDouble());
            System.out.println("Общая по зарплате: " + company.employees.stream().mapToDouble((u) -> u.salary).summaryStatistics());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
