package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RecipeBook {

    static GridPane rbPane;
    static Scene rbScene;
    static RecipeBook rBook;

    public static Scene makeScene(Stage window){
        setupGridPane();






    }

    private static void setupGridPane() {
        rbPane = new GridPane();
        rbPane.setAlignment(Pos.CENTER);
        rbPane.setHgap(10);
        rbPane.setVgap(10);
        rbPane.setPadding(new Insets(25, 25, 25, 25));


    }


}
