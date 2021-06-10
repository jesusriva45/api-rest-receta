package com.cibertec.receta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.receta.entity.Categoria;
import com.cibertec.receta.service.ICategoriaService;

@RestController
@RequestMapping("/api")
public class CategoriaControler {
	
	@Autowired
	private ICategoriaService categoriaService;

	@PostMapping("/categoria")
	public ResponseEntity<?> insertaCategoria(@RequestBody Categoria obj){
		Categoria categoriaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			categoriaNew= categoriaService.insertaActualiza(obj);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al insertar en la base de datos" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La categoria ha sigo registrado con éxito");
		response.put("categoria", categoriaNew);

		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
 
	}
	
	@GetMapping("/listacat")
	public ResponseEntity<?> listarCategorias(){
		List<Categoria> categoriaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			categoriaNew=categoriaService.listarCategoria();
		} catch (DataAccessException e) {
			response.put("mensaje","Error al listar categorias" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		response.put("listaCat", categoriaNew);

		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);		
	}
	
	
}
