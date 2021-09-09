package singleton;

import java.util.ArrayList;

import lector.Lector;
import model.Administrativo;
import model.Police;

public class SistemaRegistros {
    private static SistemaRegistros INSTANCE = null;

    private SistemaRegistros() {}

    public static SistemaRegistros getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SistemaRegistros();
        }
        return INSTANCE;
    }

    private ArrayList<Police> listaPolicias = new ArrayList<>();
    private ArrayList<Administrativo> listaAdministrativos = new ArrayList<>();

    private final String nombreComisaria = "Comisaria policial NN";

    public void ejecutar() {
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1: registrarPolicia(); break;
                case 2: registrarAdministrativo(); break;
                case 3: calcularSaldoPolicia(); break;
                case 4: listarPoliciaEdad(); break;
                case 5: listarPoliciaSueldo(); break;
                case 6: listarAdministrativoApellidos(); break;
                case 7: System.out.println("Saliendo del programa"); break;
                default: System.out.println("La opción no es valida"); break;
            }
        } while (opcion != 7);
    }

    public int menu() {
        String opciones = "\n\n\nMENÚ PRINCIPAL DE LA COMISARIA: " + nombreComisaria + "\n\n"
            + "1. Registrar Policia \n"
            + "2. Registrar Personal Administrativo \n"
            + "3. Calcular saldo de Policia \n"
            + "4. Listar ascendentemente los policias por edad \n"
            + "5. Listar según el sueldo de los policias \n"
            + "6. Listar alfabeticamente el personal administrativo por apellidos \n"
            + "7. Salir"
            + "\n\n Ingrese la Opción deseada: ";
            return Integer.parseInt(Lector.leer(opciones));
    }

    public void registrarPolicia() {
        String cod = Lector.leer("Ingrese el código del programa: ");
        String nombres = Lector.leer("Ingrese los nombres: ");
        String apellidos = Lector.leer("Ingrese los apellidos: ");
        int cedula = Integer.parseInt(Lector.leer("Ingrese la cedula: "));
        int edad = Integer.parseInt(Lector.leer("Ingrese la edad: "));
        int antiguedad = Integer.parseInt(Lector.leer("Ingrese la antiguedad: "));
        int rango = -1;
        while(rango < 1 || rango > 5) {
            rango = Integer.parseInt(Lector.leer("Ingrese el rango del policia: "));
        }
        listaPolicias.add(new Police(cod, nombres, apellidos, cedula, edad, rango, antiguedad));
    }

    public void registrarAdministrativo() {
        String cod = Lector.leer("Ingrese el código del programa: ");
        String nombres = Lector.leer("Ingrese los nombres: ");
        String apellidos = Lector.leer("Ingrese los apellidos: ");
        int cedula = Integer.parseInt(Lector.leer("Ingrese la cedula: "));
        String sector = Lector.leer("Ingrese el sector de trabajo: ");
        String cargo = Lector.leer("Ingrese el cargo asignado: ");
        listaAdministrativos.add(new Administrativo(cod, nombres, apellidos, cedula, cargo, sector));
    }

    private void calcularSaldoPolicia() {
        for(Police p : listaPolicias) p.calcularSaldo();
    }

    private void listarPoliciaEdad() {
        //? Aplicación del Método de la Burbuja
        for(int i=0, tam=listaPolicias.size()-1; i<tam; i++) {
            for(int j=i+1, t=listaPolicias.size(); j<t; j++) {
                if(listaPolicias.get(i).getEdad() > listaPolicias.get(j).getEdad()) {
                    Police temp = listaPolicias.get(i);
                    listaPolicias.set(i, listaPolicias.get(j));
                    listaPolicias.set(j, temp);
                }
            }
        }
        for(Police p : listaPolicias) System.out.println(p.toString());
    }

    private void listarPoliciaSueldo() {
        //? Aplicación del Método de la Burbuja
        for(int i=0, tam=listaPolicias.size()-1; i<tam; i++) {
            for(int j=i+1, t=listaPolicias.size(); j<t; j++) {
                if(listaPolicias.get(i).getSaldo() > listaPolicias.get(j).getSaldo()) {
                    Police temp = listaPolicias.get(i);
                    listaPolicias.set(i, listaPolicias.get(j));
                    listaPolicias.set(j, temp);
                }
            }
        }
        for(Police p : listaPolicias) System.out.println(p.toString());
    }

    private void listarAdministrativoApellidos() {
        for(int i=0, tam=listaAdministrativos.size()-1; i<tam; i++) {
            for(int j=i+1, t=listaAdministrativos.size(); j<t; j++) {
                if(listaAdministrativos.get(i).getApellidos().compareTo(listaAdministrativos.get(j).getApellidos()) > 0) {
                    Administrativo temp = listaAdministrativos.get(i);
                    listaAdministrativos.set(i, listaAdministrativos.get(j));
                    listaAdministrativos.set(j, temp);
                }
            }
        }
        for(Administrativo a : listaAdministrativos) System.out.println(a.toString());
    }
}
