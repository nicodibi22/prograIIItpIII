package negocio;

public class Aula {

	private String codigo;
	
	public static Aula aulaNueva(String codigo) {
		Aula aula = new Aula();
		aula.codigo = codigo;
		return aula;
	}	
	
	public static Aula aulaVacia() {
		return new Aula();
	}
	
	private Aula() {
	}
	
	public String getCodigo() {
		return codigo;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass())
			return false;

		Aula aula = (Aula) obj;

		if (this.codigo.equals(aula.getCodigo())) {
			return true;
		}
		return false;
	}
}
