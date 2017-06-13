package datos;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import negocio.Materia;

public class DaoMateria {

	public static ArrayList<Materia> getMaterias(String json) throws JsonSyntaxException {
		
		ArrayList<Materia> yourClassList;
		try {
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();			
			Type listType = new TypeToken<List<Materia>>(){}.getType();
			yourClassList = new ArrayList<Materia>();			
			yourClassList = gson.fromJson(json, listType);
		} catch (JsonSyntaxException e) {
			throw new JsonSyntaxException(e.getMessage());
		}
		return yourClassList;
	}
}
