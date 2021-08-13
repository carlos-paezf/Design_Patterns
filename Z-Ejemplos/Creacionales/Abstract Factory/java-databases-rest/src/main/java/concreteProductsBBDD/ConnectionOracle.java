package concreteProductsBBDD;

import abstractProducts.IConnectionBBDD;


public class ConnectionOracle implements IConnectionBBDD {

    private String host;
    private String port;
    private String user;
    private String password;

    public ConnectionOracle() {
        this.host = "localhost";
        this.port = "8888";
        this.user = "davidFerrer";
        this.password = "admin123";
    }

    @Override
    public void connect() {
        System.out.println("Conexión Establecida con Oracle");
    }

    @Override
    public void disconnect() {
        System.out.println("Desconectado de Oracle\n");
    }

    @Override
    public String toString() {
        return "Conexión Oracle [host: " + host
                + ", port: " + port
                + ", user: " + user
                + ", password: " + password
        + "]";
    }
}
