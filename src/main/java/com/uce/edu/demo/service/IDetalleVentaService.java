package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

public interface IDetalleVentaService {

	void insertar(DetalleVenta detalleVenta);

	DetalleVenta buscar(Integer id);

	void actualizar(DetalleVenta detalleVenta);

	void borrar(Integer id);
}
