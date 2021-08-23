package director;

import builders.IChef;
import ingredientes.Agregado;
import ingredientes.Masa;
import ingredientes.PizzasType;
import ingredientes.Salsa;
import ingredientes.Size;
import ingredientes.SizeYPorciones;

public class Pizzeria {
    
    public void constructPizzaItaliana(IChef chef) {
        chef.setPizzaType(PizzasType.ITALIANA);
        chef.setAgregado(Agregado.ANCHOAS);
        chef.setSalsa(Salsa.OLIVA);
        chef.setMasa(Masa.ALAPIEDRA);
    }

    public void constructPizzaLight(IChef chef) {
        chef.setPizzaType(PizzasType.LIGHT);
        chef.setAgregado(Agregado.BERENJENAS);
        chef.setSalsa(Salsa.LIGHT);
        chef.setMasa(Masa.INTEGRAL);
        chef.setSizeYPiezas(new SizeYPorciones(Size.SMALL, 4));
    }

    public void constructPizaMozzarella(IChef chef) {
        chef.setPizzaType(PizzasType.MOZZARELLA);
        chef.setAgregado(Agregado.OREGANO);
        chef.setSalsa(Salsa.TOMATE);
        chef.setMasa(Masa.ALMOLDE);
        chef.setSizeYPiezas(new SizeYPorciones(Size.BIG, 8));
    }
}
