package com.ejercicio.poo.entity;

public abstract class Vehiculo {
	
	private String marca;
	private String modelo;
	private int año;
	
	private int velocidadActual;
	private int velocidadMaxima;
	
	public abstract int acelerar(int cantidad);
	public abstract int frenar(int cantidad);
	
	public Vehiculo() {
		// default empty constructor
	}
	
	public Vehiculo(String marca, String modelo, int año) {
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	
	public int getVelocidadActual() {
		return velocidadActual;
	}
	public void setVelocidadActual(int velocidadActual) {
		this.velocidadActual = velocidadActual;
	}
	
	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}
	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}
	
	public final String detallesVehiculo() {
		return "\"Marca\": \"" + (this.marca != null ? this.marca : "N/A")
				+ "\", \"Modelo\": \"" + (this.modelo != null ? this.modelo : "N/A")
				+ "\", \"Año\": \"" + this.año
				+ "\", \"VelocidadActual\": \"" + this.velocidadActual
				+ "\", \"VelocidadMaxima\": \"" + this.velocidadMaxima + "\"";
	}
	
	public String limitacionesDeAceleracion() {
		return "No hay limitaciones de aceleracion para este Vehiculo";
	}
	
	public String limitacionesDeFrenado() {
		return "No hay limitaciones de frenado para este Vehiculo";
	}

}
