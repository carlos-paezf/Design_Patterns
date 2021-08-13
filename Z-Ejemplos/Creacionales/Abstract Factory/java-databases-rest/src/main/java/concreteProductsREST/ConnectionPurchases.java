package concreteProductsREST;

import abstractProducts.IConnectionREST;


public class ConnectionPurchases implements IConnectionREST {

    @Override
    public void readURL(String url) {
        System.out.println("Conectándose a " + url);
    }
}
