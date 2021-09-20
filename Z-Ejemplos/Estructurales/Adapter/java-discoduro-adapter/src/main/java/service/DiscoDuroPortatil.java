package service;

public class DiscoDuroPortatil {
    private boolean conectado;

    public DiscoDuroPortatil() {
        this.conectado = false;
    }

    public String conectarPuertoUSB() {
        if(!conectado) {
            conectado = true;
            return "Disco Duro Portatil conectado por USB";
        }
        return "El Disco Duro Portatil ya ha sido conectado";
    }

    public String desconectarPuertoUSB() {
        if(conectado) {
            conectado = false;
            return "El Disco Duro Portatil ha sido desconectado";
        }
        return "El Disco Duro del Portatil ya ha sido desconectado";
    }

    public String almacenarInformacion() {
        return "Información almacenada correctamente dentro del Disco Duro Portatil";
    }

    public String eliminarInformacion() {
        return "Información almacenada con exito de la unidad de Disco Duro Portatil";
    }
}
