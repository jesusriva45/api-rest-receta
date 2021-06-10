package com.cibertec.receta.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.receta.entity.Usuario;
import com.cibertec.receta.service.IUsuarioService;


@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private IUsuarioService usurioService;
	
	
	@PostMapping("/usuario")
	public ResponseEntity<?> insertaReceta(@RequestBody Usuario obj){
		Usuario UsuarioNew = null;
		Map<String, Object> response = new HashMap<>();
		try {	
			UsuarioNew= usurioService.insertaUsuario(obj);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al insertar en la base de datos" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		response.put("mensaje", "La Receta ha sigo registrado con éxito");
		response.put("categoria", UsuarioNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	
}
