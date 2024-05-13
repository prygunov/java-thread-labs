package ru.samgtu.lab4;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "company")
public class Company {

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "Employee")
    public List<Employee> employees;

}