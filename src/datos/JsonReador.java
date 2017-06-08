package datos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JsonReador<T> {

	public List<T> getArrayObject(String nombreArchivo) {
		
		Type listType = new TypeToken<ArrayList<T>>(){}.getType();
		List<T> yourClassList = new ArrayList<T>();
		try {
			JsonReader reader = new JsonReader(new FileReader(nombreArchivo));
			yourClassList = new Gson().fromJson(reader, listType);
		}catch(Exception e) {
			
		}
		return yourClassList;
	}
	
	public T getObject(String nombreArchivo) throws FileNotFoundException {
		
		Type type = new TypeToken<T>(){}.getType();
		T yourClassList;
		
		JsonReader reader = new JsonReader(new FileReader(nombreArchivo));
		yourClassList = new Gson().fromJson(reader, type);
		
		return yourClassList;
	}
}
