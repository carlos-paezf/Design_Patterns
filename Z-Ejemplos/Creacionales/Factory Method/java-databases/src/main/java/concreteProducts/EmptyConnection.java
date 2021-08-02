package concreteProducts;

import product.IConnection;


public class EmptyConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("Motor de Database Desconocido");
    }

    @Override
    public void disconnect() {
        System.out.println("Sin motor para desconectar\n");
    }
    
}
