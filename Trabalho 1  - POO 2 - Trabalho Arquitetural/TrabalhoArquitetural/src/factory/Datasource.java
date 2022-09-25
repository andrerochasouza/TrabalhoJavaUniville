package factory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Datasource {

    public static Properties getProperties(DatabaseType databaseType) {

        Properties props = new Properties();
        String dsPath = "resource/"+ databaseType +"-ds.properties";

        try {
            FileInputStream fis = new FileInputStream(dsPath);
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static void setProperties(ConnectionJdbc jdbc, DatabaseType databaseType){

        Properties props = new Properties();
        String dsPath = "resource/"+ databaseType +"-ds.properties";

        try{
            props.setProperty("datasource.url", jdbc.getUser());
            props.setProperty("datasource.user", jdbc.getPassword());
            props.setProperty("datasource.password", jdbc.getDriver());
            props.setProperty("datasource.driver", jdbc.getUrl());
            props.setProperty("datasource.database", jdbc.getDatabase());

            FileOutputStream fos = new FileOutputStream(dsPath);
            props.store(fos, "FILE JDBC PROPERTIES:");
            fos.close();
        } catch (NullPointerException e){
            System.err.println("All attributes must be entered !!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
