package com.cibertec.receta.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.cibertec.receta.entity.Favoritos;

public interface IFavoritosDAO extends JpaRepository<Favoritos, Integer>{

}
