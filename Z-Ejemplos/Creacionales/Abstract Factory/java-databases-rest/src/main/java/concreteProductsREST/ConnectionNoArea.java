package concreteProductsREST;

import abstractProducts.IConnectionREST;


public class ConnectionNoArea implements IConnectionREST {

    @Override
    public void readURL(String url) {
        System.out.println("No hay acceso a esta area");
    }
}
