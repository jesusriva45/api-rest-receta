package com.cibertec.receta.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.receta.entity.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{

}
