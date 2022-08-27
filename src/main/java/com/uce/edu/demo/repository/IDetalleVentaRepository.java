package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

public interface IDetalleVentaRepository {

	void insertar(DetalleVenta detalleVenta);

	DetalleVenta buscar(Integer id);

	void actualizar(DetalleVenta detalleVenta);

	void borrar(Integer id);
	
}
