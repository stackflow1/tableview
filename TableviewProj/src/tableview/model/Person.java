package tableview.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	public SimpleIntegerProperty ClientID  = new SimpleIntegerProperty();
	public SimpleStringProperty FirstName = new SimpleStringProperty();
	public SimpleStringProperty LastName = new SimpleStringProperty();
	
	
	
	public SimpleIntegerProperty getClientID() {
		return ClientID;
	}
	public SimpleStringProperty getFirstname() {
		return FirstName;
	}
	public SimpleStringProperty getLastName() {
		return LastName;
	}
	public IntegerProperty clientIDProperty(){
		return ClientID;
	}
	public StringProperty firstNameProperty(){
		return FirstName;
		
	}
	public StringProperty lastNameProperty(){
		return LastName;
		
	}
	
	
	
}
