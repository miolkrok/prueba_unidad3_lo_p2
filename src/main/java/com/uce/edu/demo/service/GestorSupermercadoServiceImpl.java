package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class GestorSupermercadoServiceImpl implements IGestorSupermercadoService{
	
	@Autowired
	private IProductoService productoService;

	@Autowired
	private IVentaService ventaService;

	@Autowired
	private IDetalleVentaService detalleVentaService;

	@Override
	@Transactional
	public void ingresarProducto(Producto producto) {
		// TODO Auto-generated method stub
		Producto prod = this.productoService.buscarCodigoBarras(producto.getCodigoBarras());

		if (prod == null) {
			this.productoService.insertar(producto);
//			LOG.info("aqui");
		} else {
			prod.setStock(prod.getStock() + producto.getStock());
			this.productoService.actualizar(prod);
		}
	}


	
	@Override
	@Transactional//(value = TxType.REQUIRED)
	public void realizarVenta(List<Producto> lista, Integer cantidad, String cedulaCliente, String numeroVenta) {
		// TODO Auto-generated method stub

		for (Producto producto : lista) {
		Producto p = this.productoService.buscarCodigoBarras(producto.getCodigoBarras());
		if (producto.getStock() < p.getStock()) {
			
			Venta v = new Venta();
			v.setCedulaCliente(cedulaCliente);
			v.setFecha(LocalDateTime.now());
			v.setNumero(numeroVenta);
			
			List<DetalleVenta> listaVenta = new ArrayList<>();
			DetalleVenta d = new DetalleVenta();
			d.setVenta(v);
			v.setDetallesVentaV(listaVenta);
			d.setCantidad(cantidad);
			d.setProducto(producto);
			d.setVenta(v);
			d.setPrecioUnitario(producto.getPrecio());
			d.setSubtotal(p.getPrecio().add(new BigDecimal(producto.getStock())));
			listaVenta.add(d);
			v.setDetallesVentaV(listaVenta);
			this.ventaService.insertar(v);
			this.detalleVentaService.insertar(d);
			
		} else {
			throw new RuntimeException();
		}
	}
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto consultarStock(String codigoBarras, String nombre, Integer stock) {
		// TODO Auto-generated method stub
		return this.productoService.buscarConsultaStockCriteria(codigoBarras, nombre, stock);
	}
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void reporteVentas(LocalDateTime fechaVenta, String categoria, String cantidad) {
		// TODO Auto-generated method stub
		this.productoService.reporte(fechaVenta, categoria, cantidad);
	}





}
