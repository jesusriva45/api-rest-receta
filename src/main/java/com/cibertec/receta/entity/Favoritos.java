package com.cibertec.receta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "favoritos")
public class Favoritos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7547043940155010688L;

	@Column(name = "id_favorito")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_favorito;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_receta")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Receta receta;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;

	public int getId_favorito() {
		return id_favorito;
	}

	public void setId_favorito(int id_favorito) {
		this.id_favorito = id_favorito;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
