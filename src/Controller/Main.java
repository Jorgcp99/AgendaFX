package Controller;

import Model.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;
    static protected model miModel;
    private Stage secondaryStage;

    @Override
    public void start(Stage primaryStage) {
        try {
        	miModel = new model();
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("Agenda");
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../Vista/VistaPrincipal.fxml"));
            rootLayout = (AnchorPane) loader.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void mostrarVentanaAnadir() {
		try {
			FXMLLoader loader2 = new FXMLLoader();

			loader2.setLocation(Main.class.getResource("../vista/VistaEdicion.fxml"));
			rootLayout = (AnchorPane) loader2.load();
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			secondaryStage = new Stage();
            secondaryStage.getIcons().add(new Image("file:resources/images/icon_address.png"));
			secondaryStage.setTitle("Editar Persona");
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
    
    public static void main(String[] args) {
        launch(args);
    }
}