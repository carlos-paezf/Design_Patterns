package modelo;

import interfaceClass.IDiscoDuro;

public class DiscoDuro2 implements IDiscoDuro {

    @Override
    public String almacenar() {
        return "Información ALMACENADA de manera correcta en el Disco Duro 2";
    }

    @Override
    public String borrar() {
        return "Información ELIMINADA de manera correcta del Disco Duro 2";
    }
    
}
