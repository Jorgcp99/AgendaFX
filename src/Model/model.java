package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Person;

public class model {
	
	protected static ObservableList<Person> data;
	
	
	public model() {
		data = FXCollections.observableArrayList();
		data.addAll(new Person("Pedro", "Camacho", "pedro.camacho@gmail.com"),
				new Person("David", "Jardon", "david.jardon@gmail.com"),
				new Person("Laura", "Jaen", "laura.jaen@gmail.com"));
	}
	
	public void addPersona(Person nueva) {
		data.add(nueva);
	}
	
	public static void dropPersona(int index) {
		data.remove(index);
	}


	public static ObservableList<Person> getPersonas() {
		return data;
	}
	
}