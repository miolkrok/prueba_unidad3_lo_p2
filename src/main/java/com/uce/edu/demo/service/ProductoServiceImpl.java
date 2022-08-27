package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoDTO;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional
	public void insertar(Producto producto) {
		this.productoRepository.insertar(producto);
	}

	@Override
	public Producto buscar(Integer id) {
		return this.productoRepository.buscar(id);
	}

	@Override
	@Transactional
	public void actualizar(Producto producto) {
		this.productoRepository.actualizar(producto);
	}

	@Override
	public void borrar(Integer id) {
		this.productoRepository.borrar(id);
	}

	@Override
	public Producto buscarCodigoBarras(String codigo) {
		return this.productoRepository.buscarCodigoBarras(codigo);
	}

	@Override
	public Producto buscarConsultaStockCriteria(String codigoBarras, String nombre, Integer stock) {
		// TODO Auto-generated method stub
		return this.productoRepository.buscarConsultaStockCriteria(codigoBarras,nombre,stock);
	}

	@Override
	public List<ProductoDTO> reporte(LocalDateTime fecha, String categoria, String cantidad) {
		// TODO Auto-generated method stub
		return this.productoRepository.reporte(fecha, categoria, cantidad);
	}
}
