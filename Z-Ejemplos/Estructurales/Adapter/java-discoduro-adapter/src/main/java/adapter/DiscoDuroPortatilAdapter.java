package adapter;

import javax.swing.JOptionPane;

import interfaceClass.IDiscoDuro;
import service.DiscoDuroPortatil;

public class DiscoDuroPortatilAdapter implements IDiscoDuro{

    private DiscoDuroPortatil discoDuroPortatil;

    public DiscoDuroPortatilAdapter() {
        this.discoDuroPortatil = new DiscoDuroPortatil();
    }

    @Override
    public String almacenar() {
        return discoDuroPortatil.conectarPuertoUSB() + "\n" + discoDuroPortatil.almacenarInformacion();
    }

    @Override
    public String borrar() {
        if(JOptionPane.showConfirmDialog(null, "¿Desea desconectar el Disco Duro?") == 0) {
            return discoDuroPortatil.eliminarInformacion() + "\n" + discoDuroPortatil.desconectarPuertoUSB();
        }
        return discoDuroPortatil.eliminarInformacion();
    }
    
}
