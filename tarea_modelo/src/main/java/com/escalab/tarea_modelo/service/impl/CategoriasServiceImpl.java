package com.escalab.tarea_modelo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.escalab.tarea_modelo.model.Categorias;
import com.escalab.tarea_modelo.repo.CategoriasRepoInterface;
import com.escalab.tarea_modelo.service.CategoriasService;

@Service
public class CategoriasServiceImpl implements CategoriasService{
	
	@Autowired
	private CategoriasRepoInterface repo;

	@Override
	public Categorias registrar(Categorias obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public Categorias modificar(Categorias obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Categorias> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Categorias leerPorId(Integer id) {
		Optional<Categorias> categoria = repo.findById(id);
		if(categoria.isPresent()) {
			return categoria.get();
		}{
			return new Categorias();
		}
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	} 
	
}