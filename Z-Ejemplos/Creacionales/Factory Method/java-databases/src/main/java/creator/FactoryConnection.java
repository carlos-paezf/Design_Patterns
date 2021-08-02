package creator;

import concreteProducts.ConnectionMySQL;
import concreteProducts.ConnectionOracle;
import concreteProducts.ConnectionPostgreSQL;
import concreteProducts.ConnectionSQLServer;
import concreteProducts.EmptyConnection;
import product.IConnection;

public class FactoryConnection {

    static final String HOST = "localhost";
    static final String PORT = "1234";
    static final String USER = "new-user";
    static final String PASSWORD = "admin123";

    
    public IConnection getConnection(String motor) {
        switch (motor.toUpperCase()) {
            case "MYSQL" -> {
                return new ConnectionMySQL(HOST, PORT, USER, PASSWORD);
            }
            
            case "ORACLE" -> {
                return new ConnectionOracle(HOST, PORT, USER, PASSWORD);
            }

            case "POSTGRESQL" -> {
                return new ConnectionPostgreSQL(HOST, PORT, USER, PASSWORD);
            }
            
            case "SQLSERVER" -> {
                return new ConnectionSQLServer(HOST, PORT, USER, PASSWORD);
            }
        
            default -> {
                return new EmptyConnection();
            }
        }
    }
}
