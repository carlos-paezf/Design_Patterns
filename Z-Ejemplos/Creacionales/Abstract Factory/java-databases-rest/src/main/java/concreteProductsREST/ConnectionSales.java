package concreteProductsREST;

import abstractProducts.IConnectionREST;


public class ConnectionSales implements IConnectionREST {

    @Override
    public void readURL(String url) {
        System.out.println("Conectándose a " + url);
    }
}
