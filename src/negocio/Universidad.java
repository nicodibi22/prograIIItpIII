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
		_aulas.add(new Aula(""));
	}
	
	public int cantidadAulas() {
		return _aulas.size();
	}
	
	public int cantidadMaterias() {
		return _materias.size();
	}
	
	public void procesar() {		
		ordenarMateriasPorHorarioInicio();
	}
	
	
	private void ordenarMateriasPorHorarioInicio() {
		Collections.sort(_materias, (p1, p2) -> p1.getHoraInicio() - p2.getHoraInicio());
	}
}
