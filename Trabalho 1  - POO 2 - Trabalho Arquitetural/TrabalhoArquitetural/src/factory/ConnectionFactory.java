package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

    private ConnectionFactory(){};

    public static Connection createConnection(DatabaseType databaseType){

        Connection conexao = null;

        try {
            Properties ds = Datasource.getProperties(databaseType);

            String url = ds.getProperty("datasource.url");
            String user = ds.getProperty("datasource.user");
            String password = ds.getProperty("datasource.password");
            conexao = DriverManager.getConnection(url, user, password);

        } catch (Exception e){
            e.printStackTrace();
        }

        return conexao;
    }
}
