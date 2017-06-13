package negocio;

public class Mock {

	public static String getJsonValidTest() {
		String json = "[" + "{" + "\"nombre\": \"Intro a la Programacion\","
				+ "\"codigo\": \"MAT01\"," + "\"horaInicio\": 10,"
				+ "\"horaFin\": 11 " + "}," + "{"
				+ "\"nombre\": \"Org. del Computador\", "
				+ "\"codigo\": \"MAT05\"," + "\"horaInicio\": 11,"
				+ "\"horaFin\": 12 " + "}," + "{"
				+ "\"nombre\": \"Calculo I\"," + "\"codigo\": \"MAT02\","
				+ "\"horaInicio\": 8," + "\"horaFin\": 10 " + "}," + "{"
				+ "\"nombre\": \"Matemática Discreta\","
				+ "\"codigo\": \"MAT06\"," + "\"horaInicio\": 12,"
				+ "\"horaFin\": 15 " + "}," + "{" + "\"nombre\": \"SORI\","
				+ "\"codigo\": \"MAT03\"," + "\"horaInicio\": 18,"
				+ "\"horaFin\": 20 " + "}," + "{" + "\"nombre\": \"Progra I\","
				+ "\"codigo\": \"MAT04\"," + "\"horaInicio\": 15,"
				+ "\"horaFin\": 19 " + "}," + "{"
				+ "\"nombre\": \"Progra II\"," + "\"codigo\": \"MAT07\","
				+ "\"horaInicio\": 18," + "\"horaFin\": 22" + "}," + "{"
				+ "\"nombre\": \"Progra III\"," + "\"codigo\": \"MAT08\","
				+ "\"horaInicio\": 8," + "\"horaFin\": 12 " + "}," + "{"
				+ "\"nombre\": \"Progra III\"," + "\"codigo\": \"MAT08\","
				+ "\"horaInicio\": 14," + "\"horaFin\": 18 " + "}," + "{"
				+ "\"nombre\": \"EVS\"," + "\"codigo\": \"MAT09\","
				+ "\"horaInicio\": 13," + "\"horaFin\": 17 " + "} " + "]";
		return json;
	}

	public static String getJsonInvalidTest() {
		String json = "{" + "\"nombre\": \"Intro a la Programacion\","
				+ "\"codigo\": \"MAT01\"," + "\"horaInicio\": 10,"
				+ "\"horaFin\": 11 " + "}," + "{"
				+ "\"nombre\": \"Org. del Computador\", "
				+ "\"codigo\": \"MAT05\"," + "\"horaInicio\": 11,"
				+ "\"horaFin\": 12 " + "}";
		return json;
	}
}
