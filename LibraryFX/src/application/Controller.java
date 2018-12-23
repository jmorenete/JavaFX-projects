package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller implements Initializable{

	@FXML
	private Button addUserBtn;
	@FXML
	private TextField nameAdd;
	@FXML
	private TextField midNameAdd;
	@FXML
	private TextField lastNameAdd;
	@FXML
	private TextField dobAdd;
	@FXML
	private Button userShowBtn;
	@FXML
	private TextArea showUsers;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	Library lib = new Library();
	
	public void add(ActionEvent event) {
		String name = nameAdd.getText();
		String midName = midNameAdd.getText();
		String lastName = lastNameAdd.getText();
		String dob = dobAdd.getText();
		boolean namePresent = false;
		
	
		for(People p:People.peoplereg) {
			if(!(p.getName().equals(name) && p.getSurname().equals(lastName))) {
				continue;
			}
			else {
				namePresent = true;
			}
		}
		if(!midName.isEmpty()&& !namePresent) {
			lib.addPerson(name, lastName, dob);
		}
		else if(!namePresent) {
			lib.addPerson(name, midName, lastName,dob);
		}
		else if(namePresent) {
			Alert alert = new Alert(AlertType.WARNING, "User already exists");
			alert.showAndWait();
			
		}
		
	}
	
	public void show(ActionEvent event) {
		showUsers.clear();
		for(People p:People.peoplereg) {
			showUsers.appendText("Name: "+ p.getName()+" "+ p.getMidname()+" "+p.getSurname() +" ID: "+ p.getPersonId() +"\n");
		}
	}
	
	
}
