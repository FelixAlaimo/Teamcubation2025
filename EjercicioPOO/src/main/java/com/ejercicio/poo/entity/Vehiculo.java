package com.ejercicio.poo.entity;

public abstract class Vehiculo {
	
	private String marca;
	private String modelo;
	private int año;
	
	private int velocidadActual;
	private int velocidadMaxima;
	
	public abstract int acelerar(int cantidad);
	public abstract int frenar(int cantidad);
	
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
	
	public String detallesVehiculo() {
		return "Marca: " + this.marca != null ? this.marca : "N/A"
				+ " Modelo: " + this.modelo != null ? this.modelo : "N/A"
				+ " Año: " + this.año + " VelocidadActual: " + this.velocidadActual
				+ " VelocidadMaxima: " + this.velocidadMaxima
				;
	}

}
