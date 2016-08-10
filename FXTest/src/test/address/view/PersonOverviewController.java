package test.address.view;

import java.awt.Dialog;

import org.controlsfx.dialog.Dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import test.address.DateUtil;
import test.address.MainApp;
import test.address.model.Person;

/**
 * @author ymc
 * @version 创建时间：2016年1月19日 下午4:37:03
 *
 */
public class PersonOverviewController {
	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label birthdayLabel;

	// Reference to the main application.
	private MainApp mainApp;

	public PersonOverviewController() {
	}

	@FXML
	private void initialize() {
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

		showPersonDetails(null);
		personTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		personTable.setItems(mainApp.getPersonData());
	}

	private void showPersonDetails(Person person) {
		if (person != null) {
			// Fill the labels with info from the person object.
			firstNameLabel.setText(person.getFirstName());
			lastNameLabel.setText(person.getLastName());
			streetLabel.setText(person.getStreet());
			postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
			cityLabel.setText(person.getCity());
			birthdayLabel.setText(DateUtil.format(person.getBirthday()));
		} else {
			// Person is null, remove all the text.
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			streetLabel.setText("");
			postalCodeLabel.setText("");
			cityLabel.setText("");
			birthdayLabel.setText("");
		}
	}

	@FXML
	private void handleDeletePerson() {
		int selected = personTable.getSelectionModel().getSelectedIndex();
		if (selected >= 0) {
			personTable.getItems().remove(selected);
		} else {
			Dialogs.create().title("No Selected").masthead("No one item selected").message(" Please select one item")
					.showWarning();
		}
	}

	@FXML
	private void handleAddPerson() {
		Person tmp = new Person();
		boolean isClicked = mainApp.showPersonEditDialog(tmp);
		if(isClicked){
			mainApp.getPersonData().add(tmp);
		}
	}

	@FXML
	private void handleEditPerson() {
		 Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		    if (selectedPerson != null) {
		        boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
		        if (okClicked) {
		            showPersonDetails(selectedPerson);
		        }

		    } else {
		        // Nothing selected.
		        Dialogs.create()
		            .title("No Selection")
		            .masthead("No Person Selected")
		            .message("Please select a person in the table.")
		            .showWarning();
		    }

	}

}
