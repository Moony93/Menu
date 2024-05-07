package it.exercise.menuTopBoot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity   					//flag come entità
@Table(name = "recipes")	//tabella di appartenenza su mysql
public class Recipe {
	
	@Id						//identificazione come ID		
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//il campo è generato, poichè gestito dal database dov'è impostato come autoincrementale
	@Column(name = "Id")  	//assegnazione alla colonna ID della tabella
	private int id;
	
	@Column(name = "name")	//assegnazione alla colonna name della tabella
	private String name;
	
	@Column(name = "cost")	//assegnazione alla colonna cost della tabella
	private double cost;
	
	@Column(name = "vegan")	//assegnazione alla colonna vegan della tabella
	private boolean vegan;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public boolean isVegan() {
		return vegan;
	}
	
	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}
	
	@Override
	public String toString() {
		return "[Recipe: " + this.name + ", cost: " + this.cost + ", vegan:" + this.vegan + "]";
	}
}
