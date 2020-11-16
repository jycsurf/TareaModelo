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
import com.escalab.tarea_modelo.model.Libros;
import com.escalab.tarea_modelo.service.LibrosService;

@RestController
@RequestMapping("/libros")
public class LibrosController {
	
	@Autowired
	private LibrosService service;
	
	@GetMapping
	public ResponseEntity<List<Libros>> listar() {
		List<Libros> lista = service.listar();
		return new ResponseEntity<List<Libros>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Libros> listarPorId(@PathVariable("id") Integer id) {
		if(id != null && id > 0) {
			Libros libro = service.leerPorId(id);
			return new ResponseEntity<Libros>(libro, HttpStatus.OK);
		}{
			return new ResponseEntity<Libros>(new Libros(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Libros> registrar(@Valid @RequestBody Libros libros) {
		Libros libro= service.registrar(libros);
		return new ResponseEntity<Libros>(libro, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Libros> modificar(@Valid @RequestBody Libros libros) {
		Libros libro = service.modificar(libros);
		return new ResponseEntity<Libros>(libro, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Libros libro = service.leerPorId(id);
		if (libro.getAsin() == null) {
			throw new TareaModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
