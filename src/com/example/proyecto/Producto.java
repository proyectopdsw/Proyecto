package com.example.proyecto;
import android.graphics.drawable.Drawable;


public class Producto {
	public int id;
	private String title;
	private Drawable productImage;
	public String description;
	public double price;
	public boolean selected;
	

	public Producto(String title, Drawable productImage, String description,
			double price) {
		this.setTitle(title);
		this.setProductImage(productImage);
		this.setDescription(description);
		this.setPrice(price);
	}

	public Drawable getProductImage() {
		return productImage;
	}

	public void setProductImage(Drawable productImage) {
		this.productImage = productImage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
