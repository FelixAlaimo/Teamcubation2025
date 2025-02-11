package com.ejercicio.poo.entity;

import com.ejercicio.poo.utils.Combustibles;

public class Automovil extends Vehiculo {
	
	private int cantidadPuertas;
	private Combustibles tipoCombustible;

	public Automovil() {
		this.setVelocidadMaxima(180);
	}
	
	public Automovil(String marca, String modelo, int año, int cantidadPuertas, Combustibles tipoCombustible) {
		super(marca, modelo, año);
		this.cantidadPuertas = cantidadPuertas;
		this.tipoCombustible = tipoCombustible;
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
			cantidad = Math.min(cantidad, 30);
			int nuevaVelocidad = Math.min(this.getVelocidadMaxima(), this.getVelocidadActual() + cantidad);
			this.setVelocidadActual(nuevaVelocidad);
		}
		return this.getVelocidadActual();
	}
	
	@Override
	public String limitacionesDeAceleracion() {
		return "La aceleracion maxima es de 30 km/h";
	}

	@Override
	public int frenar(int cantidad) {
		if (cantidad > 0) {
			if (this.getVelocidadActual() >= 50) {
				cantidad = Math.min(this.getVelocidadActual()/2, cantidad);
			}
			int nuevaVelocidad = Math.max(0, this.getVelocidadActual() - cantidad);
			this.setVelocidadActual(nuevaVelocidad);
		}
		return this.getVelocidadActual();
	}
	
	@Override
	public String limitacionesDeFrenado() {
		return "Si la velocidad actual es 50 km/h o superior, el automovil solo podra frenar como maximo la mitad de su velocidad actual";
	}

}
