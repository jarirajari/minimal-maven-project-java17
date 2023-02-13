package org.example.main;

import java.io.IOException;
import java.util.Properties;

public class Application {
    private static final System.Logger log = System.getLogger(Application.class.getName());
    private static final Properties properties = loadProperties();
    public static void main(String[] args) {
        log.log(System.Logger.Level.INFO, String.format("version = %s", properties.getProperty("version", "-")));
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try {
            props.load(Application.class.getClassLoader().getResourceAsStream("app.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }
}
