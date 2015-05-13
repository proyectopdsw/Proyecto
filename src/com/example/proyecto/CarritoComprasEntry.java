package com.example.proyecto;

public class CarritoComprasEntry {
	
	private Producto mProduct;
	private int mQuantity;
	
	public CarritoComprasEntry(Producto producto, int quantity) {
		mProduct = producto;
		mQuantity = quantity;
	}
	
	public Producto getProduct() {
		return mProduct;
	}
	
	public int getQuantity() {
		return mQuantity;
	}
	
	public void setQuantity(int quantity) {
		mQuantity = quantity;
	}

}
