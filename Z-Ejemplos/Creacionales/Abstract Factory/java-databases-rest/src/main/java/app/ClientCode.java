package app;

import abstractFactory.IAbstractFactory;
import concreteFactories.ConnectionBBDD;
import concreteFactories.ConnectionREST;


public class ClientCode {
    
    public static IAbstractFactory getFactory(String factoryType) {
        if (factoryType.equalsIgnoreCase("BBDD")) {
            return new ConnectionBBDD();
        } else if (factoryType.equalsIgnoreCase("REST")) {
            return new ConnectionREST();
        }
        return null;
    }
}
