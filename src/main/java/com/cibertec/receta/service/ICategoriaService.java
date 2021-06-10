package com.cibertec.receta.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.receta.entity.Categoria;

public interface ICategoriaService {
	
	public abstract Categoria insertaActualiza(Categoria obj);
	
	public abstract List<Categoria> listarCategoria();
	
	public abstract Optional<Categoria>  buscarPorID(int id_categoria);

}
