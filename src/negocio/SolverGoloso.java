package negocio;

import java.util.ArrayList;
import java.util.Collections;

public class SolverGoloso {

	private Universidad _universidad;
	
	public SolverGoloso(Universidad universidad) {
		_universidad = universidad;
	}
	
	ArrayList<Materia> ordenar() {
		
		ArrayList<Materia> mats = _universidad.materias();		
		Collections.sort(mats, (p1, p2) -> p1.getHoraInicio() - p2.getHoraInicio());		
		return mats;		
	}
	
	boolean estaOcupada(Aula aula, int horaInicio, int horaFin) {
		
		ArrayList<Materia> materias = _universidad.getMateriasPorAula(aula.getCodigo());
		for(Materia mat : materias) {
			if(mat.getHoraInicio() <= horaInicio &&  mat.getHoraFin() >  horaInicio
					|| mat.getHoraInicio() < horaFin && mat.getHoraFin() >= horaFin
					|| mat.getHoraInicio() >= horaInicio && mat.getHoraFin() <= horaFin) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Asignacion> resolver()
	{
		ArrayList<Materia> ordenados = ordenar();
		return generarSolucion(ordenados);
	}
	
	private ArrayList<Asignacion> generarSolucion(ArrayList<Materia> ordenados)
	{
		ArrayList<Asignacion> asignaciones = new ArrayList<Asignacion>();
		for (Materia materia : _universidad.materias()) {
			Aula aula = asignarAula(materia);
			asignaciones.add(new Asignacion(aula, materia));
		}		
		return asignaciones;
	}
	
	Aula asignarAula(Materia materia) {
		Aula aulaAsignar = Aula.aulaVacia();
		boolean hayAulaVacia = false;
		for(Aula aula : _universidad.aulas()) {
			if(!estaOcupada(aula, materia.getHoraInicio(), materia.getHoraFin())) {
				aulaAsignar = aula;
				hayAulaVacia = true; 	
				break;
			} 
		}
		if(!hayAulaVacia) {
			aulaAsignar = _universidad.agregarAula();			
		}		
		_universidad.agregarRelacionAulaMateria(aulaAsignar, materia);
		return aulaAsignar;
	}


	
}
