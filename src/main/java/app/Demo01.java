package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		// obtener la conexión --> unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		
		// generar el manejador de entidades según la conexión
		EntityManager em = fabrica.createEntityManager();
		
		// proceso de registro de un nuevo usuario -> transacción (reg, act, elim)
		em.getTransaction().begin();
		
		// obj Usuario
		// Usuario u = new Usuario(20, "Juan", "Perez", "jperez", "55555", "2000/10/05", 1, 1);
		Usuario u = new Usuario();
		u.setCodigo(20);
		u.setNombre("Juan");
		// completar
		
		em.persist(u);
		
		// confirmar la transacción
		em.getTransaction().commit();
		
		// cerrar
		em.close();
	}
}
