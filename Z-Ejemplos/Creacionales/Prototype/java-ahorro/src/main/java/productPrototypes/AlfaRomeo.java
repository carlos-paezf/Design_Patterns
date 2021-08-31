package productPrototypes;

import productBase.AutoPrototype;

public class AlfaRomeo extends AutoPrototype{

    @Override
    public AutoPrototype clonar() {
        AutoPrototype auto = null;
        try {
            auto = (AlfaRomeo) clone();
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
