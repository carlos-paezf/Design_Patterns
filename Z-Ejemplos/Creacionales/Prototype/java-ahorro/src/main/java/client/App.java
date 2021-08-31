package client;

import productBase.AutoPrototype;
import productPrototypes.AlfaRomeo;
import productPrototypes.Ferrari;
import productPrototypes.Fiat;

public class App {
    public static void main(String[] args) {
        AutoPrototype alfaRomeroPrototype = new AlfaRomeo();
        AutoPrototype ferrariPrototype = new Ferrari();
        AutoPrototype fiatPrototype = new Fiat();

        AutoPrototype guilietta = alfaRomeroPrototype.clonar();
        guilietta.setModelo("Alfa Romero Guilietta");
        guilietta.setColor("Rojo");
        System.out.println(guilietta.descripcion());
        
        AutoPrototype giuliaGTA = alfaRomeroPrototype.clonar();
        giuliaGTA.setModelo("Alfa Romero Giulia GTA");
        giuliaGTA.setColor("Blanco");
        System.out.println(giuliaGTA.descripcion());

        AutoPrototype berlinetta = ferrariPrototype.clonar();
        berlinetta.setModelo("Ferrari 250 GT Berlinetta");
        berlinetta.setColor("Negro");
        System.out.println(berlinetta.descripcion());

        AutoPrototype scaglietti = ferrariPrototype.clonar();
        scaglietti.setModelo("Ferrari 612 Scaglietti");
        scaglietti.setColor("Metalico");
        System.out.println(scaglietti.descripcion());

        AutoPrototype panda = fiatPrototype.clonar();
        panda.setModelo("Fiat Panda");
        panda.setColor("Blanco y Negro");
        System.out.println(panda.descripcion());

        AutoPrototype ducato = fiatPrototype.clonar();
        ducato.setModelo("Fiat Ducato");
        ducato.setColor("Dorado");
        System.out.println(ducato.descripcion());

        System.out.println("1. Referencia en memoria producto vs prototipo " + (guilietta == alfaRomeroPrototype));
        System.out.println("4. Referencia en memoria producto vs prototipo " + (scaglietti == alfaRomeroPrototype));
        System.out.println("5. Referencia en memoria producto vs prototipo " + (ducato == alfaRomeroPrototype));
    }
}
