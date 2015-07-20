package com.bankonet.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employe {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nom;
	
	private Double salaire; //big d�cimal est mieux pour les calculs

	
	/**
	 * Constructeurs
	 */
	public Employe() {
		
	}

	public Employe(int id, String nom) {
		this.setId(id);
		this.setNom(nom);
		this.setSalaire(0D);
	}

	

	
	/**
	 * Getters & setters 
	 */
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	
	
}
