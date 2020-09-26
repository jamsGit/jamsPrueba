package com.example.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tienda.entities.Precio;

@Repository
public interface PrecioRepository extends JpaRepository<Precio, Long> {

}
