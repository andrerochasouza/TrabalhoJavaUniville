package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory(){};

    public static Connection createConnection(Datasource datasource) throws SQLException{
        try {
            String url = datasource.getUrl();
            String user = datasource.getUser();
            String password = datasource.getPassword();

            Connection conexao = null;
            conexao = DriverManager.getConnection(url, user, password);

        } catch (Exception e){
            e.printStackTrace();
        }



        return conexao;
    }

}
