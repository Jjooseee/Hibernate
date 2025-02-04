package org.example.modelo;

import org.example.utilidades.Lector;

public class HIbernateCRUD {
    Lector lector = new Lector();
    // Crear una nueva entidad
    public static void crearEntidad() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            System.out.print("Introduzca el nombre de la nueva entidad: ");
            String nombre = scanner.nextLine();
            Entidad entidad = new Entidad(nombre);
            session.save(entidad);
            transaction.commit();
            System.out.println("Entidad creada con ID: " + entidad.getId());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al crear la entidad: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Buscar una entidad por ID
    public static void buscarEntidad() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            System.out.print("Introduzca el ID de la entidad que desea buscar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            Entidad entidad = session.get(Entidad.class, id);
            if (entidad != null) {
                System.out.println("Entidad encontrada: " + entidad);
            } else {
                System.out.println("No se encontró la entidad con ID: " + id);
            }
        } catch (Exception e) {
            System.err.println("Error al buscar la entidad: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Editar una entidad
    public static void editarEntidad() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            System.out.print("Introduzca el ID de la entidad que desea editar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            Entidad entidad = session.get(Entidad.class, id);
            if (entidad != null) {
                System.out.print("Introduzca el nuevo nombre para la entidad: ");
                String nuevoNombre = scanner.nextLine();
                entidad.setNombre(nuevoNombre);

                transaction = session.beginTransaction();
                session.update(entidad);
                transaction.commit();
                System.out.println("Entidad actualizada: " + entidad);
            } else {
                System.out.println("No se encontró la entidad con ID: " + id);
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al editar la entidad: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    // Eliminar una entidad
    public static void eliminarEntidad() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            System.out.print("Introduzca el ID de la entidad que desea eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            Entidad entidad = session.get(Entidad.class, id);
            if (entidad != null) {
                transaction = session.beginTransaction();
                session.delete(entidad);
                transaction.commit();
                System.out.println("Entidad eliminada con ID: " + id);
            } else {
                System.out.println("No se encontró la entidad con ID: " + id);
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al eliminar la entidad: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
