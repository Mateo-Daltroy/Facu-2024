package ar.edu.unlp.info.oo1.ej19_envioPaquetes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnvioInternacionalTest {

	EnvioInternacional testeado;
	
	@BeforeEach
	public void setup() throws Exception {
		LocalDate fecha = LocalDate.of(2024, 10, 10);
		testeado = new EnvioInternacional(fecha, "Argentina, La Plata, Calle 55, 970", "Uruguay, Montevideo, Calle 14 215", 500);
	}
	
	@Test
	public void testCalcularPrecio() {
		assertEquals(testeado.calcularPrecio(), 10000, 0.02);
		testeado.setPeso(1500);
		assertEquals(testeado.calcularPrecio(), 23000, 0.02);
	}
}