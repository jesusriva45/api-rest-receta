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
@Table(name = "recetas")
public class Receta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -792903162694258349L;

	@Column(name = "id_receta")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_receta;

	@Column(name = "nom_receta")
	private String nom_receta;

	@Column(name = "preparacion")
	private String preparacion;
	
	@Column(name = "ingredientes")
	private String ingredientes;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cate_receta")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Categoria categoria;
	
	
	@Column(name = "foto_receta")
	private String foto_receta;
	

	public String getFoto_receta() {
		return foto_receta;
	}

	public void setFoto_receta(String foto_receta) {
		this.foto_receta = foto_receta;
	}

	public int getId_receta() {
		return id_receta;
	}

	public void setId_receta(int id_receta) {
		this.id_receta = id_receta;
	}

	public String getNom_receta() {
		return nom_receta;
	}

	public void setNom_receta(String nom_receta) {
		this.nom_receta = nom_receta;
	}

	
	

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	//VALIDO
	
	/*Positioned(
                top: 0.0,
                right: 0.0,
                left: 0.0,
                bottom: 0.0,
                child: Container(
                  decoration: BoxDecoration(
                    gradient: LinearGradient(
                      colors: [
                        Color.fromARGB(200, 0, 0, 0),
                        Color.fromARGB(0, 0, 0, 0),
                      ],
                      begin: Alignment.bottomCenter,
                      end: Alignment.topCenter,
                    ),
                  ),
                  child: Image.network(
                    this.foto,
                    fit: BoxFit.cover,
                    //width: 100,
                  ),
                ),
              ),*/
	
	
	
	
	
	
	/*Row(
                        children: [
                          CarouselSlider(
                            options: CarouselOptions(
                                autoPlay: true,
                                enlargeCenterPage: true,
                                aspectRatio: 2.0,
                                onPageChanged: (index, reason) {
                                  i = index;
                                }),
                            items: <Widget>[
                              Container(
                                height: 500,
                                margin: const EdgeInsets.only(
                                    top: 20.0, left: 20.0),
                                decoration: BoxDecoration(
                                  image: DecorationImage(
                                    image: NetworkImage(
                                        recetaList[i]["id_receta"].toString()),
                                    fit: BoxFit.fitHeight,
                                  ),
                                  // border:
                                  //     Border.all(color: Theme.of(context).accentColor),
                                  borderRadius: BorderRadius.circular(32.0),
                                ),
                              ),
                            ],
                          ),
                        ],
                      ),*/
	
	
	/*
	 recetaList
        .asMap()
        .map((i, recetas) => MapEntry(
            i,
            Container(
              child: ClipRRect(
                borderRadius: BorderRadius.all(
                  Radius.circular(5.0),
                ),
                child: Stack(
                  children: [
                    Image.network(
                      recetas["foto_receta"],
                      fit: BoxFit.cover,
                      width: 100,
                    ),
                    Positioned(
                      bottom: 0.0,
                      left: 0.0,
                      right: 0.0,
                      child: Container(
                        decoration: BoxDecoration(
                          gradient: LinearGradient(
                            colors: [
                              Color.fromARGB(200, 0, 0, 0),
                              Color.fromARGB(0, 0, 0, 0),
                            ],
                            begin: Alignment.bottomCenter,
                            end: Alignment.topCenter,
                          ),
                        ),
                        padding: EdgeInsets.symmetric(
                          horizontal: 20,
                          vertical: 10,
                        ),
                        child: Text(
                          '${recetas["nom_receta"]}',
                          style: TextStyle(
                            color: Colors.white,
                            fontSize: 20.0,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            )))
        .values
        .toList();
	 * */
	
	

}
