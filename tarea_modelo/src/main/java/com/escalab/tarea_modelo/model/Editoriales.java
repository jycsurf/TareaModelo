package com.escalab.tarea_modelo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Editoriales")
public class Editoriales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEditorial;
	
	@Column(name = "Editorial",nullable = false, length = 70)
	private String editorial;

	public Integer getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(Integer idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Editoriales [idEditorial=" + idEditorial + ", editorial=" + editorial + "]";
	}

	
	
}
