package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		// obtener la conexi�n --> unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");

		// generar el manejador de entidades seg�n la conexi�n
		EntityManager em = fabrica.createEntityManager();

		// proceso de eliminar un usuario -> transacci�n (reg, act, elim)
		em.getTransaction().begin();

		// obj Usuario
		Usuario u = new Usuario();
		u.setCodigo(20);
		
		// forma 1. borrado f�sico --> elimina definitivamente  --> delete
		// em.remove(u);  // necesita toda la informaci�n del usuario -> buscar y devolver un obj de usuario

		// forma 2. borrado l�gico -> cambio de estado
		u.setEstado(2);  // necesarrio toda la informaci�n del usuario
		em.merge(u);
		
		// confirmar la transacci�n
		em.getTransaction().commit();

		// cerrar
		em.close();
	}
}
