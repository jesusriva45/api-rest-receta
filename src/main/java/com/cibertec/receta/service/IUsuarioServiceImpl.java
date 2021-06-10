package com.cibertec.receta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.receta.dao.IUsuarioDAO;
import com.cibertec.receta.entity.Usuario;

@Service
public class IUsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDAO usuario;

	@Override
	public Usuario insertaUsuario(Usuario obj) {
		// TODO Auto-generated method stub
		return usuario.save(obj);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return usuario.findAll();
	}

	@Override
	public Optional<Usuario> buscarPorId(int id_usuario) {
		// TODO Auto-generated method stub
		return usuario.findById(id_usuario);
	}
	
}
