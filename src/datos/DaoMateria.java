package datos;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.lang.reflect.Type;

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

		Type listType = new TypeToken<ArrayList<Materia>>(){}.getType();
		List<Materia> yourClassList = new ArrayList<Materia>();
		try {
			JsonReader reader = new JsonReader(new FileReader(nombreArchivo));
			yourClassList = new Gson().fromJson(reader, listType);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		
		return (ArrayList<Materia>) yourClassList;
	}
}
