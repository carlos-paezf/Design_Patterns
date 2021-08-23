package pizzas;

import ingredientes.Agregado;
import ingredientes.Masa;
import ingredientes.PizzasType;
import ingredientes.Salsa;
import ingredientes.SizeYPorciones;

public class Pizza {

    private PizzasType pizzaType;
    private Agregado agregado;
    private Salsa salsa;
    private Masa masa;
    private SizeYPorciones porciones;

    public Pizza(PizzasType pizzaType, Agregado agregado, Salsa salsa, Masa masa, SizeYPorciones porciones) {
        this.pizzaType = pizzaType;
        this.agregado = agregado;
        this.salsa = salsa;
        this.masa = masa;
        this.porciones = porciones;
    }
    
    public PizzasType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzasType pizzasType) {
        this.pizzaType = pizzasType;
    }

    public Agregado getAgregado() {
        return agregado;
    }

    public void setAgregado(Agregado agregado) {
        this.agregado = agregado;
    }

    public Salsa getSalsa() {
        return salsa;
    }

    public void setSalsa(Salsa salsa) {
        this.salsa = salsa;
    }

    public Masa getMasa() {
        return masa;
    }

    public void setMasa(Masa masa) {
        this.masa = masa;
    }

    public SizeYPorciones getSizeYPorciones() {
        return porciones;
    }

    public void setSizeYPorciones(SizeYPorciones porciones) {
        this.porciones = porciones;
    }

    @Override
    public String toString() {
        String espacio = "   ";
        return "Pizza de tipo " + pizzaType
                + ",\n" + espacio + "con agregado de: " + agregado
                + ",\n" + espacio + "salsa de: " + salsa
                + ",\n" + espacio + "masa de: " + masa
                + ",\n" + espacio + "tamaño y porciones de: \n" + porciones
        + ".\n";
    }
}
