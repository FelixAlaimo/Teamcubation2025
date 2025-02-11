package com.ejercicio.poo.entity;

public class Camion extends Vehiculo {
	
	private int capacidadCarga;
	
	public Camion() {
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
			// cada aceleracion de un Camion no puede superar los 15 km/h
			cantidad = Math.min(cantidad, 15);
			int nuevaVelocidad = Math.min(this.getVelocidadMaxima(), this.getVelocidadActual() + cantidad);
			this.setVelocidadActual(nuevaVelocidad);
		}
		return this.getVelocidadActual();
		
	}

	@Override
	public int frenar(int cantidad) {
		if (cantidad > 0) {
			// si un Camion circula a una velocidad mayor o igual a 40 km/h
			// no puede frenar mas que un tercio de la velocidad a la que circula
			if (this.getVelocidadActual() >= 40) {
				cantidad = Math.min(this.getVelocidadActual()/3, cantidad);
			}
			int nuevaVelocidad = Math.max(0, this.getVelocidadActual() - cantidad);
			this.setVelocidadActual(nuevaVelocidad);
		}
		return this.getVelocidadActual();
	}

}
