package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoDTO;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Producto buscarCodigoBarras(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras=:codigo", Producto.class);
		myQuery.setParameter("codigo", codigo);
		try {
			return myQuery.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Producto buscarConsultaStockCriteria(String codigoBarras, String nombre, Integer stock) {
		// TODO Auto-generated method stub
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Producto> myQuery = myBuilder.createQuery(Producto.class);
		
		Root<Producto> myTabla = myQuery.from(Producto.class);
		
		Predicate predCogidoBarras = myBuilder.equal(myTabla.get("codigoBarras"), codigoBarras);
		Predicate predNombre = myBuilder.equal(myTabla.get("nombre"), nombre);
		Predicate predStock = myBuilder.equal(myTabla.get("stock"), stock);
		
		Predicate miPredFinal = myBuilder.and(predCogidoBarras,predNombre,predStock);
		
		CriteriaQuery<Producto> myQueryCompleto = myQuery.select(myTabla).where(miPredFinal);
		
		TypedQuery<Producto> myQueryFinal = this.entityManager.createQuery(myQueryCompleto);
		
		return myQueryFinal.getSingleResult();
	}
	
	@Override
	public List<ProductoDTO> reporte(LocalDateTime fecha, String categoria, String cantidad) {
		TypedQuery<ProductoDTO> myQuery = this.entityManager.createQuery(
				"SELECT NEW ec.edu.uce.modelo.ProductoDTO(p.codigoBarras, p.nombre, d.cantidad,d.precioUnitario, d.subtotal) "
						+ "FROM Producto p JOIN p.ventas d JOIN d.idVenta v WHERE p.categoria=:categoria AND v.fecha =:fecha AND d.cantidad>=:cantidad",
				ProductoDTO.class);
		myQuery.setParameter("fecha", fecha);
		myQuery.setParameter("categoria", categoria);
		myQuery.setParameter("cantidad", categoria);
		return myQuery.getResultList();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
