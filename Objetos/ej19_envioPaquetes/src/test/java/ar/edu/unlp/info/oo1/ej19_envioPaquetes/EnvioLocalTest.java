package ar.edu.unlp.info.oo1.ej19_envioPaquetes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class EnvioLocalTest {

	EnvioLocal testeado;
	
	@BeforeEach
	public void setup() throws Exception {
		LocalDate fecha = LocalDate.of(2024, 10, 10);
		testeado = new EnvioLocal(true, fecha, "Calle 55, 970", "Calle 14 215", 500);
	}
	
	@Test
	public void testCalcularPrecio() {
		assertEquals(testeado.calcularPrecio(), 1500, 0.02);
		testeado.toggle();
		assertEquals(testeado.calcularPrecio(), 1000, 0.02);
	}
}