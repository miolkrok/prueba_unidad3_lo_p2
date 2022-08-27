package com.uce.edu.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaRepository ventaRepository;

	@Override
	@Transactional
	public void insertar(Venta venta) {
		this.ventaRepository.insertar(venta);
	}

	@Override
	public Venta buscar(Integer id) {
		return this.ventaRepository.buscar(id);
	}

	@Override
	@Transactional
	public void actualizar(Venta venta) {
		this.ventaRepository.actualizar(venta);
	}

	@Override
	public void borrar(Integer id) {
		this.ventaRepository.borrar(id);
	}
}
