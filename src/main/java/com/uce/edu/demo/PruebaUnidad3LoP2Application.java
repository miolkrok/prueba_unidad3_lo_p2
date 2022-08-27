package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.IGestorSupermercadoService;

@SpringBootApplication
public class PruebaUnidad3LoP2Application implements CommandLineRunner{
	
	
	@Autowired
	private IGestorSupermercadoService supermercadoService;
	
	private static final Logger LOG = LoggerFactory.getLogger(PruebaUnidad3LoP2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3LoP2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Producto p1 = new Producto();
		p1.setCategoria("Carnes");
		p1.setNombre("Lomo Fino");
		p1.setCodigoBarras("9489");
		p1.setPrecio(new BigDecimal(3.55));
		p1.setStock(20);
//		this.supermercadoService.ingresarProducto(p1);
		
		Producto p2 = new Producto();
		p2.setCategoria("Carnes");
		p2.setNombre("Lomo Fino");
		p2.setCodigoBarras("9489");
		p2.setPrecio(new BigDecimal(3.55));
		p2.setStock(10);
		
//		this.supermercadoService.ingresarProducto(p2);
		
		Producto p3 = new Producto();
		p3.setCategoria("Lacteos");
		p3.setNombre("Leche");
		p3.setCodigoBarras("4654");
		p3.setPrecio(new BigDecimal(1.45));
		p3.setStock(35);
//		this.supermercadoService.ingresarProducto(p3);
		
		Producto p4 = new Producto();
		p4.setCategoria("Lacteos");
		p4.setNombre("Leche");
		p4.setCodigoBarras("4654");
		p4.setPrecio(new BigDecimal(1.45));
		p4.setStock(45);
		
//		this.supermercadoService.ingresarProducto(p4);
		
//		Producto pro = this.supermercadoService.consultarStock("9489", "Lomo Fino", 30);
//		LOG.info("Producto: " +pro.getCodigoBarras()+ " " + pro.getNombre() + " " + pro.getStock());
		
		Producto prodCompra = new Producto();
		prodCompra.setCodigoBarras("9489");
		prodCompra.setNombre("Lomo Fino");
		prodCompra.setStock(2);
		
		Producto prodCompra2 = new Producto();
		prodCompra2.setCodigoBarras("4654");
		prodCompra2.setNombre("Leche");
		prodCompra2.setStock(2);
		
		List<Producto> listaCompra = new ArrayList<>();
		
		listaCompra.add(prodCompra);
		listaCompra.add(prodCompra2);
		
		this.supermercadoService.realizarVenta(listaCompra, 2, "1718496944", "1234");
	}

}
