package com.cibertec.receta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.receta.entity.Categoria;
import com.cibertec.receta.entity.Receta;
import com.cibertec.receta.service.IRecetaService;
import com.cibertec.receta.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class FavoritoContoller {
	
	
	
}
