package ar.edu.unlp.info.oo1.Parcial1Obj;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presencial extends Evento{

	private ArrayList<Sede> sedes;
	
	public Presencial (String unNombre, LocalDate unaFecha, String unTema, double pIns, double pRem, Sede unaSede) {
		super(unNombre, unaFecha, unTema, pIns, pRem);
		this.sedes = new ArrayList<>();
		this.sedes.add(unaSede);
	}
	
	@Override
	public double getPrecio(LocalDate fecha) {
		return(super.getPrecio(fecha) + this.sedes.stream().mapToDouble(S -> S.getPrecioTotal()).sum());
	}
	
	public void agregarSede(Sede unaSede) {
		this.sedes.add(unaSede);
	}
}