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
import com.escalab.tarea_modelo.model.Editoriales;
import com.escalab.tarea_modelo.service.EditorialesService;

@RestController
@RequestMapping("/editoriales")
public class EditorialesController {
	
	@Autowired
	private EditorialesService service;
	
	@GetMapping
	public ResponseEntity<List<Editoriales>> listar() {
		List<Editoriales> lista = service.listar();
		return new ResponseEntity<List<Editoriales>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Editoriales> listarPorId(@PathVariable("id") Integer id) {
		if(id != null && id > 0) {
			Editoriales editorial = service.leerPorId(id);
			return new ResponseEntity<Editoriales>(editorial, HttpStatus.OK);
		}{
			return new ResponseEntity<Editoriales>(new Editoriales(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Editoriales> registrar(@Valid @RequestBody Editoriales editoriales) {
		Editoriales editorial= service.registrar(editoriales);
		return new ResponseEntity<Editoriales>(editorial, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Editoriales> modificar(@Valid @RequestBody Editoriales editoriales) {
		Editoriales editorial = service.modificar(editoriales);
		return new ResponseEntity<Editoriales>(editorial, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Editoriales editorial = service.leerPorId(id);
		if (editorial.getIdEditorial() == null) {
			throw new TareaModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	

}
