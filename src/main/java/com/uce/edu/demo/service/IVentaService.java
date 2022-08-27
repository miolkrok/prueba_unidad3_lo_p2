package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Venta;

public interface IVentaService {

	void insertar(Venta venta);

	Venta buscar(Integer id);

	void actualizar(Venta venta);

	void borrar(Integer id);
	
}
