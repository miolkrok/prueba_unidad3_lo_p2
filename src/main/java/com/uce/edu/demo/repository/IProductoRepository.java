package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoDTO;

public interface IProductoRepository {

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public Producto buscar(Integer id);

	public void borrar(Integer id);

	public Producto buscarCodigoBarras(String codigo);

	public Producto buscarConsultaStockCriteria(String codigoBarras, String nombre, Integer stock);
	
	public List<ProductoDTO> reporte(LocalDateTime fecha, String categoria, String cantidad);

}
