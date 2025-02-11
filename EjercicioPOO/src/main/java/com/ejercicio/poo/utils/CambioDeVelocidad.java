package com.ejercicio.poo.utils;

public enum CambioDeVelocidad {
	
	ACELERAR("aumentar"),
	FRENAR("disminuir");
	
	private CambioDeVelocidad(String propositoDeCambioDeVelocidad) {
		this.propositoDeCambioDeVelocidad = propositoDeCambioDeVelocidad;
	}
	
	private String propositoDeCambioDeVelocidad;

	public String getPropositoDeCambioDeVelocidad() {
		return propositoDeCambioDeVelocidad;
	}

}
