package concreteProducts;

import product.IConnection;


public class ConnectionPostgreSQL implements IConnection {

    private String host;
    private String port;
    private String user;
    private String password;

    public ConnectionPostgreSQL(String host, String port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    @Override
    public void connect() {
        // TODO: Código Java Database Connectivity (JDBC)
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
