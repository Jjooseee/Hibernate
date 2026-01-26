package org.example.vista;

import org.example.modelo.HIbernateCRUD;
import org.example.utilidades.Lector;


public class Menu {
    Lector lector = new Lector();
    HIbernateCRUD crud = new HIbernateCRUD();
    int opcion;

    public void menuPrincipal() {
        {

            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear entidad");
            System.out.println("2. Buscar entidad");
            System.out.println("3. Editar entidad");
            System.out.println("4. Eliminar entidad");
            System.out.println("5. Mostrar todas las entidades");
            System.out.println("6. Crear categoria");
            System.out.println("7. Buscar categoria");
            System.out.println("8. Editar categoria");
            System.out.println("9. Eliminar categoria");
            System.out.println("10. Salir");
            opcion = lector.numeroScanner();


            switch (opcion) {
                case 1:
                    crud.crearEntidad();
                    break;
                case 2:
                    crud.buscarEntidad();
                    break;
                case 3:
                    crud.actualizarEntidad();
                    break;
                case 4:
                    crud.eliminarEntidad();
                    break;
                case 5:
                    crud.mostrarEntidades();
                    break;
                case 6:
                    crud.crearCategoria();
                    break;
                case 7:
                    crud.buscarCategoria();
                    break;
                case 8:
                    crud.actualizarCategoria();
                    break;
                case 9:
                    crud.eliminarCategoria();
                    break;
                case 10:
                    System.out.println("Salir.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }while (opcion != 10);
    }
}
