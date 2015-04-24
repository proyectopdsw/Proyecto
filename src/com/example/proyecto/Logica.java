package com.example.proyecto;

import java.util.ArrayList;

public class Logica {
	
	private static Logica logica=null;
	private ArrayList<Producto> productos= new ArrayList<Producto>();
	
	public static Logica getInstance()
	{
		if(logica==null)
		{
			logica=new Logica();
			return logica;
		}

		return logica;
	}
	
	public Logica()
	{
	}
	
	public int cuantos()
	{
		return productos.size();
	}
	
	public Producto leerProducto(int pos)
	{
		return productos.get(pos);
	}
	
	public void adicionarProducto(Producto pro)
	{
		productos.add(pro);
	}

}
