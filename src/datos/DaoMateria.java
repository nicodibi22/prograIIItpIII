package datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import negocio.Materia;

public class DaoMateria {

	public static ArrayList<Materia> getMaterias(String nombreArchivo) throws Exception {
		
		/*String jsonArray = [
	{
		"nombre": "value1",
		"codigo": "value1",
		"horaInicio": 10,
		"horaFin": 10 
	},
    {
		"nombre": "value2",
		"codigo": "value2",
		"horaInicio": 11,
		"horaFin": 12 
	},
    {
		"nombre": "value3",
		"codigo": "value3",
		"horaInicio": 8,
		"horaFin": 10 
	}
]*/
		ArrayList<Materia> yourClassList;
		try {
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			Type listType = new TypeToken<List<Materia>>(){}.getType();
			 yourClassList = new ArrayList<Materia>();
			
			BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
			yourClassList = gson.fromJson(br, listType);
			
			/*JsonLector<Materia> reader = new JsonLector<Materia>();
			yourClassList =  (ArrayList<Materia>) reader.getArrayObject(nombreArchivo);*/
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return yourClassList;
	}
}
