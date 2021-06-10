package com.cibertec.receta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.receta.entity.Categoria;

public interface ICategoriaDAO extends JpaRepository<Categoria, Integer> {

}
