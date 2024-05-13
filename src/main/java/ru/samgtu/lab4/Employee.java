package ru.samgtu.lab4;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employee")
public class Employee {

    public int id;
    public String firstName;
    public String lastName;
    public int age;
    public double salary;

}