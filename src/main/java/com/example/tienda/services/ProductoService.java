package com.example.tienda.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.tienda.entities.Producto;
import com.example.tienda.repositories.ProductoRepository;

//@Serviceindicar que la clase es un servicio
@Service
public class ProductoService implements BaseService<Producto> {

	// inyeccion de dependencias @Autowired, en vez del contructor

	// @Autowired
	private ProductoRepository productoRepository;

	// inyeccion de dependencias
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
  
	@Override
	// begin, commit, roolback @Transactional
	@Transactional
	public List<Producto> findAll() throws Exception {
		try {

			List<Producto> entities = productoRepository.findAll();
			return entities;

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Producto findById(Long id) throws Exception {
		try {

			Optional<Producto> entityOptional = productoRepository.findById(id);
			//System.out.println(entityOptional.get());
			return entityOptional.get();
		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Producto save(Producto entity) throws Exception {
		try {

			entity = productoRepository.save(entity);
			return entity;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Producto update(Long id, Producto entity) throws Exception {
		try {

			Optional<Producto> entityOptional = productoRepository.findById(id);
			
			Producto producto = entityOptional.get();
			producto = productoRepository.save(entity);
			return producto;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try {

			if (productoRepository.existsById(id)) {
				productoRepository.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
