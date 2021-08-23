package builders;

import ingredientes.Agregado;
import ingredientes.Masa;
import ingredientes.PizzasType;
import ingredientes.Salsa;
import ingredientes.SizeYPorciones;
import pizzas.Pizza;

public class PizzaBuilder implements IChef {

    private PizzasType pizzaType;
    private Agregado agregado;
    private Salsa salsa;
    private Masa masa;
    private SizeYPorciones porciones;

    @Override
    public void setPizzaType(PizzasType pizzasType) {
        this.pizzaType = pizzasType;
    }

    @Override
    public void setAgregado(Agregado agregado) {
        this.agregado = agregado;
    }

    @Override
    public void setSalsa(Salsa salsa) {
        this.salsa = salsa;
    }

    @Override
    public void setMasa(Masa masa) {
        this.masa = masa;
    }

    @Override
    public void setSizeYPiezas(SizeYPorciones porciones) {
        this.porciones = porciones;
    }
    
    public Pizza getPizza() {
        return new Pizza(pizzaType, agregado, salsa, masa, porciones);
    }

}
