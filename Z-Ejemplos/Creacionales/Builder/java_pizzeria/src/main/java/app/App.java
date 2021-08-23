package app;

import builders.PizzaBuilder;
import director.Pizzeria;
import ingredientes.Agregado;
import ingredientes.Masa;
import ingredientes.PizzasType;
import ingredientes.Salsa;
import ingredientes.Size;
import ingredientes.SizeYPorciones;
import pizzas.Pizza;

public class App {
    
    public static void main(String[] args) {
        Pizzeria director = new Pizzeria();
        PizzaBuilder chef = new PizzaBuilder();
        Pizza pizza;

        //------ Pizza Italiana
        director.constructPizzaItaliana(chef);
        chef.setSizeYPiezas(new SizeYPorciones(Size.MEDIUM, 8));
        pizza = chef.getPizza();
        System.out.println("Pizza cocinada:\n" + pizza.toString());

        //------ Pizza Light
        director.constructPizzaLight(chef);
        pizza = chef.getPizza();
        System.out.println("Pizza cocinada:\n" + pizza.toString());

        //------ Pizza Mozzarella
        director.constructPizaMozzarella(chef);
        pizza = chef.getPizza();
        System.out.println("Pizza cocinada:\n" + pizza.toString());

        //------ Pizza Personalizada
        chef.setPizzaType(PizzasType.PERSONALIZADA);
        chef.setAgregado(Agregado.OREGANO);
        chef.setMasa(Masa.ALAPIEDRA);
        chef.setSalsa(Salsa.LIGHT);
        chef.setSizeYPiezas(new SizeYPorciones(Size.BIG, 12));
        pizza = chef.getPizza();
        System.out.println("Pizza personalizada:\n" + pizza.toString());
    }
}
