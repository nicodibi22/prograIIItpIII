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
		
		/*String jsonArray = "[" +
				            "{" +
        "\"nombre\": \"value1\","+
        "\"codigo\": \"value1\","+
        "\"horaInicio\": 10," +
        "\"horaFin\": 10 }," +
         "{" +
"\"nombre\": \"value1\","+
"\"codigo\": \"value1\","+
"\"horaInicio\": 10," +
"\"horaFin\": 10 }" + "]"		
        + "";/*,
    {
        "a": 200,
        "b": "value2",
        "c": false
    },
    {
        "a": 300,
        "b": "value3",
        "c": true
    }
]}";*/
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
