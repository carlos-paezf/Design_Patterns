package app;

import abstractFactory.IAbstractFactory;
import abstractProducts.IConnectionBBDD;
import abstractProducts.IConnectionREST;

public class App {
    
    public static void main(String[] args) {
        IAbstractFactory factoryBBDD = ClientCode.getFactory("BBDD");
        IConnectionBBDD connBBDD1 = factoryBBDD.getConnectionBBDD("MySql");
        connBBDD1.connect();
        connBBDD1.disconnect();

        IAbstractFactory factoryREST = ClientCode.getFactory("REST");
        IConnectionREST connREST1 = factoryREST.getConnectionREST("Sales");
        connREST1.readURL("https://www.google.com/");
    }
}
