package com.cibertec.receta.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.receta.entity.Usuario;

public interface IUsuarioService {
	
	public abstract Usuario insertaUsuario(Usuario obj);
	
	public abstract List<Usuario> listarUsuarios();
	
	public Optional<Usuario> buscarPorId(int id_usuario);

}
