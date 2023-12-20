# Object-Oriented-Programming
Computer Science: Object Oriented Programming

# This practical aims to familiarise you with JavaFX.
## The Milky Way Space Communication Board (MWSCB)2
is pleased with your progress but now
require a Graphical User Interface(GUI) for your application (to make it more modern).
Create a ShipPane class that extends StackPane (javafx.scene.layout.StackPane). 

This will act as the root node for your Scene. The ShipPane class will have the following components:
• A MenuBar containing a MenuItem to open a FileChooser to select the file to open
• A TitledPane control that provides an expandible container for Ship, including:
– Properties of the Ship in a GridPane layout
• A ListView control to hold and display the Messages data, including:
– TitledPane to display each of the derived Message class objects
– Each derived Message class i.e. SOSMessage, EncryptedMessage and NormalMes‐
sage object is placed inside its own GridPane (for layout of content)
• You may use the following optional controls (or others that you find useful):
– ScrollPane: Provides a scrollable container where necessary
– HBox and VBox: Provide containers for horizontal and vertical stacking of nodes respectively (provided image)
You are provided with a library file (from the last practical) that contains the Ship, Message,
SOSMessage, NormalMessage and EncryptedMessage model classes. In addition, it includes
a DataReader class with a readShipFile method that takes a File as a parameter and returns
a Ship instance. The Ship class has a getMessages method that returns an array of Messages.
You are also provided with a file named shipInfo.dat that you are required to read data from.
Your Main class should contain the following:
• Main must extend Application (javafx.application.Application), and you must implement
the main method correctly
• Implement the start method required by the JavaFX Application
• In your main method, launch the JavaFX Application
• Your class you will need to instantiate an instance of the ShipPane
• Add the ShipPane instance to a Scene and load it onto the Stage provided by the Ap‐
plication and show the Stage
