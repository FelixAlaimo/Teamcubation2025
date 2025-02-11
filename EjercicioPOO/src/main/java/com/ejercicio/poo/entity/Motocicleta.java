package com.ejercicio.poo.entity;

public class Motocicleta extends Vehiculo {
	
	private int cilindrada;
	
	public Motocicleta() {
		this.setVelocidadMaxima(230);
	}

	public Motocicleta(String marca, String modelo, int año, int cilindrada) {
		super(marca, modelo, año);
		this.cilindrada = cilindrada;
		this.setVelocidadMaxima(230);
	}

	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
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
