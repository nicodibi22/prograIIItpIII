package datos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class JsonLector<T> {

	public ArrayList<T> getArrayObject(String nombreArchivo) throws FileNotFoundException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		Type listType = new TypeToken<List<T>>(){}.getType();
		ArrayList<T> yourClassList = new ArrayList<T>();
		
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		yourClassList = gson.fromJson(br, listType);
		
		/*JsonReader reader = new JsonReader(new FileReader(nombreArchivo));
		yourClassList = new Gson().fromJson(reader, listType);*/
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
