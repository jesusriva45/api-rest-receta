package com.cibertec.receta.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.receta.entity.Receta;

public interface IRecetaService {
	
	public abstract List<Receta> listarRecetaXUsuario(int id_usuario);

	public abstract Receta insertaReceta(Receta obj);
	
	public abstract List<Receta> listarReceta();
	
	public abstract Optional<Receta> buscarPorId(int id_receta);
	
	public abstract List<Receta> listearPorCate(int id_categoria);
	
	public abstract void eliminaReceta(Integer id_receta);
	

	
}
