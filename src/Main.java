import csc2a.acsse.gui.ShipPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author mavhinamulisa
 *@version P05
 */
public class Main extends Application{
	
	// The class extending StackPane we use to display Ship file information.
		private ShipPane pane = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);  // Calling this method will launch the JavaFX application.

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			// Instantiate the ShipPane.
			pane = new ShipPane();
			// Placing the pane in the Scene.
			Scene scene = new Scene(pane);
			// Set up the Stage.
			primaryStage.setTitle("Ship Transportation Information");
			primaryStage.setWidth(400);
			primaryStage.setHeight(600);
			// Add the Scene to the Stage.
			primaryStage.setScene(scene);
			// Display the Stage.
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
