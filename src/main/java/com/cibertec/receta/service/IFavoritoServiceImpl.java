package com.cibertec.receta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.receta.dao.IFavoritosDAO;
import com.cibertec.receta.entity.Favoritos;

@Service
public class IFavoritoServiceImpl implements IFavoritoService {
	
	@Autowired
	private IFavoritosDAO favoritos;


	@Override
	public Favoritos insertaFavorito(Favoritos obj) {
		// TODO Auto-generated method stub
		return favoritos.save(obj);
	}

	@Override
	public List<Favoritos> listarFavorito() {
		// TODO Auto-generated method stub
		return favoritos.findAll();
	}

	@Override
	public Optional<Favoritos> buscarPorId(int id_favorito) {
		// TODO Auto-generated method stub
		return favoritos.findById(id_favorito);
	}

	@Override
	public List<Favoritos> listarFavoritosXUsuario(int id) {
		return favoritos.listarFavoritosXUsuario(id);
	}

	@Override
	public void eliminaFavoritos(Integer id_favoritos) {
		favoritos.deleteById(id_favoritos);
	}

}
