package ar.edu.unlp.info.oo1.ej17_alquilerDePropiedades;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private String direccion;
	private int DNI;
	private ArrayList<Propiedad> propiedades = new ArrayList<>();
	
	public void crearReserva(Propiedad P, DateLapse D) {
		if (this.propiedades.contains(P)) { 
			if (!P.addReserva(D)) {
				System.out.println("Crear: La fecha se sobreescribe con otra reserva");
			}
		} else {
			System.out.println("Crear: Esta propiedad no le corresponde al usuario");
		}
	}
	
	public double cancelarReserva(Propiedad P, DateLapse D) {
		if (this.propiedades.contains(P)) { 
			return(P.cancelarReserva(D));
		} else {
			System.out.println("Cancelar: Esta propiedad no le corresponde al usuario");
			return(-1);
		}
	}
	
	public double calcularIngresosPropietario(DateLapse D) {
		return(this.propiedades.stream().mapToDouble(P -> P.calcularIngresosReservas(D)).sum() * 0.75);
	}
	
	//Modulos de testeo
	public void addPropiedad(Propiedad P) {
		this.propiedades.add(P);
	}
	
	public boolean containsReserva(Propiedad P, DateLapse D) {
		if (this.propiedades.contains(P) && P.contains(D)) {
			return(true);
		}
		return(false);
	}
}