package ru.samgtu.lab3;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection getConnection() throws Exception {
        Driver driver = getDriver();
        Connection connect = driver.connect(getDatabaseURL(), getDatabaseProperties());
        connect.setAutoCommit(true);
        connect.setSchema("public");
        return connect;
    }

    private static String getDatabaseURL() {
        return "jdbc:postgresql://localhost:5432/samgtu";
    }

    private static Driver getDriver() throws Exception {
        Class<Driver> driverClass = (Class<Driver>) Class.forName("org.postgresql.Driver");
        Constructor<Driver> constructor = driverClass.getConstructor();
        return constructor.newInstance();
    }

    private static Properties getDatabaseProperties() {
        Properties properties = new Properties();
        properties.put("user", "samgtu");
        properties.put("password", "samgtu");
        return properties;
    }


}