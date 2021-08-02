package concreteProducts;

import product.IConnection;


public class ConnectionSQLServer implements IConnection {

    private String host;
    private String port;
    private String user;
    private String password;

    public ConnectionSQLServer(String host, String port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    @Override
    public void connect() {
        // TODO: Código Java Database Connectivity (JDBC)
        System.out.println("Conexión Establecida con SQLServer");
    }

    @Override
    public void disconnect() {
        System.out.println("Desconectado de SQLServer\n");
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
