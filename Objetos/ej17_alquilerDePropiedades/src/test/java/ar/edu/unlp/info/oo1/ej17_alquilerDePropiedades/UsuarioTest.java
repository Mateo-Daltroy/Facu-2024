package ar.edu.unlp.info.oo1.ej17_alquilerDePropiedades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class UsuarioTest {

	Usuario Testeado;
	DateLapse reserva;
	Propiedad P;
	Propiedad P2;
	
	@BeforeEach
	public void setup() throws Exception {
		Testeado = new Usuario();
		PoliticaCancelacion politica = new CancelacionEstricta();
		P = new Propiedad(4, politica);
		Testeado.addPropiedad(P);
		reserva = new DateLapse(LocalDate.of(2024, 10, 1), LocalDate.of(2024, 12, 1)); //61 dias, devuelve 2 por algun motivo?
		Testeado.crearReserva(P, reserva);
		P2 = new Propiedad(20, politica);
	}
	
	@Test
	public void crearReservaTest() {
		Testeado.crearReserva(P2, reserva); //Imprime "Esta propiedad no le corresponde al usuario"
		assertTrue(Testeado.containsReserva(P, reserva));
		assertFalse(Testeado.containsReserva(P2, reserva));
		assertFalse(Testeado.containsReserva(P, null)); //Funciona null para este testeo?
		DateLapse reserva2 = new DateLapse(LocalDate.of(2024, 11, 2), LocalDate.of(2024, 11, 7));
		Testeado.crearReserva(P, reserva2); //Imprime "La fecha se sobreescribe con otra reserva"
		assertFalse(Testeado.containsReserva(P, reserva2));
	}
	
	@Test
	public void cancelarReservaTest() {
		assertTrue(Testeado.containsReserva(P, reserva));
		assertEquals(Testeado.cancelarReserva(P, reserva), 0, 0.02);
		assertFalse(Testeado.containsReserva(P, reserva));
		assertEquals(Testeado.cancelarReserva(P2, reserva), -1, 0.02); //Imprime "Esta propiedad no le corresponde al usuario"
	}
	
	@Test
	public void calcularIngresoPropietarioTest() {
		DateLapse intervalo = new DateLapse(LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 30));
		DateLapse R1 = new DateLapse(LocalDate.of(2024, 9, 23), LocalDate.of(2024, 9, 26));
		P.addReserva(R1);
		P2.addReserva(R1);
		assertEquals(Testeado.calcularIngresosPropietario(intervalo), 9, 0.02);
		Testeado.addPropiedad(P2);
		assertEquals(Testeado.calcularIngresosPropietario(intervalo), 54, 0.02);
		P2.cancelarReserva(R1);
		assertEquals(Testeado.calcularIngresosPropietario(intervalo), 54, 0.02); //CancelacionEstricta no devuelve nada
		P2.addReserva(R1);
		P2.setPolitica(new CancelacionFlexible());
		P2.cancelarReserva(R1);
		assertEquals(Testeado.calcularIngresosPropietario(intervalo), 9, 0.02); //CancelacionFlexible devuelve todo
	}
}