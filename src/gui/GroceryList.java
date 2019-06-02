package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class GroceryList implements AppGUI {
    static GridPane groceryListPane;
    static Scene groceryListScene;


    public static Scene makeScene(){
        setupGridPane();
        groceryListScene = new Scene(groceryListPane);

        groceryListPane.add(featureNotSupportedText, 1, 1);
        groceryListPane.add(backToMainMenuButton, 1, 2);
        return groceryListScene;

    }

    // MODIFIES: this
    // EFFECTS: sets up grid pane
    private static void setupGridPane(){
        groceryListPane= new GridPane();
        groceryListPane.setAlignment(Pos.CENTER);
        groceryListPane.setHgap(10);
        groceryListPane.setVgap(10);
        groceryListPane.setPadding(new Insets(25, 25, 25, 25));
    }

}
