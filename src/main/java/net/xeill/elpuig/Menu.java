package net.xeill.elpuig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class

Menu {
    private int option;

    public Menu() {
        super();
    }

    public int mainMenu() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println(" \nMENU PRINCIPAL \n");
            System.out.println("Escull una opció: ");
            System.out.println("1. Listar elementos");
            System.out.println("2. Seleccionar todos los elementos que cumplan una condición");
            System.out.println("3. Muestra la información de las tablas");
            System.out.println("4. Eliminar varios elementos");
            System.out.println("5. Eliminar algun elemento en concreto");
            System.out.println("6. Seleccionar elementos concretos.");
            System.out.println("7. Modificar algun dato en concreto");
            System.out.println("8. Modificar diversos datos o registros");
            System.out.println("9. Salir");

            System.out.println("Escoge una opción: ");
            try {
                option = Integer.parseInt(br.readLine());
            } catch (NumberFormatException | IOException e) {
                System.out.println("valor no vàlid");
                e.printStackTrace();
            }
        } while (option != 1  && option != 0);

        return option;
    }
}
