package clientCode;

import singleton.SistemaRegistros;

public class App {
    public static void main(String[] args) {
        SistemaRegistros.getInstance().ejecutar();
    }
}
