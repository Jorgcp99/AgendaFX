package Vista;

import java.awt.event.ActionEvent;

import Controller.Main;
import Model.Person;
import Model.model;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller_vistaPrincipal extends Main {
	@FXML
	protected TableView myTable = new TableView();
	
	@FXML
	private TableColumn<Person, String> tcNombre;
	@FXML
	private TableColumn<Person, String> tcApellido;
	@FXML
	private TableColumn<Person, String> tcTelefono;
	@FXML
	private Button btn_nuevo;
	@FXML
	private Button btn_editar;
	@FXML
	private Button btn_borrar;
	
	private Alert alert;
	
	static protected int indice;
	static protected boolean editando;
	public void refrescarTabla() {
		try {
			myTable.setItems(model.getPersonas());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	@FXML
	public void initialize() {
		tcNombre.setCellValueFactory(new PropertyValueFactory<Person, String>("Nombre"));
		tcApellido.setCellValueFactory(new PropertyValueFactory<Person, String>("Apellido"));
		tcTelefono.setCellValueFactory(new PropertyValueFactory<Person, String>("Email"));
		refrescarTabla();
	}

	
	public void borrarPersona() {
		if (myTable.getSelectionModel().getSelectedItem() == null) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR EN LA ELECCION");
			alert.setHeaderText("No eligio ninguna opcion");
			alert.showAndWait();
		} else {
			miModel.dropPersona(myTable.getSelectionModel().getSelectedIndex());
			myTable.getSelectionModel().clearSelection();
			refrescarTabla();

		}
	}
	
	public void editarPersona() {
		if (myTable.getSelectionModel().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR EN LA ELECCION");
			alert.setHeaderText("No eligio ninguna opcion");
			alert.showAndWait();
		} else {
			indice = myTable.getSelectionModel().getSelectedIndex();
			editando = true;
			mostrarVentanaAnadir();

		}

	}
	
}
