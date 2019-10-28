package disponibility;

import org.bukkit.util.Vector;

public class Sumo1Manager {
	
	public static boolean isDisponible = true;
	
	public static Vector vec = null;
	
	// Puestos
	public static boolean puesto1 = true;
	public static boolean puesto2 = true;
	public static boolean puesto3 = true;
	public static boolean puesto4 = true;
	
	public static String person1 = "";
	public static String person2 = "";
	public static String person3 = "";
	public static String person4 = "";
	
	public static String whoWon = "";
	
	public static void setDisponible(boolean toSet) {
		
		isDisponible = toSet;
		
	}
	
	public static void setVector(Vector vector) {
		vec = vector;
	}
	
	// Modificador puestos
	public static void setPuesto1(boolean toSet) {
		puesto1 = toSet;
	}
	
	public static void setPuesto2(boolean toSet) {
		puesto2 = toSet;
	}
	
	public static void setPuesto3(boolean toSet) {
		puesto3 = toSet;
	}
	
	public static void setPuesto4(boolean toSet) {
		puesto4 = toSet;
	}
	
	// --------------------------------------------
	
	public static void setPerson1(String name) {
		person1 = name;
	}
	
	public static void setPerson2(String name) {
		person2 = name;
	}
	
	public static void setPerson3(String name) {
		person3 = name;
	}
	
	public static void setPerson4(String name) {
		person4 = name;
	}
	
	
	public static void setWhoWon(String name) {
		whoWon = name;
	}
	
}
