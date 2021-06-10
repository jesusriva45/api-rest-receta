package com.cibertec.receta.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.receta.entity.Categoria;
import com.cibertec.receta.entity.Receta;

public interface IRecetaDAO extends JpaRepository<Receta, Integer>{
	
	public abstract List<Receta> findByCategoria(Categoria categoria);
	
	@Query("select r from Receta r inner join Favoritos f on f.receta.id_receta=r.id_receta where f.usuario.id_usuario=:id")
	public abstract List<Receta> listarRecetaXUsuario(@Param("id") int id);

}
