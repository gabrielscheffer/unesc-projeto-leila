package net.unesc.locadoravirtual.vo;

import java.io.Serializable;

public class Filmes implements Serializable{
	private Integer id;
	private String nome, sinopse;
	private int image;
	private Integer ano;
	private Double preco;

	public Filmes() {

	}
	
	
	public Filmes(Integer id, String nome, String sinopse, int image, Integer ano, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sinopse = sinopse;
		this.image = image;
		this.ano = ano;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

}
