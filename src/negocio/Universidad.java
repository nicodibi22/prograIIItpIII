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
	
	private ArrayList<Asignacion> _asignaciones;
	
	private Map<Aula, ArrayList<Materia>> _materiasPorAula;
	
	public Universidad() {
		_materias = new ArrayList<Materia>();
		_aulas = new ArrayList<Aula>();
		_asignaciones = new ArrayList<Asignacion>();
		_materiasPorAula = new HashMap<Aula, ArrayList<Materia>>();
	}
	
	public boolean cargarMaterias(String nombreArchivo) throws Exception {
		
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
			aulaAsignar = _aulas.get(cantidadAulas()- 1);
			_materiasPorAula.put(aulaAsignar, new ArrayList<Materia>());
		}
		_asignaciones.add(new Asignacion(aulaAsignar, materia));
		ArrayList<Materia> materiasAula = _materiasPorAula.get(aulaAsignar);
		materiasAula.add(materia);
		_materiasPorAula.put(aulaAsignar, materiasAula);

		
	}

	private void ordenarMateriasPorHorarioInicio() {
		Collections.sort(_materias, (p1, p2) -> p1.getHoraInicio() - p2.getHoraInicio());
	}
	
	public boolean estaOcupada(Aula aula, int horaInicio, int horaFin) {
		
		for(Materia mat : _materiasPorAula.get(aula)) {
			if(mat.getHoraInicio() <= horaInicio &&  mat.getHoraFin() >  horaInicio
					|| mat.getHoraInicio() < horaFin && mat.getHoraFin() >= horaFin) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Materia> getMateriasPorAula(String codigoAula) {
		Aula aulaBusqueda = Aula.aulaNueva(codigoAula);
		return _materiasPorAula.get(aulaBusqueda);
	}		
	
	public ArrayList<Asignacion> getAsignaciones() {
		//Aula aulaBusqueda = Aula.aulaNueva(codigoAula);
		return _asignaciones;
	}
}