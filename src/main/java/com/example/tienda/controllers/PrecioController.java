package com.example.tienda.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tienda.entities.Precio;

import com.example.tienda.services.PrecioService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/evaluacion/precio")
public class PrecioController {

	// inyeccion de dependencias
	private PrecioService precioService;
	public PrecioController(PrecioService precioService) {

		this.precioService = precioService;

	}

	@GetMapping("")
	public ResponseEntity<?> getAll() {
		try {

			return ResponseEntity.status(HttpStatus.OK).body(precioService.findAll());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		try {
			System.out.println("id:"+ id);
			return ResponseEntity.status(HttpStatus.OK).body(precioService.findById(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}

	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Precio entity) {
		try {
			
			System.out.println("pasa:" +entity.toString());
			
			return ResponseEntity.status(HttpStatus.OK).body(precioService.save(entity));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Precio entity) {
		try {

			return ResponseEntity.status(HttpStatus.OK).body(precioService.update(id, entity));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {

			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(precioService.delete(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}

}
