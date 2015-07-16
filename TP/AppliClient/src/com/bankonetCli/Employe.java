package com.bankonetCli;

public class Employe {

	private Integer id;

	private String nom;
	
	private Double salaire;

	
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

	public Integer getId() {
		return id;
	}

	
	/**
	 * Getters & setters 
	 */
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
