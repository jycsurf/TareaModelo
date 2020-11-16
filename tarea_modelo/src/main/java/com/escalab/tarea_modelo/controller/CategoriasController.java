package com.escalab.tarea_modelo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escalab.tarea_modelo.exception.TareaModeloNotFoundException;
import com.escalab.tarea_modelo.model.Categorias;
import com.escalab.tarea_modelo.service.CategoriasService;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriasService service;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> listar() {
		List<Categorias> lista = service.listar();
		return new ResponseEntity<List<Categorias>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categorias> listarPorId(@PathVariable("id") Integer id) {
		if(id != null && id > 0) {
			Categorias categoria = service.leerPorId(id);
			return new ResponseEntity<Categorias>(categoria, HttpStatus.OK);
		}{
			return new ResponseEntity<Categorias>(new Categorias(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Categorias> registrar(@Valid @RequestBody Categorias categorias) {
		Categorias categoria= service.registrar(categorias);
		return new ResponseEntity<Categorias>(categoria, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Categorias> modificar(@Valid @RequestBody Categorias categorias) {
		Categorias categoria = service.modificar(categorias);
		return new ResponseEntity<Categorias>(categoria, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Categorias categoria = service.leerPorId(id);
		if (categoria.getIdCategoria() == null) {
			throw new TareaModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
