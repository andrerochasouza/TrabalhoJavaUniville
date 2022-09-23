package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Datasource {

    private Properties getProps(){
        Properties props = new Properties();

        try{
        FileInputStream file = new FileInputStream("resource/datasource.properties");
        props.load(file);
        } catch(IOException e){
            e.printStackTrace();
        }

        return props;
    }

    public String getIp() {
        return this.getProps().getProperty("datasource.oracle.ip");
    }

    public String getPort() {
        return this.getProps().getProperty("datasource.oracle.port");
    }

    public String getSid() {
        return this.getProps().getProperty("datasource.oracle.sid");
    }

    public String getUser() {
        return this.getProps().getProperty("datasource.oracle.user");
    }

    public String getPassword() {
        return this.getProps().getProperty("datasource.oracle.password");
    }

    public void setIp(String ip) {
        this.getProps().setProperty("datasource.oracle.ip", ip);
    }

    public void setPort(String port) {
        this.getProps().setProperty("datasource.oracle.port", port);
    }

    public void setSid(String sid) {
        this.getProps().setProperty("datasource.oracle.sid", sid);
    }

    public void setUser(String user) {
        this.getProps().setProperty("datasource.oracle.user", user);
    }

    public void setPassword(String password) {
        this.getProps().setProperty("datasource.oracle.password", password);
    }
}
