package negocio;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Universidad uni = new Universidad();
		try {
			uni.agregarMaterias();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
