package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.recipes.RecipeBook;

public class Main extends Application implements AppGUI{
    Stage window = new Stage();
    protected static RecipeBook recipeBook;
    final String appName = "Nao's Kitchen";
    protected static Scene mainScene;
    Button enterRecipeOptionButton, viewRecipeOptionButton, openPantryOptionButton, openGroceryListOptionButton;


    @Override
    public void start(Stage primaryStage) throws Exception {
        recipeBook = new RecipeBook();
        setUpWindow(primaryStage);
        makeTheMainButtonsDoThings();
        window.show();
    }

    // EFFECTS: sets up a decorated window with app's title and main scene
    private void setUpWindow(Stage primaryStage){
        window = primaryStage;
        window.setScene(makeMainScene());
        window.setTitle(appName);
        window.initStyle(StageStyle.DECORATED);
    }

    // EFFECTS: constructs the main menu scene with the option buttons
    private Scene makeMainScene(){

        // making the "MAIN MENU" texts / labels
        final Text mainMenuText = new Text("main menu");
        mainMenuText.setFont(new Font("Forte", 50));
        mainMenuText.setFill(Color.SADDLEBROWN);

        final Text mainMenuOptionText = new Text(150, 50, "please select an option below:");
        mainMenuOptionText.setFill(Color.CHOCOLATE);
        mainMenuOptionText.setFont(new Font("Courier New", 20));


        // making the main option buttons
        enterRecipeOptionButton = new Button("enter new recipe");
        stylizeButton(enterRecipeOptionButton);

        viewRecipeOptionButton = new Button("open a recipe");
        stylizeButton(viewRecipeOptionButton);

        openPantryOptionButton = new Button("open pantry");
        stylizeButton(openPantryOptionButton);

        openGroceryListOptionButton = new Button("open grocery list");
        stylizeButton(openGroceryListOptionButton);

        stylizeButton(backToMainMenuButton);


        // set up VBox layout with text and buttons
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(mainMenuText, mainMenuOptionText, enterRecipeOptionButton,
                viewRecipeOptionButton, openPantryOptionButton, openGroceryListOptionButton);
        Insets inset = new Insets(10, 40, 10, 40);

        layout1.setMargin(mainMenuText, inset);
        layout1.setMargin(mainMenuOptionText, inset);
        layout1.setMargin(enterRecipeOptionButton, inset);
        layout1.setMargin(viewRecipeOptionButton, inset);
        layout1.setMargin(openPantryOptionButton, inset);
        layout1.setMargin(openGroceryListOptionButton, inset);

        mainScene = new Scene(layout1);
        return mainScene;
    }

    // MODIFIES: this
    // EFFECTS:  sets the font and font size for the button's label text to courier and 15
    private void stylizeButton(Button button){
        button.fontProperty().setValue(new Font("Courier New", 15));
    }

    // EFFECTS: calls appropriate run-method based on which button is clicked
    // todo: add in the other 3 buttons
    private void makeTheMainButtonsDoThings(){
        enterRecipeOptionButton.setOnAction(e->window.setScene(Form.makeScene(window)));
        //viewRecipeOptionButton.setOnAction(e->window.setScene(makeViewRecipeScene()));
        openPantryOptionButton.setOnAction(e->window.setScene(Pantry.makeScene()));
        openGroceryListOptionButton.setOnAction(e->window.setScene(GroceryList.makeScene()));
        backToMainMenuButton.setOnAction(e->window.setScene(mainScene));
    }

}
