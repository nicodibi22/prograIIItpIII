package negocio;

import java.util.ArrayList;

import datos.DaoMateria;

public class Universidad {

	private ArrayList<Materia> _materias;
	
	private ArrayList<Aula> _aulas;
	
	public Universidad() {
		_materias = new ArrayList<Materia>();
		_aulas = new ArrayList<Aula>();
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
}
