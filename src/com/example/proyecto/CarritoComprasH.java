package com.example.proyecto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import android.content.res.Resources;
import com.example.parcial.R;

public class CarritoComprasH {
	
	public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
	
	private static List<Producto> catalog;
	private static Map<Producto, CarritoComprasEntry> cartMap = new HashMap<Producto, CarritoComprasEntry>();
	
	public static List<Producto> getCatalog(Resources res){
		if(catalog == null) {
			catalog = new Vector<Producto>();
			catalog.add(new Producto("Celular Samsung", res.getDrawable(R.drawable.celular),
					"Celular barato", 19.99));
			catalog.add(new Producto("Balon", res
					.getDrawable(R.drawable.balon),
					"balon adidas", 20.99));
			catalog.add(new Producto("Tableta", res
					.getDrawable(R.drawable.tablet),
					"tableta de alta calidad", 114.99));
			catalog.add(new Producto("Juego PS", res
					.getDrawable(R.drawable.juego),
					"Juego God of War", 40.99));
			catalog.add(new Producto("Libro", res.getDrawable(R.drawable.deadoralive),
					"Bestseller Dead or Alive", 35.99));
		}
		
		return catalog;
	}
	
	public static void setQuantity(Producto producto, int quantity) {
		// Get the current cart entry
		CarritoComprasEntry curEntry = cartMap.get(producto);
		
		// If the quantity is zero or less, remove the products
		if(quantity <= 0) {
			if(curEntry != null)
				removeProduct(producto);
			return;
		}
		
		// If a current cart entry doesn't exist, create one
		if(curEntry == null) {
			curEntry = new CarritoComprasEntry(producto, quantity);
			cartMap.put(producto, curEntry);
			return;
		}
		
		// Update the quantity
		curEntry.setQuantity(quantity);
	}
	
	public static int getProductQuantity(Producto producto) {
		// Get the current cart entry
		CarritoComprasEntry curEntry = cartMap.get(producto);
		
		if(curEntry != null)
			return curEntry.getQuantity();
		
		return 0;
	}
	
	public static void removeProduct(Producto producto) {
		cartMap.remove(producto);
	}
	
	public static List<Producto> getCartList() {
		List<Producto> cartList = new Vector<Producto>(cartMap.keySet().size());
		for(Producto p : cartMap.keySet()) {
			cartList.add(p);
		}
		
		return cartList;
	}
	

}
