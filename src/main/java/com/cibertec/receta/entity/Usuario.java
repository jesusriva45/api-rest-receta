package com.cibertec.receta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7210084695227996942L;

	@Column(name = "id_usuario")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;

	@Column(name = "no_usuario")
	private String no_usuario;

	@Column(name = "ap_pate_usuario")
	private String ap_pate_usuario;

	@Column(name = "ap_mate_usuario")
	private String ap_mate_usuario;

	@Column(name = "do_usuario")
	private int do_usuario;

	@Column(name = "pw_usuario")
	private String pw_usuario;

	@Column(name = "ed_usuario")
	private int ed_usuario;

	@Column(name = "em_usuario")
	private String em_usuario;

	
	@Column(name = "fo_usuario")
	private String fo_usuario;
	
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNo_usuario() {
		return no_usuario;
	}

	public void setNo_usuario(String no_usuario) {
		this.no_usuario = no_usuario;
	}

	public String getAp_pate_usuario() {
		return ap_pate_usuario;
	}

	public void setAp_pate_usuario(String ap_pate_usuario) {
		this.ap_pate_usuario = ap_pate_usuario;
	}

	public String getAp_mate_usuario() {
		return ap_mate_usuario;
	}

	public void setAp_mate_usuario(String ap_mate_usuario) {
		this.ap_mate_usuario = ap_mate_usuario;
	}

	public int getDo_usuario() {
		return do_usuario;
	}

	public void setDo_usuario(int do_usuario) {
		this.do_usuario = do_usuario;
	}

	public String getPw_usuario() {
		return pw_usuario;
	}

	public void setPw_usuario(String pw_usuario) {
		this.pw_usuario = pw_usuario;
	}

	public int getEd_usuario() {
		return ed_usuario;
	}

	public void setEd_usuario(int ed_usuario) {
		this.ed_usuario = ed_usuario;
	}

	public String getEm_usuario() {
		return em_usuario;
	}

	public void setEm_usuario(String em_usuario) {
		this.em_usuario = em_usuario;
	}

	public String getFo_usuario() {
		return fo_usuario;
	}

	public void setFo_usuario(String fo_usuario) {
		this.fo_usuario = fo_usuario;
	}

	
}
