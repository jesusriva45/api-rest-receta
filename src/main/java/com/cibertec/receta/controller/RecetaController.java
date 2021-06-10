package com.cibertec.receta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.receta.entity.Receta;
import com.cibertec.receta.service.IRecetaService;

@RestController
@RequestMapping("/api")
public class RecetaController {
	
	@Autowired
	private IRecetaService recetaService;
	
	
	@PostMapping("/receta")
	public ResponseEntity<?> insertaReceta(@RequestBody Receta obj){
		Receta RecetaNew = null;
		Map<String, Object> response = new HashMap<>();
		try {	
			RecetaNew= recetaService.insertaReceta(obj);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al insertar en la base de datos" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		response.put("mensaje", "La Receta ha sigo registrado con éxito");
		response.put("categoria", RecetaNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
 
	}
	
	
	
	@GetMapping("/listarecetas/")
	public ResponseEntity<?> Lista(){
		List<Receta> recetaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			recetaNew=recetaService.listarReceta();
		} catch (DataAccessException e) {
			response.put("mensaje","Error al listar categorias" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);		
		}		
		response.put("listaReceta", recetaNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);		
	}
	
	
	@GetMapping("/receta/{id}")
	public ResponseEntity<Optional<Receta>> obtenerRecetaPorId(@PathVariable int id){
		Optional<Receta> recetaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			recetaNew=recetaService.buscarPorId(id);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al listar categorias" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
			//return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		response.put("listaReceta", recetaNew);

		
		return  ResponseEntity.ok(recetaNew);		
	}
	
	
	@GetMapping("/recetasxuuario/{id}")
	public ResponseEntity<?> listaRecetaXUsuario(@PathVariable int id){
		List<Receta> recetaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			recetaNew=recetaService.listarRecetaXUsuario(id);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al listar categorias" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		response.put("listaReceta", recetaNew);

		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);		
	}
	
	
	@GetMapping("/recetasxcategoria/{idcat}")
	public ResponseEntity<?> listaRecetaXCategoria(@PathVariable int idcat){
		List<Receta> recetaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			recetaNew=recetaService.listearPorCate(idcat);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al listar categorias" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		response.put("listaRecetaXCat", recetaNew);

		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);		
	}
	
	
	@DeleteMapping("/eliminaReceta")
	public Map<String, Object> elimina(Integer id_receta) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Optional<Receta> option = recetaService.buscarPorId(id_receta);
			
		try {
			if(option.isPresent()) {
				recetaService.eliminaReceta(id_receta);
				salida.put("MENSAJE", "¡Eliminación exitosa!");
			} else {
				salida.put("MENSAJE", "Error, el producto no existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("MENSAJE", "Error, la mascota no pudo ser eliminada");
		} finally {
			List<Receta> lista = recetaService.listarReceta();
			salida.put("lista", lista);
		}
		
		return salida;
	}
	
	
	
}
