package org.example.utilidades;

import java.util.Scanner;

public class Lector {
    Scanner scn = new Scanner(System.in);

    public String textoScanner() {
        return scn.nextLine();
    }

    public int numeroScanner() {
        int numero = 0;
        String entrada = "";
        entrada = scn.nextLine();

        numero = Integer.parseInt(entrada);
        return numero;

    }
}
