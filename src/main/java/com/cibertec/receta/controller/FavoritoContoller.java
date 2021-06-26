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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.receta.entity.Favoritos;
import com.cibertec.receta.service.IFavoritoService;

@RestController
@RequestMapping("/api")
public class FavoritoContoller {
	
	@Autowired
	private IFavoritoService favoritosService;
	
	@PostMapping("/favoritos")
	public ResponseEntity<?> insertaFavoritos(@RequestBody Favoritos obj) {
		Favoritos bean = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			bean = favoritosService.insertaFavorito(obj);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al insertar en la base de datos" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Favorito ha sido registrado con éxito");
		response.put("favorito", bean);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/listarfavoritos/")
	public ResponseEntity<?> Lista() {
		List<Favoritos> bean = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			bean = favoritosService.listarFavorito();
		} catch (DataAccessException e) {
			response.put("mensaje","Error al listar favoritos" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("listaFavoritos", bean);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	@GetMapping("/favoritos/{id}")
	public ResponseEntity<Optional<Favoritos>> obtenerFavoritosPorId(@PathVariable int id) {
		Optional<Favoritos> bean = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			bean = favoritosService.buscarPorId(id);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al buscar favoritos" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
		}
		
		response.put("listaFavoritos", bean);

		return  ResponseEntity.ok(bean);
		
	}
	
	@GetMapping("/favoritosxusuario/{id}")
	public ResponseEntity<?> listaRecetaXUsuario(@PathVariable int id){
		List<Favoritos> bean = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			bean=favoritosService.listarFavoritosXUsuario(id);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al listar favoritos" );
			response.put("error", e.getMessage()+" : "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		response.put("listaReceta", bean);

		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);		
	}
	
	@DeleteMapping("/eliminaFavoritos")
	public Map<String, Object> elimina(Integer id_favoritos) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Optional<Favoritos> option = favoritosService.buscarPorId(id_favoritos);
			
		try {
			if(option.isPresent()) {
				favoritosService.eliminaFavoritos(id_favoritos);
				salida.put("MENSAJE", "¡Eliminación exitosa!");
			} else {
				salida.put("MENSAJE", "Error, el id no existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("MENSAJE", "Error, no pudo ser eliminado");
		} finally {
			List<Favoritos> lista = favoritosService.listarFavorito();
			salida.put("lista", lista);
		}
		
		return salida;
	}
	
}
