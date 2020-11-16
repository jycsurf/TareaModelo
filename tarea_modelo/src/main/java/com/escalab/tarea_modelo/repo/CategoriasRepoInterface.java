package com.escalab.tarea_modelo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escalab.tarea_modelo.model.Categorias;

@Repository
public interface CategoriasRepoInterface extends JpaRepository<Categorias,Integer>{

}
