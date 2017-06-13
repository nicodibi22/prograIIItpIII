package negocio;

public class Asignacion {

	private String _aula;
	
	private String _materiaCodigo;
	
	private String _materiaNombre;
	
	private int _materiaHoraInicio;
	
	private int _materiaHoraFin;
	
	public String getAula() {
		return _aula;
	}

	public String getMateriaCodigo() {
		return _materiaCodigo;
	}

	public String getMateriaNombre() {
		return _materiaNombre;
	}

	public int getMateriaHoraInicio() {
		return _materiaHoraInicio;
	}

	public int getMateriaHoraFin() {
		return _materiaHoraFin;
	}

	public Asignacion(Aula aula, Materia materia) {
		_aula = aula.getCodigo();
		_materiaCodigo = materia.getCodigo();
		_materiaNombre = materia.getNombre();
		_materiaHoraInicio = materia.getHoraInicio();
		_materiaHoraFin = materia.getHoraFin();
	}
		
}
