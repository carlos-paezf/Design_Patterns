package abstractFactory;

import abstractProducts.IConnectionBBDD;
import abstractProducts.IConnectionREST;


public interface IAbstractFactory {
    IConnectionBBDD getConnectionBBDD(String motor);
    IConnectionREST getConnectionREST(String area);
}