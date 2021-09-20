package clientCode;

import javax.swing.JOptionPane;

import adapter.DiscoDuroPortatilAdapter;
import interfaceClass.IDiscoDuro;
import modelo.DiscoDuro1;
import modelo.DiscoDuro2;

public class App {

    private static IDiscoDuro discoDuro;

    public static void usarDiscoDuro() {
        JOptionPane.showMessageDialog(null, discoDuro.almacenar() + "\n" + discoDuro.borrar());
    }

    public static void main(String[] args) {
        int opcion = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                null, 
                "Menu Principal\n\n" +
                "   1. Disco Duro 1\n" +
                "   2. Disco Duro 2\n" +
                "   3. Disco Duro Portatil\n" +
                "   4. Salir"
            ));
            switch (opcion) {
                case 1:
                    discoDuro = new DiscoDuro1();
                    usarDiscoDuro();
                    break;
                case 2:
                    discoDuro = new DiscoDuro2();
                    usarDiscoDuro();
                    break;
                case 3:
                    discoDuro = new DiscoDuroPortatilAdapter();
                    usarDiscoDuro();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Fin del programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción Invalida");
                    break;
            }
        } while (opcion != 4);
    }
}
