package lector;

import java.util.Scanner;

public class Lector {
    private static Scanner scanner = new Scanner(System.in);

    public static String leer(String pregunta) {
        System.out.println(pregunta);
        return scanner.nextLine();
    }
}
