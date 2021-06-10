package com.cibertec.receta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.receta.dao.IRecetaDAO;
import com.cibertec.receta.entity.Categoria;
import com.cibertec.receta.entity.Receta;

@Service
public class IRecetaServiceImpl  implements IRecetaService{
	
	@Autowired
	private IRecetaDAO receta;
	
	@Override
	public List<Receta> listarRecetaXUsuario(int id_usuario) {
		// TODO Auto-generated method stub
		return receta.listarRecetaXUsuario(id_usuario);
	}

	@Override
	public Receta insertaReceta(Receta obj) {
		// TODO Auto-generated method stub
		return receta.save(obj);
	}

	@Override
	public List<Receta> listarReceta() {
		// TODO Auto-generated method stub
		return receta.findAll();
	}

	@Override
	public Optional<Receta> buscarPorId(int id_receta) {
		// TODO Auto-generated method stub
		return receta.findById(id_receta);
	}

	@Override
	public List<Receta> listearPorCate(int id_categoria) {
		// TODO Auto-generated method stub
		Categoria categoria = new Categoria();
		categoria.setId_cate_receta(id_categoria);
		return receta.findByCategoria(categoria);
	}

	@Override
	public void eliminaReceta(Integer id_receta) {
		 receta.deleteById(id_receta);
		
	}

}
