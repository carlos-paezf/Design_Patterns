package concreteProductsBBDD;

import abstractProducts.IConnectionBBDD;


public class ConnectionMySQL implements IConnectionBBDD {

    private String host;
    private String port;
    private String user;
    private String password;

    public ConnectionMySQL() {
        this.host = "localhost";
        this.port = "3306";
        this.user = "davidFerrer";
        this.password = "admin123";
    }

    @Override
    public void connect() {
        System.out.println("Conexión establecida con MySQL");
    }

    @Override
    public void disconnect() {
        System.out.println("Desconectado de MySQL\n");
    }

    @Override
    public String toString() {
        return "Conexión MySQL [host: " + host
                + ", port: " + port
                + ", user: " + user
                + ", password: " + password
        + "]";
    }
}
