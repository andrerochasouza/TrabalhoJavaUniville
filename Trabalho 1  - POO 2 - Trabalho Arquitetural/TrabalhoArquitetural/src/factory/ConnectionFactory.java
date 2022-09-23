package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory(){};

    public static String createConnectionOracle(Datasource datasource){

        Connection conexao = null;
        String ip = datasource.getIp();

        try {

            String port = datasource.getPort();
            String sid = datasource.getSid();
            String user = datasource.getUser();
            String password = datasource.getPassword();
            //conexao = DriverManager.getConnection(url, user, password);

        } catch (Exception e){
            e.printStackTrace();
        }

        return ip;
        //return conexao;
    }



}
