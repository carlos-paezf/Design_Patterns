package concreteProductsBBDD;

import abstractProducts.IConnectionBBDD;


public class ConnectionPostgreSQL implements IConnectionBBDD {

    private String host;
    private String port;
    private String user;
    private String password;

    public ConnectionPostgreSQL() {
        this.host = "localhost";
        this.port = "5432";
        this.user = "davidFerrer";
        this.password = "admin123";
    }

    @Override
    public void connect() {
        System.out.println("Conexión Establecida con PostgreSQL");
    }

    @Override
    public void disconnect() {
        System.out.println("Desconectado de PostgreSQL\n");
    }

    @Override
    public String toString() {
        return "Conexión PostgreSQL [host: " + host
                + ", port: " + port
                + ", user: " + user
                + ", password: " + password
        + "]";
    }
}
