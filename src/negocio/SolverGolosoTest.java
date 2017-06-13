package negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolverGolosoTest {

	Universidad universidad;
	
	SolverGoloso solver;
	
	private void inicializar() {
		universidad = new Universidad();
		universidad.cargarMaterias(Mock.getJsonValidTest());
		solver = new SolverGoloso(universidad);
	}
	
	@Test
	public void ordenarMateriasTest() {
		inicializar();
		solver.ordenar();
	}

	@Test
	public void asignarAulaTest() {
		inicializar();
		Aula aula = solver.asignarAula(universidad.materias().get(0));
		assertTrue(aula.getCodigo() != null && !aula.getCodigo().isEmpty());
	}
	
	@Test
	public void aulaOcupadaHorasIncluidasTest() {
		inicializar();
		Aula aula = solver.asignarAula(universidad.materias().get(0));
		assertTrue(solver.estaOcupada(aula, 9, 12));		
	}
	
	@Test
	public void aulaOcupadaHorasIgualesTest() {
		inicializar();
		Aula aula = solver.asignarAula(universidad.materias().get(0));
		assertTrue(solver.estaOcupada(aula, 10, 11));		
	}
	
	@Test
	public void aulaOcupadaHoraInicioIncluidaTest() {
		inicializar();
		Aula aula = solver.asignarAula(universidad.materias().get(2));
		assertTrue(solver.estaOcupada(aula, 9, 13));		
	}
	
	@Test
	public void aulaOcupadaHoraFinIncluidaTest() {
		inicializar();
		Aula aula = solver.asignarAula(universidad.materias().get(2));
		assertTrue(solver.estaOcupada(aula, 7, 9));		
	}
	
	@Test
	public void aulaVaciaTest() {
		inicializar();
		Aula aula = solver.asignarAula(universidad.materias().get(0));
		assertFalse(solver.estaOcupada(aula, 11, 12));
	}
	
	@Test
	public void aulaVaciaExtremoFinTest() {
		inicializar();
		Aula aula = solver.asignarAula(universidad.materias().get(0));
		assertFalse(solver.estaOcupada(aula, 9, 10));
	}
	
	@Test
	public void aulaVaciaExtremoInicioTest() {
		inicializar();
		Aula aula = solver.asignarAula(universidad.materias().get(0));
		assertFalse(solver.estaOcupada(aula, 11, 15));
	}
	
	@Test
	public void resolverTest() {
		inicializar();
		ArrayList<Asignacion> asignaciones = solver.resolver();		
		assertTrue(asignaciones.size() == universidad.materias().size());
		assertTrue(universidad.aulas().size() == 3);
	}
}
