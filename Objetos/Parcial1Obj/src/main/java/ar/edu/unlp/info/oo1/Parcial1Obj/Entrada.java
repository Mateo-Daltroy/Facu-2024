package ar.edu.unlp.info.oo1.Parcial1Obj;

import java.time.LocalDate;
		
public class Entrada {

	private boolean seguroReembolso;
	private LocalDate fechaCompra;
	private double precio;
	private Evento evento;
	
	public Entrada (Evento unEvento, boolean unSeguro, LocalDate unaFecha) {
		this.fechaCompra = unaFecha;
		this.precio = unEvento.getPrecio(unaFecha);
		this.seguroReembolso = unSeguro;
		this.evento = unEvento;
	}
	
	public double montoDevolucion() {
		return(0);
	}
	
	public double getCosto() {
		return(this.precio);
	}
	
	public LocalDate getFechaEvento() {
		return(this.evento.getFecha()); //Super mal olor, pero no se me ocurre nada mas
	}
	
	public boolean eventoTranscurrido() {
		return (this.evento.getFecha().isBefore(LocalDate.now()));
	}
}