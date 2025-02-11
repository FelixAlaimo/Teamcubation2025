package com.ejercicio.poo.entity;

import com.ejercicio.poo.utils.Combustibles;

public class AutoElectrico extends Automovil implements Electrico {
	
	private int cargaDeBateria;
	
	public AutoElectrico(String marca, String modelo, int año, int cantidadPuertas, Combustibles tipoCombustible, int cargaDeBateria) {
		super(marca, modelo, año, cantidadPuertas, tipoCombustible);
		this.cargaDeBateria = cargaDeBateria;
	}

	public int getCargaDeBateria() {
		return cargaDeBateria;
	}

	public void setCargaDeBateria(int cargaDeBateria) {
		this.cargaDeBateria = cargaDeBateria;
	}

	@Override
	public int cargarBateria(int porcentaje) {
		if (porcentaje > 0) {
			this.cargaDeBateria = Math.min(100, this.cargaDeBateria + porcentaje);
		}
		return this.cargaDeBateria;
	}

}
