package org.example.vista;

import org.example.modelo.HIbernateCRUD;
import org.example.utilidades.Lector;


public class Menu {
    Lector lector = new Lector();
    HIbernateCRUD crud = new HIbernateCRUD();
    int opcion;

 {

        System.out.println("Seleccione una opción:");
        System.out.println("1. Crear entidad");
        System.out.println("2. Buscar entidad");
        System.out.println("3. Editar entidad");
        System.out.println("4. Eliminar entidad");
        System.out.println("5. Salir");
        opcion = lector.numeroScanner();


        switch (opcion) {
            case 1:
                crud.crearEntidad();
                break;
            case 2:
                crud.buscarEntidad();
                break;
            case 3:
                crud.editarEntidad();
                break;
            case 4:
                crud.eliminarEntidad();
                break;
            case 5:
                System.out.println("Salir.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
