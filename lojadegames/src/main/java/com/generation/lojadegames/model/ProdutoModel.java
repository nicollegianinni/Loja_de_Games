package com.generation.lojadegames.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "O Item é obrigatório e não pode utilizar espaços em branco!") 
	@Size(min = 5, max = 100, message = "O item deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nome;
	
	@Size(max=500, message = "A descrição deve ter no máximo 500 caracteres!")
	private String descricao;
	
	@NotNull(message = "O Console é obrigatório!")
	private String console;
	
	@NotNull
	private Integer quantidade;
	
	@Column(name = "data_lancamento")
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "O Preço é obrigatório!")
	@Positive(message = "Digite algum valor maior do que zero")
	private BigDecimal preco;
	
	@Size(min = 5, max = 100, message = "O item deve conter no mínimo 05 e no máximo 100 caracteres")
	private String fabricante;
	
	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private CategoriaModel categoria;	
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private UsuarioModel usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}	
}
