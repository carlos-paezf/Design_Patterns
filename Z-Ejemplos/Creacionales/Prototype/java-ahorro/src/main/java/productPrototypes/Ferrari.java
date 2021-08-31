package productPrototypes;

import productBase.AutoPrototype;

public class Ferrari extends AutoPrototype {

    @Override
    public AutoPrototype clonar() {
        AutoPrototype auto = null;
        try {
            auto = (Ferrari) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return auto;
    }

    @Override
    public String descripcion() {
        return "Modelo: " + modelo + ", Color: " + color;
    }
    
}
