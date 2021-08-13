package concreteFactories;

import abstractFactory.IAbstractFactory;
import abstractProducts.IConnectionBBDD;
import abstractProducts.IConnectionREST;
import concreteProductsBBDD.ConnectionMySQL;
import concreteProductsBBDD.ConnectionOracle;
import concreteProductsBBDD.ConnectionPostgreSQL;
import concreteProductsBBDD.ConnectionSQLServer;
import concreteProductsBBDD.EmptyConnection;


public class ConnectionBBDD implements IAbstractFactory {

    @Override
    public IConnectionBBDD getConnectionBBDD(String motor) {
        switch (motor.toUpperCase()) {
            case "MYSQL" -> { return new ConnectionMySQL(); } 
            case "ORACLE" -> { return new ConnectionOracle(); }
            case "POSTGRESQL" -> { return new ConnectionPostgreSQL(); }
            case "SQLSERVER" -> { return new ConnectionSQLServer(); }
            default -> { return new EmptyConnection(); }
        }
    }

    @Override
    public IConnectionREST getConnectionREST(String area) {
        return null;
    }
}
