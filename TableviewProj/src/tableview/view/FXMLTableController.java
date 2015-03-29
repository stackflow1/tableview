package tableview.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tableview.model.Person;


public class FXMLTableController {

@FXML
public TableView<Person> tableview ;
@FXML
private TableColumn<Person, Number> clientIdColumn;
@FXML
private TableColumn<Person, String> firstNameColumn;
@FXML
private TableColumn<Person, String> lastNameColumn;
@FXML
private Button Refresh;


private ObservableList<Person> Persondata;
	
@FXML	
private void initialize() {
	     clientIdColumn.setCellValueFactory(cellData -> cellData.getValue()
					.clientIDProperty());
	          
	    firstNameColumn.setCellValueFactory(cellData -> cellData.getValue()
				.firstNameProperty());              
	    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue()
				.lastNameProperty());
	  buildData();
	    
	     
	    
	   
	}



public void buildData(){        
    Persondata = FXCollections.observableArrayList();
    
	
	Connection con = null;
   
    	
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:tableviewdb.db");
    	
        String SQL = "Select * from INFO";            
        ResultSet rs = con.createStatement().executeQuery(SQL);  
        while(rs.next()){
        	

            Person per = new Person();
            per.ClientID.set(rs.getInt("CLIENTID"));
            per.FirstName.set(rs.getString("FIRSTNAME"));
            per.LastName.set(rs.getString("LASTNAME"));
            
            Persondata.add(per);  
        }
        //tableview = new TableView<Person>();
       tableview.setItems(getPersonData());
        System.out.println(tableview.getItems().get(1).ClientID);
        
    }
    catch(Exception e){
          e.printStackTrace();
          System.out.println("Error on Building Data");            
    }
}
public ObservableList<Person> getPersonData(){
	return Persondata;
	
}
}
/*
@FXML
public void refresh(){
	items= FXCollections.observableArrayList();
}
*/

