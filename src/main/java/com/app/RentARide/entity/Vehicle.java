package com.app.RentARide.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private Segment category;
	
	private double price;
	private double average;
	private String variant;
	private String description;
	private String imageName;
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicle(String name, Segment category, double price, double average, String variant, String description,
			String imageName) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.average = average;
		this.variant = variant;
		this.description = description;
		this.imageName = imageName;
	}
	public Vehicle(long id, String name, Segment category, double price, double average, String variant,
			String description, String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.average = average;
		this.variant = variant;
		this.description = description;
		this.imageName = imageName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Segment getCategory() {
		return category;
	}
	public void setCategory(Segment category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double d) {
		this.price = d;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", average="
				+ average + ", variant=" + variant + ", description=" + description + ", imageName=" + imageName + "]";
	}
}