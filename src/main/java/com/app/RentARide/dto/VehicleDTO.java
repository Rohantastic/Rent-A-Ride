package com.app.RentARide.dto;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class VehicleDTO {
	private long id;
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private int categoryId;

	private double price;
	private double average;
	private String variant;
	private String description;
	private String imageName;

	public VehicleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleDTO(long id, String name, int categoryId, long price, double average, String variant,
			String description, String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.price = price;
		this.average = average;
		this.variant = variant;
		this.description = description;
		this.imageName = imageName;
	}

	public VehicleDTO(String name, int categoryId, long price, double average, String variant, String description,
			String imageName) {
		super();
		this.name = name;
		this.categoryId = categoryId;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
		return "ProductDTO [id=" + id + ", name=" + name + ", categoryId=" + categoryId + ", price=" + price
				+ ", average=" + average + ", variant=" + variant + ", description=" + description + ", imageName="
				+ imageName + "]";
	}

}
