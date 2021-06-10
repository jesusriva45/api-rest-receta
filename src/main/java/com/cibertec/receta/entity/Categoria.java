package com.cibertec.receta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7792643807520326204L;

	@Column(name = "id_cate_receta")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cate_receta;

	@Column(name = "no_cate_receta")
	private String no_cate_receta;

	public int getId_cate_receta() {
		return id_cate_receta;
	}

	public void setId_cate_receta(int id_cate_receta) {
		this.id_cate_receta = id_cate_receta;
	}

	public String getNo_cate_receta() {
		return no_cate_receta;
	}

	public void setNo_cate_receta(String no_cate_receta) {
		this.no_cate_receta = no_cate_receta;
	}

}
