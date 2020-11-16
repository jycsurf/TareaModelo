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
import com.escalab.tarea_modelo.model.Autores;
import com.escalab.tarea_modelo.service.AutoresService;


@RestController
@RequestMapping("/autores")
public class AutoresController {

	@Autowired
	private AutoresService autoresService;

	@GetMapping
	public ResponseEntity<List<Autores>> listar() {
		List<Autores> lista = autoresService.listar();
		return new ResponseEntity<List<Autores>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Autores> listarPorId(@PathVariable("id") Integer id) {
		if(id != null && id > 0) {
			Autores autores = autoresService.leerPorId(id);
			return new ResponseEntity<Autores>(autores, HttpStatus.OK);
		}{
			return new ResponseEntity<Autores>(new Autores(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Autores> registrar(@Valid @RequestBody Autores autores) {
		Autores autor = autoresService.registrar(autores);
		return new ResponseEntity<Autores>(autor, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Autores> modificar(@Valid @RequestBody Autores autores) {
		Autores autor = autoresService.modificar(autores);
		return new ResponseEntity<Autores>(autor, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Autores autor = autoresService.leerPorId(id);
		if (autor.getIdAutor() == null) {
			throw new TareaModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		autoresService.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
