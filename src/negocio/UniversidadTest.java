package negocio;

import static org.junit.Assert.*;

import org.junit.Test;
import com.google.gson.JsonSyntaxException;

public class UniversidadTest {

	@Test
	public void agregarAulaTest() {
		Universidad universidad = new Universidad();
		universidad.agregarAula();
		assertTrue(universidad.cantidadAulas() == 1);
	}

	@Test
	public void sinAulasTest() {
		Universidad universidad = new Universidad();
		assertTrue(universidad.cantidadAulas() == 0);
	}
	
	@Test
	public void sinMateriasTest() {
		Universidad universidad = new Universidad();
		assertTrue(universidad.cantidadMaterias() == 0);
	}
	
	@Test
	public void cargarMateriasValidasTest() throws Exception {
		Universidad universidad = new Universidad();
		universidad.cargarMaterias(Mock.getJsonValidTest());
		assertTrue(universidad.cantidadMaterias() == 10);
	}
	
	@Test (expected=JsonSyntaxException.class)
	public void cargarMateriasInvalidasTest() {
		Universidad universidad = new Universidad();
		universidad.cargarMaterias(Mock.getJsonInvalidTest());
	}	

	@Test (expected=IllegalArgumentException.class)
	public void agregarRelacionAulaInexistenteTest()  {
		Universidad universidad = new Universidad();
		universidad.cargarMaterias(Mock.getJsonValidTest());
		universidad.agregarRelacionAulaMateria(Aula.aulaNueva("AULA01"), universidad.materias().get(0));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void agregarRelacionMateriaInexistenteTest()  {
		Universidad universidad = new Universidad();
		universidad.agregarRelacionAulaMateria(universidad.agregarAula(), new Materia("ALG", "Algebra", 9, 12));
	}
	
	@Test 
	public void agregarRelacionTest()  {
		Universidad universidad = new Universidad();
		universidad.cargarMaterias(Mock.getJsonValidTest());
		Aula aula = universidad.agregarAula();
		universidad.agregarRelacionAulaMateria(aula, universidad.materias().get(0));
		assertTrue(universidad.getMateriasPorAula(aula.getCodigo()).size() == 1);
	}
}
