package br.edu.univille.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    static String getUrlByProp() {
        try {
            return getProp().getProperty("sqlite.url");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "src/main/resources/sqlite-ds.properties");
        props.load(file);
        return props;
    }

}
