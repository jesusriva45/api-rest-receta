package com.cibertec.receta.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.receta.entity.Favoritos;
import com.cibertec.receta.entity.Receta;

public interface IFavoritoService {

	public abstract List<Favoritos> listarFavoritosXUsuario(int id);
	
	public abstract Favoritos insertaFavorito(Favoritos obj);
	
	public abstract List<Favoritos> listarFavorito();
	
	public abstract Optional<Favoritos> buscarPorId(int id_favorito);
	
	public abstract void eliminaFavoritos(Integer id_favoritos);
}
