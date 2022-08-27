package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Venta;

public interface IVentaRepository {

	void insertar(Venta venta);

	Venta buscar(Integer id);

	void actualizar(Venta venta);

	void borrar(Integer id);
}
