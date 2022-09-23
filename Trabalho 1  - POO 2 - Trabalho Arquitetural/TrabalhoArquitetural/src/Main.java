import factory.ConnectionFactory;
import factory.Datasource;

public class Main {

    public static void main(String[] args) {

        System.out.println("Inicio do programa!");
        Datasource ds = new Datasource();
        ds.setIp("andre");
        String andre = ConnectionFactory.createConnectionOracle(ds);
        System.out.println(andre);
    }

}
