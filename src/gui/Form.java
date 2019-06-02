package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.recipes.Recipe;

import static gui.Main.mainScene;
import static gui.Main.recipeBook;

public class Form implements AppGUI{
    static GridPane formPane;
    static Scene formScene;

    public static Scene makeScene(Stage window){
        Recipe newRecipe = new Recipe();
        setupGridPane();


        // making and formatting the enter recipe text
        Text enterRecipeText = new Text("enter recipe info below: ");
        enterRecipeText.setFont(Font.font("Courier New", FontWeight.NORMAL, 20));
        enterRecipeText.setFill(Color.SADDLEBROWN);
        formPane.add(enterRecipeText, 0, 0, 2, 1);

        // setting up dialog window for invalid inputs
        Stage dialogWindow = new Stage();
        dialogWindow.setTitle("error message");
        GridPane dialogPane = new GridPane();
        dialogPane.setAlignment(Pos.BOTTOM_LEFT);
        dialogPane.setPadding(new Insets(10, 20, 20, 10));


        // make form entry boxes and prompt text
        Label recipeName = new Label("recipe name:");
        makeRecipeFieldThingies(recipeName, formPane, 1);
        TextField recipeNameTextField = new TextField();
        formPane.add(recipeNameTextField, 1, 1);

        Label recipePrepTime = new Label("prep time (min):");
        makeRecipeFieldThingies(recipePrepTime, formPane, 2);
        TextField recipePrepTimeTF = new TextField();
        formPane.add(recipePrepTimeTF,1,2);

        Label recipeCookTime = new Label("cook time (min):");
        makeRecipeFieldThingies(recipeCookTime, formPane, 3);
        TextField recipeCookTimeTF = new TextField();
        formPane.add(recipeCookTimeTF,1, 3);

        Label recipeVegan = new Label("is the recipe vegan?");
        makeRecipeFieldThingies(recipeVegan, formPane, 4);

        Button yesButton = new Button("yes");
        yesButton.fontProperty().setValue(new Font("Courier New", 13));
        formPane.add(yesButton, 1, 4);

        Button noButton = new Button("no");
        noButton.fontProperty().setValue(new Font("Courier New", 13));
        formPane.add(noButton, 1, 5);

        yesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newRecipe.setVegan(true);
                yesButton.setTextFill(Color.FORESTGREEN);
                noButton.setTextFill(Color.BLACK);

            }
        });

        noButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newRecipe.setVegan(false);
                noButton.setTextFill(Color.FORESTGREEN);
                yesButton.setTextFill(Color.BLACK);
            }
        });


        Label recipeNextIngredient = new Label("add ingredient:");
        makeRecipeFieldThingies(recipeNextIngredient,formPane,6);
        final TextField ingredientTF = new TextField();
        formPane.add(ingredientTF,1,6);
        Button addIngredientButton = new Button("add");
        addIngredientButton.fontProperty().setValue(new Font("Courier New", 13));
        formPane.add(addIngredientButton,1,7);
        Text ingredientAdded = new Text("no ingredients added yet");
        ingredientAdded.setFont(new Font("Courier new", 10));
        ingredientAdded.setFill(Color.CORAL);
        formPane.add(ingredientAdded,0,7);

        addIngredientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String ingredientName = ingredientTF.getText();
                newRecipe.addIngredient(ingredientName);
                ingredientAdded.setText("added "+ ingredientName);
                ingredientTF.clear();
            }
        });


        Button backToMainMenuButton = new Button("return to main menu");
        backToMainMenuButton.fontProperty().setValue(new Font("Courier New", 10));
        formPane.add(backToMainMenuButton, 0, 8);
        backToMainMenuButton.setOnAction(e -> window.setScene(mainScene));

        Button submitRecipeButton = new Button("submit recipe to recipe book");
        submitRecipeButton.fontProperty().setValue(new Font("Courier New", 12));
        formPane.add(submitRecipeButton,1,8);
        submitRecipeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newRecipe.setName(recipeNameTextField.getText());

                try{
                    newRecipe.setPrepTime(Integer.parseInt(recipePrepTimeTF.getText()));
                } catch (NumberFormatException nfe){
                    Text needIntegerInputText = new Text("Error: please enter a valid integer");
                    dialogPane.add(needIntegerInputText,0,0);
                    Scene needIntegerInputScene = new Scene(dialogPane);
                    dialogWindow.setScene(needIntegerInputScene);
                    dialogWindow.show();

                }


                try{
                    newRecipe.setCookTime(Integer.parseInt(recipeCookTimeTF.getText()));
                } catch (NumberFormatException nfe){
                    Text needIntegerInputText = new Text("Error: please enter a valid integer");
                    dialogPane.add(needIntegerInputText,0,0);
                    Scene needIntegerInputScene = new Scene(dialogPane);
                    dialogWindow.setScene(needIntegerInputScene);
                    dialogWindow.show();
                }

                //todo: below method
                recipeBook.addRecipe(newRecipe);
                Text recipeSubmitted = new Text("recipe entered. please return to main menu");
                recipeSubmitted.setFont(new Font("Courier New", 9));
                recipeSubmitted.setFill(Color.CORAL);
                formPane.add(recipeSubmitted, 1, 9);
            }

        });


        formScene = new Scene(formPane);
        return formScene;
    }

    // MODIFIES: this
    // EFFECTS: sets up grid pane
    private static void setupGridPane(){
        formPane = new GridPane();
        formPane.setAlignment(Pos.CENTER);
        formPane.setHgap(10);
        formPane.setVgap(10);
        formPane.setPadding(new Insets(25, 25, 25, 25));
    }

    private static void makeRecipeFieldThingies(Label rField, GridPane pane, Integer rowNum){
        Font enterRecipeSceneFont = new Font("Courier New",15);
        rField.setFont(enterRecipeSceneFont);
        rField.setTextFill(Color.CHOCOLATE);
        pane.add(rField, 0, rowNum);
    }
}
