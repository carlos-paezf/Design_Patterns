package application;

import creator.FactoryConnection;
import product.IConnection;

public class App {
    
    public static void main(String[] args) {
        FactoryConnection factory = new FactoryConnection();

        IConnection conn1 = factory.getConnection("MySQL");
        conn1.connect();
        conn1.disconnect();

        IConnection conn2 = factory.getConnection("PostgreSQL");
        conn2.connect();
        conn2.disconnect();

        IConnection conn3 = factory.getConnection("SQLite");
        conn3.connect();
        conn3.disconnect();
    }

}
