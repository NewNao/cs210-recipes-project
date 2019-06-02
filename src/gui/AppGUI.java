package gui;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

public interface AppGUI {

    Text stringy = new Text("test!");
    Text featureNotSupportedText = new Text("This feature is not yet supported");
    Button backToMainMenuButton = new Button("Back to main menu");
}
