package com.ejercicio.poo.entity;

public class Camion extends Vehiculo {
	
	private int capacidadCarga;
	
	public Camion() {
		this.setVelocidadMaxima(100);
	}
	
	public Camion(String marca, String modelo, int año, int capacidadDeCarga) {
		super(marca, modelo, año);
		this.capacidadCarga = capacidadDeCarga;
		this.setVelocidadMaxima(100);
	}
	
	public int getCapacidadCarga() {
		return capacidadCarga;
	}
	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	@Override
	public int acelerar(int cantidad) {
		if (cantidad > 0) {
			cantidad = Math.min(cantidad, 15);
			int nuevaVelocidad = Math.min(this.getVelocidadMaxima(), this.getVelocidadActual() + cantidad);
			this.setVelocidadActual(nuevaVelocidad);
		}
		return this.getVelocidadActual();	
	}
	
	@Override
	public String limitacionesDeAceleracion() {
		return "La aceleracion maxima es de 15 km/h";
	}

	@Override
	public int frenar(int cantidad) {
		if (cantidad > 0) {
			if (this.getVelocidadActual() >= 40) {
				cantidad = Math.min(this.getVelocidadActual()/3, cantidad);
			}
			int nuevaVelocidad = Math.max(0, this.getVelocidadActual() - cantidad);
			this.setVelocidadActual(nuevaVelocidad);
		}
		return this.getVelocidadActual();
	}
	
	@Override
	public String limitacionesDeFrenado() {
		return "Si la velocidad actual es 40 km/h o superior, el camion solo podra frenar como maximo un tercio de su velocidad actual";
	}

}
