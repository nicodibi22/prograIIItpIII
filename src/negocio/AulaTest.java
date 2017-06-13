package negocio;

import static org.junit.Assert.*;

import org.junit.Test;

public class AulaTest {

	@Test
	public void aulaVaciaTest() {
		Aula aulaVacia = Aula.aulaVacia();
		assertTrue(aulaVacia.getCodigo() == null);
	}

	@Test
	public void aulaNoVaciaTest() {
		Aula aulaVacia = Aula.aulaNueva("AULA01");
		assertTrue(aulaVacia.getCodigo().equals("AULA01"));
	}
	
	@Test
	public void aulasIgualesTest() {
		Aula aulaUno = Aula.aulaNueva("AULA01");
		Aula aulaDos = Aula.aulaNueva("AULA01");
		assertTrue(aulaUno.equals(aulaDos));
	}
	
	@Test
	public void aulasDistintasTest() {
		Aula aulaUno = Aula.aulaNueva("AULA01");
		Aula aulaDos = Aula.aulaNueva("AULA02");
		assertFalse(aulaUno.equals(aulaDos));
	}
}
