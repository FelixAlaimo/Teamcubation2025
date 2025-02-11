package com.ejercicio.poo.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ejercicio.poo.entity.AutoElectrico;
import com.ejercicio.poo.entity.Automovil;
import com.ejercicio.poo.entity.Camion;
import com.ejercicio.poo.entity.Motocicleta;
import com.ejercicio.poo.entity.Vehiculo;
import com.ejercicio.poo.utils.CambioDeVelocidad;
import com.ejercicio.poo.utils.Combustibles;

public class MenuInteractivo {
	
	public static void main(String[] args) {
		List<Vehiculo> vehiculos = new ArrayList<>();
		vehiculos.add(new Automovil("Peugeot", "208", 2023, 5, Combustibles.NAFTA));
		vehiculos.add(new Automovil("Ford", "Focus", 2019, 3, Combustibles.GASOIL));
		vehiculos.add(new AutoElectrico("Tesla", "S", 2025, 5, Combustibles.ELECTRICIDAD, 80));
		vehiculos.add(new Motocicleta("Honda", "XR 250 Tornado", 2024, 750));
		vehiculos.add(new Camion("Scania", "R450", 2018, 20000));
		vehiculos.add(new Camion("IVECO", "Cursor", 2024, 35000));
		
        Scanner scanner = new Scanner(System.in);
        int seleccionDeUsuario;
        do {
            mostrarMenuPrincipal();
            seleccionDeUsuario = scanner.nextInt();
            switch (seleccionDeUsuario) {
                case 1:
                	mostrarVehiculosDisponibles(vehiculos);
                    break;
                case 2:
                	mostrarMenuCambioDeVelocidad(vehiculos, scanner, CambioDeVelocidad.ACELERAR);
                    break;
                case 3:
                    mostrarMenuCambioDeVelocidad(vehiculos, scanner, CambioDeVelocidad.FRENAR);
                    break;
                case 9:
                    System.out.println("Saludos!");
                    break;
                default:
                    System.out.println("Opción inválida, volvé a intentar.");
            }
        } while (seleccionDeUsuario != 9);
        scanner.close();
    }

    public static void mostrarMenuPrincipal() {
    	System.out.println("******************* MENU PRINCIPAL ********************");
        System.out.println("1. Ver vehículos disponibles");
        System.out.println("2. Acelerar vehículo");
        System.out.println("3. Frenar vehículo");
        System.out.println("9. Salir");
        System.out.println("*******************************************************");
    }
    
    public static void mostrarVehiculosDisponibles(List<Vehiculo> vehiculos) {
    	System.out.println("*************** VEHICULOS DISPONIBLES *****************");
    	Integer count = 0;
    	for (Vehiculo v : vehiculos) {
    		count++;
    		System.out.println(count.toString() + ". " + v.detallesVehiculo());
    	}
    	System.out.println("*******************************************************");
    }
    
    public static void mostrarMenuCambioDeVelocidad(List<Vehiculo> vehiculos, Scanner scanner, CambioDeVelocidad accion) {
    	System.out.println("Ingresá el número del vehículo que desees "+accion+", o ingresá 99 para cancelar.");
    	int cantidadDeVehiculos = vehiculos.size();
    	int seleccionDeUsuario;
    	do {
            seleccionDeUsuario = scanner.nextInt();
            if (seleccionDeUsuario > 0 && seleccionDeUsuario <= cantidadDeVehiculos) {
            	Vehiculo v = vehiculos.get(seleccionDeUsuario-1);
            	cambiarVelocidad(v, scanner, accion);            		
            	return;
            }
            else if (seleccionDeUsuario == 99) {
            	System.out.println("Acción cancelada!");
            }
            else {
            	System.out.println("Opción inválida, volvé a intentar.");
            }
        } while (seleccionDeUsuario != 99);
    }

    
    public static void cambiarVelocidad(Vehiculo v, Scanner scanner, CambioDeVelocidad accion) {
    	System.out.println("Elegiste " + accion.name() + " el siguiente vehículo: ");
    	System.out.println(v.detallesVehiculo());
    	
    	if (CambioDeVelocidad.ACELERAR.equals(accion) && v.getVelocidadActual() == v.getVelocidadMaxima()) {
    		System.out.println("El vehículo se encuentra ya en su velocidad máxima, no puede seguir acelerando. Operacion cancelada.");
    		return;
    	}
    	else if (CambioDeVelocidad.FRENAR.equals(accion) && v.getVelocidadActual() == 0) {
    		System.out.println("El vehículo se encuentra ya en su velocidad mínima, no puede disminuirse aun mas. Operacion cancelada.");
    		return;
    	}
    	
    	System.out.println("Ingresá un valor POSITIVO entre 0 y 250 para " + accion.getPropositoDeCambioDeVelocidad() + " la velocidad, o ingresá 999 para cancelar.");
    	System.out.println("Otras limitaciones:");
    	if (CambioDeVelocidad.ACELERAR.equals(accion)) {
    		System.out.println("Velocidad maxima: "+ v.getVelocidadMaxima());
    		System.out.println("Específico del tipo de vehiculo: " + v.limitacionesDeAceleracion());
    	} else {
    		System.out.println("Específico del tipo de vehiculo: " + v.limitacionesDeFrenado());    		
    	}
    	System.out.println("*******************************************************");
    	
    	int seleccionDeUsuario;
    	do {
            seleccionDeUsuario = scanner.nextInt();
            if (seleccionDeUsuario > 0 && seleccionDeUsuario <= 250) {
            	int nuevaVelocidad = CambioDeVelocidad.ACELERAR.equals(accion) ? v.acelerar(seleccionDeUsuario) : v.frenar(seleccionDeUsuario);
            	System.out.println("Nueva velocidad del vehículo: " + nuevaVelocidad);
            	return;
            }
            else if (seleccionDeUsuario == 999) {
            	System.out.println("Acción cancelada!");
            }
            else {
            	System.out.println("Valor inválido, volvé a intentar.");
            }
        } while (seleccionDeUsuario != 999);
    }

}
