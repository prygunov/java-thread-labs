package ru.samgtu.lab4.task1;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.instancio.Instancio;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import ru.samgtu.jaxb.gen.Pharmacy;

import java.io.File;
import java.io.PrintWriter;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JaxbTest {

    private static String filename= "test.xml";

    @Test
    @Order(1)
    public void marshalXmlTest() {
        try {
            Pharmacy pharmacy = Instancio.create(Pharmacy.class);
            System.out.println(pharmacy.getId());
            //писать результат сериализации будем в Writer(StringWriter)
            PrintWriter out = new PrintWriter(filename);

            //создание объекта Marshaller, который выполняет сериализацию
            JAXBContext context = JAXBContext.newInstance(Pharmacy.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // сама сериализация
            marshaller.marshal(pharmacy, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    public void unmarshalXmlTest() {
        try {
            JAXBContext context = JAXBContext.newInstance(Pharmacy.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Pharmacy pharmacy = (Pharmacy) unmarshaller.unmarshal(new File(filename));

            System.out.println(pharmacy.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}