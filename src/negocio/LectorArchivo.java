package negocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivo {

	public static String getContenido(String nombreArchivo) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String response = new String();
		for (String line; (line = br.readLine()) != null; response += line);
		br.close();
		return response;				
	}
}
