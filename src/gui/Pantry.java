package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Pantry extends Main {
    static GridPane pantryPane;
    static Scene pantryScene;
    static Text featureNotSupportedText = new Text("This feature is not yet supported");
    static Button backToMainMenuButton;

    public static Scene makeScene(){
        setupGridPane();
        pantryScene = new Scene(pantryPane);

        backToMainMenuButton  = new Button("Back to main menu");
        backToMainMenuButton.setOnAction(e->window.setScene(mainScene));

        pantryPane.add(featureNotSupportedText, 1,1);
        pantryPane.add(backToMainMenuButton, 1, 2);



        return pantryScene;
    }

    // MODIFIES: this
    // EFFECTS: sets up grid pane
    private static void setupGridPane(){
        pantryPane = new GridPane();
        pantryPane.setAlignment(Pos.CENTER);
        pantryPane.setHgap(10);
        pantryPane.setVgap(10);
        pantryPane.setPadding(new Insets(25, 25, 25, 25));
    }

}
