


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	private Button helloButton, howdyButton, chineseButton, clearButton, exitButton;
	private Label label;
	private TextField textField;
	private HBox hbox1, hbox2;
	//student Task #4:
	//  declare an instance of DataManager
	private DataManager mgr;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		helloButton = new Button("Hello");
		helloButton.setOnAction(new ButtonHandler());
		
		howdyButton = new Button("Howdy");
		howdyButton.setOnAction(new ButtonHandler());
		
		chineseButton = new Button("Chinese");
		chineseButton.setOnAction(new ButtonHandler());
		
		clearButton = new Button("Clear");
		clearButton.setOnAction(new ButtonHandler());
		
		exitButton = new Button("Exit");
		exitButton.setOnAction(new ButtonHandler());
		
		label = new Label("Feedback:");
		textField = new TextField();
		
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		mgr = new DataManager();
		
		HBox.setMargin(helloButton, new Insets(2.0, 4.0, 2.0, 4.0));
		HBox.setMargin(howdyButton, new Insets(2.0, 4.0, 2.0, 4.0));
		HBox.setMargin(chineseButton, new Insets(2.0, 4.0, 2.0, 4.0));
		HBox.setMargin(clearButton, new Insets(2.0, 4.0, 2.0, 4.0));
		HBox.setMargin(exitButton, new Insets(2.0, 4.0, 2.0, 4.0));
		
		HBox.setMargin(label, new Insets(2.0, 4.0, 0.0, 2.0));
		HBox.setMargin(textField, new Insets(2.0, 2.0, 0.0, 4.0));
		
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		hbox1.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);
		hbox2.getChildren().addAll(label, textField);
		this.getChildren().setAll(hbox1, hbox2);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if (event.getTarget().equals(helloButton))
				textField.setText(mgr.getHello());
			else if (event.getTarget().equals(howdyButton))
				textField.setText(mgr.getHowdy());
			else if (event.getTarget().equals(chineseButton))
				textField.setText(mgr.getChinese());
			else if (event.getTarget().equals(clearButton))
				textField.setText("");
			else if (event.getTarget().equals(exitButton)) {
				Platform.exit();
				System.exit(0);
			}
			
		}
		
	}
}
	
