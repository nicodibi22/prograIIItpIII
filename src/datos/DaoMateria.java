package datos;

import java.util.ArrayList;
import java.util.List;

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
		List<Materia> yourClassList = new ArrayList<Materia>();
		try {
			JsonLector<Materia> reader = new JsonLector<Materia>();
			yourClassList = reader.getArrayObject(nombreArchivo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return (ArrayList<Materia>) yourClassList;
	}
}
