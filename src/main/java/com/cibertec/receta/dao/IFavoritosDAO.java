package com.cibertec.receta.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.receta.entity.Favoritos;

public interface IFavoritosDAO extends JpaRepository<Favoritos, Integer>{
	
	@Query("Select f from Favoritos f where f.usuario.id_usuario = :id")
	public abstract List<Favoritos> listarFavoritosXUsuario(@Param("id") int id);
	
}
