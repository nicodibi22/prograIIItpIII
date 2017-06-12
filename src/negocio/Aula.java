package negocio;

public class Aula {

	private String _codigo;
	
	public static Aula aulaNueva(String codigo) {
		Aula aula = new Aula();
		aula._codigo = codigo;
		return aula;
	}	
	
	public static Aula aulaVacia() {
		return new Aula();
	}
	
	private Aula() {
	}
	
	public String getCodigo() {
		return _codigo;
	}

	
}
