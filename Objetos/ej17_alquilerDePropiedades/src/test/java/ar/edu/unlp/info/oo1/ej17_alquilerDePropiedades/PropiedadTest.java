package ar.edu.unlp.info.oo1.ej17_alquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {

	Propiedad Testeado;
	DateLapse reserva;
	DateLapse R1 = new DateLapse(LocalDate.of(2024, 9, 23), LocalDate.of(2024, 9, 25)); //Fecha no colisionante
	DateLapse R2 = new DateLapse(LocalDate.of(2024, 10, 9), LocalDate.of(2024, 10, 17)); // Fecha colisionante
	
	@BeforeEach
	public void setup() throws Exception {
		PoliticaCancelacion politica = new CancelacionEstricta();
		Testeado = new Propiedad(20.5, politica);
		reserva = new DateLapse(LocalDate.of(2024, 10, 15), LocalDate.of(2024, 10, 20));
		Testeado.addReserva(reserva);
	}
	
	@Test
	public void addReservaTest() {
		Testeado.addReserva(R1);
		Testeado.addReserva(R2);
		assertTrue(Testeado.contains(R1));
		assertFalse(Testeado.contains(R2));
	}
	
	@Test
	public void consultarDisponibilidadTest() {
		assertTrue(Testeado.consultarDisponibilidad(R1));
		assertFalse(Testeado.consultarDisponibilidad(R2));
	}
	
	@Test
	public void calcularIngresosReservas() {
		assertEquals(Testeado.calcularIngresosReservas(R2), 102.5, 0.02);
		assertEquals(Testeado.calcularIngresosReservas(R1), 0, 0.02);
	}
}