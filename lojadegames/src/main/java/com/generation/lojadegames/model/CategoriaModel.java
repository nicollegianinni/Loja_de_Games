package com.generation.lojadegames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atibuto nome deve conter de 3 a 15 caracteres e não ter espaço em branco")
	@Size(min = 3, max = 15)
	private String categoria;
	
	@OneToMany(mappedBy = "categoriamodel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoriamodel")
	private List<CategoriaModel> categoriamodel;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<CategoriaModel> getCategoriamodel() {
		return categoriamodel;
	}

	public void setCategoriamodel(List<CategoriaModel> categoriamodel) {
		this.categoriamodel = categoriamodel;
	}
}