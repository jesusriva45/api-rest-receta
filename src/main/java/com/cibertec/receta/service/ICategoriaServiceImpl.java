package com.cibertec.receta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.receta.dao.ICategoriaDAO;
import com.cibertec.receta.entity.Categoria;

@Service
public class ICategoriaServiceImpl  implements ICategoriaService{

	@Autowired
	private ICategoriaDAO categoria;
	
	@Override
	public Categoria insertaActualiza(Categoria obj) {
		// TODO Auto-generated method stub
		return categoria.save(obj);
	}

	@Override
	public List<Categoria> listarCategoria() {
		// TODO Auto-generated method stub
		return categoria.findAll();
	}

	@Override
	public Optional<Categoria> buscarPorID(int id_categoria) {
		// TODO Auto-generated method stub
		return categoria.findById(id_categoria);
	}

}
