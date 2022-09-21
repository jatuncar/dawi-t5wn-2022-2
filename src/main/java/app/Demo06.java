package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo06 {
	// listado de todos los usuarios
	public static void main(String[] args) {
		// obtener la conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// proceso --> listado --> no se utiliza ...getTrans..().begin
		// select * from tb_xxxx ---> colección List<Entidad> / ArrayList<Entidad>
		// createNamedQuery -> llamar a una consulta asociada a un nombre 
		// createNativeQuery --> ejecutar una consulta en SQL nativo -> con bd no normaliz.
		// createQuery --> ejecutar una consulta SQL + JPA (Entidades) -> JPQL
		//                                         select * from tb_xxxx
		List<Usuario> lstUsuarios = 
				em.createQuery("select y from Usuario y", Usuario.class).getResultList();
		
		System.out.println("Listado");
		for (Usuario u : lstUsuarios) {
			System.out.println("Código..:" + u.getCodigo());
			System.out.println("Nombre..:" + u.getNombre() + " " + u.getApellido());
			System.out.println("Tipo....:" + u.getTipo() + "-" + u.getObjTipo().getDescripcion());
			System.out.println("------------------------------------");
		}
		// cerrar
		em.close();
	}
}
