package builders;

import ingredientes.Agregado;
import ingredientes.Masa;
import ingredientes.PizzasType;
import ingredientes.SizeYPorciones;
import ingredientes.Salsa;

public interface IChef {
    void setPizzaType(PizzasType pizzasType);
    void setAgregado(Agregado agregado);
    void setSalsa(Salsa salsa);
    void setMasa(Masa masa);
    void setSizeYPiezas(SizeYPorciones porciones);
}
