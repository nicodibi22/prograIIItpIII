package negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datos.DaoMateria;

public class Universidad {

	private List<Materia> _materias;
	
	private List<Aula> _aulas;
	
	private Map<Aula, List<Materia>> _asignaciones;
	
	public Universidad() {
		_materias = new ArrayList<Materia>();
		_aulas = new ArrayList<Aula>();
		_asignaciones = new HashMap<Aula, List<Materia>>();
	}
	
	public boolean agregarMaterias(String nombreArchivo) throws Exception {
		
		_materias = DaoMateria.getMaterias(nombreArchivo);
		
		return true;
	}
	
	public void agregarAula() {
		_aulas.add(Aula.aulaNueva("A" + _aulas.size()));
	}
	
	public int cantidadAulas() {
		return _aulas.size();
	}
	
	public int cantidadMaterias() {
		return _materias.size();
	}
	
	public void procesar() {		
		ordenarMateriasPorHorarioInicio();
		
		for (Materia materia : _materias) {
			asignarAula(materia);
		}
	}
	
	
	private void asignarAula(Materia materia) {
		Aula aulaAsignar = Aula.aulaVacia();
		boolean hayAulaVacia = false;
		for(Aula aula : _aulas) {
			if(!estaOcupada(aula, materia.getHoraInicio(), materia.getHoraFin())) {
				aulaAsignar = aula;
				hayAulaVacia = true; 				
			} 
		}
		if(!hayAulaVacia) {
			agregarAula();
			_asignaciones.put(_aulas.get(cantidadAulas()- 1), new ArrayList<Materia>());
		}
		
		List<Materia> materiasAula = _asignaciones.get(aulaAsignar);
		materiasAula.add(materia);
		_asignaciones.put(aulaAsignar, materiasAula);

		
	}

	private void ordenarMateriasPorHorarioInicio() {
		Collections.sort(_materias, (p1, p2) -> p1.getHoraInicio() - p2.getHoraInicio());
	}
	
	public boolean estaOcupada(Aula aula, int horaInicio, int horaFin) {
		
		for(Materia mat : _asignaciones.get(aula)) {
			if(mat.getHoraInicio() <= horaInicio &&  mat.getHoraFin() >  horaInicio
					|| mat.getHoraInicio() < horaFin && mat.getHoraFin() >= horaFin) {
				return true;
			}
		}
		return false;
	}
}