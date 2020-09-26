package com.example.tienda.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.tienda.entities.Precio;

import com.example.tienda.repositories.PrecioRepository;

//clases
@Service
public class PrecioService  implements BaseService<Precio> {
	
	PrecioRepository precioRepository;
	
	public PrecioService(PrecioRepository precioRepository) {
		this.precioRepository =  precioRepository;
	}

	@Override
	@Transactional
	public List<Precio> findAll() throws Exception {
		try {

			List<Precio> entities = precioRepository.findAll();
			return entities;

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Precio findById(Long id) throws Exception {
		try {

			Optional<Precio> entityOptional = precioRepository.findById(id);
			//System.out.println(entityOptional.get());
			return entityOptional.get();
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Precio save(Precio entity) throws Exception {
		try {

			entity = precioRepository.save(entity);
			return entity;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Precio update(Long id, Precio entity) throws Exception {
		try {

			Optional<Precio> entityOptional = precioRepository.findById(id);
			
			Precio precio = entityOptional.get();
			precio = precioRepository.save(entity);
			return precio;
			

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try {

			if (precioRepository.existsById(id)) {
				precioRepository.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}



}
