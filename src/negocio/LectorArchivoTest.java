package negocio;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Test;

public class LectorArchivoTest {

	@Test (expected=IOException.class)
	public void leerArchivoNoExistenteTest() throws IOException {
		LectorArchivo.getContenido("testArchivo.txt");
	}
	
	@Test 
	public void leerArchivoExistenteTest() throws IOException  {
		String contenidoArchivo = LectorArchivo.getContenido("./src/negocio/Materia.java");
		assertFalse(contenidoArchivo.isEmpty());
	}

}
