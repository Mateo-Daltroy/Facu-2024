package ar.edu.unlp.info.oo1.ej17_alquilerDePropiedades;

import java.time.LocalDate;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse (LocalDate aFrom, LocalDate aTo) {
		this.from = aFrom;
		this.to = aTo;
	}
	
	public int sizeInDays() {
		return(this.to.compareTo(this.from));
	}
	
	public boolean includesDate(LocalDate other) {
		if (other.isAfter(this.from) && other.isBefore(this.to)) {
			return(true);
		} else {
			return(false);
		}
	}
	
	public boolean overlaps(DateLapse otroDia) {
		if ((otroDia.getFrom().isBefore(from) && otroDia.getTo().isBefore(from)) || 
			(otroDia.getFrom().isAfter(to) && otroDia.getTo().isAfter(to))) {
			return(false);
		}
		return(true);
	}
	
	public LocalDate getFrom() {
		return from;
	}
	public LocalDate getTo() {
		return to;
	}
}