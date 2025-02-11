package com.ejercicio.poo.entity;

public class Motocicleta extends Vehiculo {
	
	private String cilindrada;

	public Motocicleta() {
		this.setVelocidadMaxima(230);
	}

	public String getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	@Override
	public int acelerar(int cantidad) {
		if (cantidad > 0) {
			int nuevaVelocidad = Math.min(this.getVelocidadMaxima(), this.getVelocidadActual() + cantidad);
			this.setVelocidadActual(nuevaVelocidad);
		}
		return this.getVelocidadActual();
		
	}

	@Override
	public int frenar(int cantidad) {
		if (cantidad > 0) {
			int nuevaVelocidad = Math.max(0, this.getVelocidadActual() - cantidad);
			this.setVelocidadActual(nuevaVelocidad);
		}
		return this.getVelocidadActual();
	}

}
