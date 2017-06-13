package negocio;

import static org.junit.Assert.*;

import org.junit.Test;

public class MateriaTest {

	@Test
	public void materiasIgualesTest() {
		Materia mat1 = new Materia("P3", "Programación 3", 18, 22);
		Materia mat2 = new Materia("P3", "Programación 3", 18, 22);
		assertTrue(mat1.equals(mat2));
	}

	@Test
	public void materiasDistintaHoraFinTest() {
		Materia mat1 = new Materia("P3", "Programación 3", 18, 22);
		Materia mat2 = new Materia("P3", "Programación 3", 18, 20);
		assertFalse(mat1.equals(mat2));
	}
	
	@Test
	public void materiasDistintaHoraInicioTest() {
		Materia mat1 = new Materia("P3", "Programación 3", 18, 22);
		Materia mat2 = new Materia("P3", "Programación 3", 20, 22);
		assertFalse(mat1.equals(mat2));
	}
	
	@Test
	public void materiasDistintoNombreTest() {
		Materia mat1 = new Materia("P3", "Programación 2", 18, 22);
		Materia mat2 = new Materia("P3", "Programación 3", 18, 22);
		assertFalse(mat1.equals(mat2));
	}
	
	@Test
	public void materiasDistintoCodigoTest() {
		Materia mat1 = new Materia("P2", "Programación 3", 18, 22);
		Materia mat2 = new Materia("P3", "Programación 3", 18, 22);
		assertFalse(mat1.equals(mat2));
	}
}
