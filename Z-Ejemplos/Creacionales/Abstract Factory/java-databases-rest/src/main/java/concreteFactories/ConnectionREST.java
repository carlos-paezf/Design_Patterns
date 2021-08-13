package concreteFactories;

import abstractFactory.IAbstractFactory;
import abstractProducts.IConnectionBBDD;
import abstractProducts.IConnectionREST;
import concreteProductsREST.ConnectionNoArea;
import concreteProductsREST.ConnectionPurchases;
import concreteProductsREST.ConnectionSales;


public class ConnectionREST implements IAbstractFactory {

    @Override
    public IConnectionBBDD getConnectionBBDD(String motor) {
        return null;
    }

    @Override
    public IConnectionREST getConnectionREST(String area) {
        switch (area.toUpperCase()) {
            case "PURCHASES" -> { return new ConnectionPurchases(); }
            case "SALES" -> { return new ConnectionSales(); }
            default -> { return new ConnectionNoArea(); }
        }
    }
}
