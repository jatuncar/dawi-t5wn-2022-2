package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

public class Demo06_Producto {
	// listado de todos los usuarios
	public static void main(String[] args) {
		// obtener la conexi�n
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		List<Producto> lstProductos = 
				em.createQuery("select p from Producto p", Producto.class).getResultList();
		
		System.out.println("Listado");
		for (Producto p : lstProductos) {
			System.out.println("C�digo..:" + p.getId_prod());
			System.out.println("Nombre..:" + p.getDes_prod());
			System.out.println("Stock...:" + p.getStk_prod());
			System.out.println("Precio..:" + p.getPre_prod());
			System.out.println("Categor�a...:" + p.getIdcategoria() + '-' +
								p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor...:" + p.getIdproveedor() + '-' +
								p.getObjProveedor().getNombre_rs());
			System.out.println("------------------------------------");
		}
		// cerrar
		em.close();
	}
}
