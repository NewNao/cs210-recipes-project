package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class Pantry extends Main {
    static GridPane pantryPane;
    static Scene pantryScene;


    public static Scene makeScene(){
        setupGridPane();
        pantryScene = new Scene(pantryPane);


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
