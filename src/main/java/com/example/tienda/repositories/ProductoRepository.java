package com.example.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	

}
