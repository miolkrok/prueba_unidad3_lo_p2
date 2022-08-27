package com.uce.edu.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService{

	@Autowired
	private IDetalleVentaRepository detalleVentaRepository;

	@Override
	@Transactional
	public void insertar(DetalleVenta detalleVenta) {
		this.detalleVentaRepository.insertar(detalleVenta);
	}

	@Override
	public DetalleVenta buscar(Integer id) {
		return this.detalleVentaRepository.buscar(id);
	}

	@Override
	@Transactional
	public void actualizar(DetalleVenta detalleVenta) {
		 this.detalleVentaRepository.actualizar(detalleVenta);
	}

	@Override
	public void borrar(Integer id) {
		this.detalleVentaRepository.borrar(id);
	}
}
