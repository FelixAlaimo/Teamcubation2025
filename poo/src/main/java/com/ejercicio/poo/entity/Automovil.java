package com.ejercicio.poo.entity;

import com.ejercicio.poo.utils.Combustibles;

public class Automovil extends Vehiculo {
	
	private int cantidadPuertas;
	private Combustibles tipoCombustible;

	public Automovil() {
		this.setVelocidadMaxima(180);
	}

	public int getCantidadPuertas() {
		return cantidadPuertas;
	}
	public void setCantidadPuertas(int cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}

	public Combustibles getTipoCombustible() {
		return tipoCombustible;
	}
	public void setTipoCombustible(Combustibles tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}
	
	@Override
	public int acelerar(int cantidad) {
		if (cantidad > 0) {
			// cada aceleracion de un automovil no puede superar los 30 km/h
			cantidad = Math.min(cantidad, 30);
			int nuevaVelocidad = Math.min(this.getVelocidadMaxima(), this.getVelocidadActual() + cantidad);
			this.setVelocidadActual(nuevaVelocidad);
		}
		return this.getVelocidadActual();
		
	}

	@Override
	public int frenar(int cantidad) {
		if (cantidad > 0) {
			// si un auto circula a una velocidad mayor o igual a 50 km/h
			// no puede frenar mas que la mitad de la velocidad a la que circula
			if (this.getVelocidadActual() >= 50) {
				cantidad = Math.min(this.getVelocidadActual()/2, cantidad);
			}
			int nuevaVelocidad = Math.max(0, this.getVelocidadActual() - cantidad);
			this.setVelocidadActual(nuevaVelocidad);
		}
		return this.getVelocidadActual();
	}

}
