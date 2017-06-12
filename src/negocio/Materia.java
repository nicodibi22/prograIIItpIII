package negocio;

import java.io.Serializable;

public class Materia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	
	private String codigo;
	
	private int horaInicio;
	
	private int horaFin;
	
	public Materia(String nombre, String codigo, int horaInicio, int horaFin) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public int getHoraInicio() {
		return horaInicio;
	}
	
	public int getHoraFin() {
		return horaFin;
	}

	
}
