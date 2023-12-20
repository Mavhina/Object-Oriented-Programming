package csc2a.acsse.gui;

import java.io.File;

import acsse.csc2a.file.DataReader;
import acsse.csc2a.model.Message;
import acsse.csc2a.model.MESSAGE_TYPE;
import acsse.csc2a.model.Ship;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * A class representing the ship pane to be used to display ship and the messages
 * @author mavhinamulisa
 *@version P05
 */
public class ShipPane extends StackPane{
	
	private Ship ship = null;
	// Creating a ListView for Displaying the TitledPanes as a List.
	private ListView<TitledPane> listView;
			
			
	/**
	 * 
	 */
	public ShipPane()
	{
		
		//Instantiating the MenuBar and adding a Menu
		MenuBar menubar = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem OpenMenuItem = new MenuItem("Open"); 
		
		
		fileMenu.getItems().add(OpenMenuItem);
		menubar.getMenus().add(fileMenu);
		
		//Adding an action listener for "open" menu item
		OpenMenuItem.setOnAction(e ->{
			final FileChooser chooser = new FileChooser();
			chooser.setTitle("Select Shipinfo file");
			chooser.setInitialDirectory(new File("data"));
			File file = chooser.showOpenDialog(null);
			if (file != null) {
				ship = DataReader.readShipFile(file);
				createChildren();
			}
		});
		
		VBox layout = new VBox(); //creating a VBox to hold the menuBar
		layout.getChildren().addAll(menubar);
		this.getChildren().add(layout);
		this.setWidth(400);
		this.setHeight(500);
	}
	
	/**
	 * Creates a GridPane for Message 
	 * @param message
	 * @return the created GridPane
	 */
	public VBox createMeesageGrid(MESSAGE_TYPE typeMSG)
	{
		
		VBox vbMSG = new VBox();
		
		for(Message message: ship.getMessages())
		{
			GridPane grid = new GridPane();
			
			//Adding vertical and horizontal spacing
			grid.setVgap(4);
			grid.setHgap(40);
			//grid.setPadding(new Insets(5, 5, 5, 5)); //adding padding
		
			if(message.getMessage_type() == typeMSG)
			{
				grid.add(new Label("ID: "), 0, 0);
				grid.add(new TextField(message.getID()), 1, 0);
				
				grid.add(new Label("Source: "), 2, 0);
				grid.add(new TextField(message.getPlanet_source().toString()), 3, 0);
				
				grid.add(new Label("Type: "), 0, 1);
				grid.add(new TextField(message.getMessage_type().toString()), 1, 1);
				
				grid.add(new Label("Destination: "), 2, 1);
				grid.add(new TextField(message.getPlanet_destination().toString()), 3, 1);
				
				grid.add(new Label("Contents: "), 0, 2);
				TextField txtcontent = new TextField();
				txtcontent = new TextField(message.getContents());
				txtcontent.setPrefWidth(250);
				grid.add(txtcontent, 1, 2);
				//grid.add(new TextField(message.getContents()), 1, 2);
			}
			vbMSG.getChildren().add(grid);
		}
		return vbMSG;
	}
	
	/**
	 *  creates the component nodes that will exist inside the StackPane
	 */
	public void createChildren()
	{
		TitledPane shipTittlePane = new TitledPane();
		shipTittlePane.setText("Ship Information");	
		shipTittlePane.setContent(createShipGrid(ship));
		
		TitledPane SOSMessageTittlePane = new TitledPane();
		SOSMessageTittlePane.setText("SOSMessage");
		SOSMessageTittlePane.setContent(createMeesageGrid(MESSAGE_TYPE.SOSMessage));
		
		TitledPane EncryptedMSGTittlePane = new TitledPane();
		EncryptedMSGTittlePane.setText("Encrypted Message");
		EncryptedMSGTittlePane.setContent(createMeesageGrid(MESSAGE_TYPE.EncryptedMessage));
		
		TitledPane NormalMSGTittlePane = new TitledPane();
		NormalMSGTittlePane.setText("Normal Message");
		NormalMSGTittlePane.setContent(createMeesageGrid(MESSAGE_TYPE.NormalMessage));
		
		VBox layout = new VBox(); //creating a VBox to hold the menuBar
		layout.getChildren().add(shipTittlePane);
		
		listView = new ListView<TitledPane>();
		listView.getItems().addAll(SOSMessageTittlePane,EncryptedMSGTittlePane,NormalMSGTittlePane);
		
		layout.getChildren().add(listView);
			
		this.getChildren().clear();
		this.getChildren().add(layout); // Adding the ListView to the Message [StackPane].
		
	}
	
	/**
	 * creates a GridPane using a ship 
	 * 
	 * @param ship
	 * @return The created GridPane
	 */
	private GridPane createShipGrid(Ship ship) 
	{
		
		GridPane grid = new GridPane();
		
		grid.setVgap(4);
		grid.setHgap(40);
		grid.setPadding(new Insets(5, 5, 5, 5));
		
		grid.add(new Label("Ship ID: "), 0, 0);
		grid.add(new TextField(ship.getID()), 0, 1);
		
		grid.add(new Label("Ship Name: "), 1, 0);
		grid.add(new TextField(ship.getName()), 1, 1);
		
		return grid;
	}
	
}
