package com.escalab.tarea_modelo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.tarea_modelo.model.Autores;
import com.escalab.tarea_modelo.repo.AutoresRepoInterface;
import com.escalab.tarea_modelo.service.AutoresService;

@Service
public class AutoresServiceImpl implements AutoresService{
	
	@Autowired
	private AutoresRepoInterface repo;

	@Override
	public Autores registrar(Autores obj) {
		return repo.save(obj);
	}

	@Override
	public Autores modificar(Autores obj) {
	    return repo.save(obj);
	}

	@Override
	public List<Autores> listar() {
		return repo.findAll();
	}

	@Override
	public Autores leerPorId(Integer id) {
		Optional<Autores> autor = repo.findById(id);
		if(autor.isPresent()) {
			return autor.get();
		}{
			return new Autores();
		}
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	
}
