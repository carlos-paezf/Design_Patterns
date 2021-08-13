package concreteProductsBBDD;

import abstractProducts.IConnectionBBDD;


public class EmptyConnection implements IConnectionBBDD {

    @Override
    public void connect() {
        System.out.println("Motor de Database desconocido");
    }

    @Override
    public void disconnect() {
        System.out.println("Sin motor para desconectar\n");
    }
}
