package org.example.modelo;

import org.example.mapeo.Categoria;
import org.example.mapeo.Entidad;
import org.example.utilidades.Lector;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HIbernateCRUD {
    Lector lector = new Lector();


    public void crearEntidad() {
        Session session = null;
        Transaction transaction = null;
        Categoria categoria = null;
        Entidad entidad = null;
        String nombre;
        int categoriaId;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            System.out.print("Introduzca el nombre de la entidad: ");
            nombre = lector.textoScanner();

            System.out.print("Introduzca el ID de la categoría a la que pertenece: ");
            categoriaId = lector.numeroScanner();

            categoria = session.get(Categoria.class, categoriaId);
            if (categoria == null) {
                System.out.println("No se encontró la categoría con ID: " + categoriaId);
                return;
            }


            entidad = new Entidad(nombre, categoria);
            session.save(entidad);

            transaction.commit();
            System.out.println("Entidad creada con ID: " + entidad.getId() + " y categoría: " + categoria.getNombre());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al crear la entidad: " + e.getMessage());
        } finally {
            session.close();
        }
    }


    public void buscarEntidad() {
        Session session = null;
        Entidad entidad;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            System.out.print("Introduzca el ID de la entidad que quieras buscar: ");
            int id = lector.numeroScanner();


            entidad = session.get(Entidad.class, id);
            if (entidad != null) {
                System.out.println("Entidad encontrada: " + entidad);
            } else {
                System.out.println("No se ha encontrado la entidad");
            }
        } catch (Exception e) {
            System.err.println("Error al buscar la entidad: " + e.getMessage());
        } finally {
            session.close();
        }
    }


    public void actualizarEntidad() {
        Session session = null;
        Transaction transaction = null;
        int id;
        Entidad entidad;
        String nuevoNombre;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            System.out.print("Introduzca el ID de la entidad que quieras editar: ");
            id = lector.numeroScanner();


            entidad = session.get(Entidad.class, id);
            if (entidad != null) {
                System.out.print("Introduzca el nuevo nombre para la entidad: ");
                nuevoNombre = lector.textoScanner();
                entidad.setNombre(nuevoNombre);

                transaction = session.beginTransaction();
                session.update(entidad);
                transaction.commit();
                System.out.println("Entidad actualizada");
            } else {
                System.out.println("No se encontró la entidad");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al editar la entidad: " + e.getMessage());
        } finally {
            session.close();
        }
    }


    public void eliminarEntidad() {
        Session session = null;
        Transaction transaction = null;
        Entidad entidad = null;
        int id;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            System.out.print("Introduzca el ID de la entidad que quieras eliminar: ");
            id = lector.numeroScanner();

            entidad = session.get(Entidad.class, id);
            if (entidad != null) {
                transaction = session.beginTransaction();
                session.delete(entidad);
                transaction.commit();
                System.out.println("Entidad eliminada");
            } else {
                System.out.println("No se encontró la entidad");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al eliminar la entidad: " + e.getMessage());
        } finally {
            session.close();
        }
    }


    public void mostrarEntidades() {
        Session session = null;
        List<Entidad> entidades = new ArrayList<>();

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            entidades = session.createQuery("FROM Entidad", Entidad.class).list();
            for (Entidad entidad : entidades) {
                System.out.println("Entidad: " + entidad.getNombre() + ", Categoría: " + entidad.getCategoria().getNombre());
            }
        } catch (Exception e) {
            System.err.println("Error al mostrar las entidades: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void crearCategoria() {
        Session session = null;
        Transaction transaction = null;
        String nombre;
        Categoria categoria = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            System.out.print("Introduzca el nombre de la nueva categoría: ");
            nombre = lector.textoScanner();

            categoria = new Categoria(nombre);
            session.save(categoria);

            transaction.commit();
            System.out.println("Categoría creada y su ID es: " + categoria.getId());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al crear la categoría: " + e.getMessage());
        } finally {
            session.close();
        }
    }


    public void buscarCategoria() {
        Session session = null;
        int id;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            System.out.print("Introduzca el ID de la categoría que quieras buscar: ");
            id = lector.numeroScanner();

            Categoria categoria = session.get(Categoria.class, id);
            if (categoria != null) {
                System.out.println("Categoría encontrada: " + categoria);
            } else {
                System.out.println("No se ha encontrado la categoría");
            }
        } catch (Exception e) {
            System.err.println("Error al buscar la categoría: " + e.getMessage());
        } finally {
            session.close();
        }
    }


    public void actualizarCategoria() {
        Session session = null;
        Transaction transaction = null;
        int id;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            System.out.print("Introduzca el ID de la categoría que quieras editar: ");
            id = lector.numeroScanner();
            String nuevoNombre;

            Categoria categoria = session.get(Categoria.class, id);
            if (categoria != null) {
                System.out.print("Introduzca el nuevo nombre para la categoría: ");
                nuevoNombre = lector.textoScanner();
                categoria.setNombre(nuevoNombre);

                transaction = session.beginTransaction();
                session.update(categoria);
                transaction.commit();
                System.out.println("Categoría actualizada: " + categoria);
            } else {
                System.out.println("No se encontró la categoría");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al actualizar la categoría: " + e.getMessage());
        } finally {
            session.close();
        }
    }


    public void eliminarCategoria() {
        Session session = null;
        Transaction transaction = null;
        int id;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            System.out.print("Introduzca el ID de la categoría que quieras eliminar: ");
            id = lector.numeroScanner();

            Categoria categoria = session.get(Categoria.class, id);
            if (categoria != null) {
                transaction = session.beginTransaction();
                session.delete(categoria);
                transaction.commit();
                System.out.println("Categoría eliminada");
            } else {
                System.out.println("No se encontró la categoría");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error al eliminar la categoría: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
