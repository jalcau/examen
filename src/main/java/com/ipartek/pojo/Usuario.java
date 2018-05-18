package com.ipartek.pojo;

public class Usuario {
	private int id;
	private String nombre;
	private String pass;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Usuario() {
		super();
		this.id = -1;
		this.pass = "";
		this.nombre = "";
	}

}
