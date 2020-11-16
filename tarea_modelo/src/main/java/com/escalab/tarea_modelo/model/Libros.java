package com.escalab.tarea_modelo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Libros")
public class Libros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer asin;
	
	@ManyToOne
	@JoinColumn(name="id_autor",nullable = false,foreignKey = @ForeignKey(name="FK_libros_autores"))
	private Autores autores;
	
	@ManyToOne
	@JoinColumn(name="id_categoria",nullable = false,foreignKey = @ForeignKey(name="FK_libros_categorias"))
	private Categorias categorias;
	
	@ManyToOne
	@JoinColumn(name="id_editorial",nullable = false,foreignKey = @ForeignKey(name="FK_libros_editoriales"))
	private Editoriales editoriales;
	
	@Column(name = "Titulo",nullable = false, length = 70)
	private String titulo;
	
	@Column(name = "fecha_lanzamiento")
	private Date fecha;
	
	@Column(name = "idioma",nullable = false, length = 70)
	private String idioma;
	
	@Column(name = "paginas",nullable = false, length = 70)
	private String paginas;
	
	@Column(name = "descripcion",nullable = false, length = 70)
	private String descripcion;

	public Integer getAsin() {
		return asin;
	}

	public void setAsin(Integer asin) {
		this.asin = asin;
	}

	public Autores getAutores() {
		return autores;
	}

	public void setAutores(Autores autores) {
		this.autores = autores;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public Editoriales getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(Editoriales editoriales) {
		this.editoriales = editoriales;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Libros [asin=" + asin + ", autores=" + autores + ", categorias=" + categorias + ", editoriales="
				+ editoriales + ", titulo=" + titulo + ", fecha=" + fecha + ", idioma=" + idioma + ", paginas="
				+ paginas + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
