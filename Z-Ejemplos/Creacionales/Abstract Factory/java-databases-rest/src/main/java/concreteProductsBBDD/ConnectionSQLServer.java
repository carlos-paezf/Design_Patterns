package concreteProductsBBDD;

import abstractProducts.IConnectionBBDD;


public class ConnectionSQLServer implements IConnectionBBDD {

    private String host;
    private String port;
    private String user;
    private String password;

    public ConnectionSQLServer() {
        this.host = "localhost";
        this.port = "1234";
        this.user = "davidFerrer";
        this.password = "admin123";
    }

    @Override
    public void connect() {
        System.out.println("Conexión establecida con SQLServer");
    }

    @Override
    public void disconnect() {
        System.out.println("Desconectado de SQLServer");
    }
    
    @Override
    public String toString() {
        return "Conexión SQLServer [host: " + host
                + ", port: " + port
                + ", user: " + user
                + ", password: " + password
        + "]";
    }
}
