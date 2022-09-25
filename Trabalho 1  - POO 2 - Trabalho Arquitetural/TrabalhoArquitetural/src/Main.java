import factory.ConnectionFactory;
import factory.DatabaseType;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        System.out.println("Inicio do programa!");
        Connection conn = ConnectionFactory.createConnection(DatabaseType.H2);


    }

}
