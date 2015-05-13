package com.example.parcial;



public class Usuario {
	Integer id;
	String nombre;
	String direccion;
	Integer telefono;
	String clave;
	
	public Usuario(Integer id) {
		super();
		this.setId(id);
	}
 
	public Usuario(Integer id, String nombre, String direccion, Integer telefono, String clave ) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setClave(clave);
	}

	Integer getId() {
		return id;
	}
	
	

	void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
 
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", Nombre=" + nombre + ", Direccion="
				+ direccion + ", Telefono=" + telefono +  ", Clave=" + clave +"]";
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}

