package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		// obtener la conexión --> unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");

		// generar el manejador de entidades según la conexión
		EntityManager em = fabrica.createEntityManager();

		// proceso de eliminar un usuario -> transacción (reg, act, elim)
		em.getTransaction().begin();

		// obj Usuario
		Usuario u = new Usuario();
		u.setCodigo(20);
		
		// forma 1. borrado físico --> elimina definitivamente  --> delete
		// em.remove(u);  // necesita toda la información del usuario -> buscar y devolver un obj de usuario

		// forma 2. borrado lógico -> cambio de estado
		u.setEstado(2);  // necesarrio toda la información del usuario
		em.merge(u);
		
		// confirmar la transacción
		em.getTransaction().commit();

		// cerrar
		em.close();
	}
}
