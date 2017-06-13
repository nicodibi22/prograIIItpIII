package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import datos.DaoMateria;

public class Universidad {

	private ArrayList<Materia> materias;
	
	private ArrayList<Aula> aulas;
	
	private Map<String, ArrayList<Materia>> _materiasPorAula;
	
	public Universidad() {
		materias = new ArrayList<Materia>();
		aulas = new ArrayList<Aula>();
		_materiasPorAula = new HashMap<String, ArrayList<Materia>>();
	}
	
	public boolean cargarMaterias(String procesar) {		
		materias = DaoMateria.getMaterias(procesar);		
		return true;
	}
	
	public void agregarRelacionAulaMateria(Aula aula, Materia materia) {
		
		if(!aulas.contains(aula)) {
			throw new IllegalArgumentException("El aula no pertenece a la Universidad");
		}
		if(!materias.contains(materia)) {
			throw new IllegalArgumentException("La materia no se dicta en la Universidad");
		}
		
		ArrayList<Materia> materiasAula = _materiasPorAula.get(aula.getCodigo());
		materiasAula.add(materia);
		_materiasPorAula.put(aula.getCodigo(), materiasAula);
	}
	
	public ArrayList<Materia> getMateriasPorAula(String codigoAula) {
		return _materiasPorAula.get(codigoAula);
	}
	
	public Aula agregarAula() {
		Aula aulaNueva = Aula.aulaNueva("A" + aulas.size());
		aulas.add(aulaNueva);
		_materiasPorAula.put(aulaNueva.getCodigo(), new ArrayList<Materia>());
		return aulaNueva;
	}
	
	public int cantidadAulas() {
		return aulas.size();
	}
	
	public int cantidadMaterias() {
		return materias.size();
	}
	
	public ArrayList<Materia> materias() {
		return materias;
	}
	
	public ArrayList<Aula> aulas() {
		return aulas;
	}
}