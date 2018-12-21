package model.recipes;

import java.util.*;

/**
 * Represents a single recipe
 */

public class Recipe {

    private String name;
    private static int prepTime;
    private static int cookTime;
    private static boolean vegan;
    private Set<String> ingredients;
    private HashMap<Integer, String> steps; //key is step number, string is instruction

    // constructor
    public Recipe () {
        ingredients = new HashSet<>();
        steps = new HashMap<>();
    }

    // getters
    public String getName(){return name;}
    public int getPrepTime(){return prepTime;}
    public int getCookTime(){return cookTime;}
    public boolean isVegan(){return vegan;}
    public Set<String> getIngredients() {return this.ingredients;}
    public Map<Integer, String> getSteps(){return steps;}

    // setters
    public void setName(String name){this.name = name;}
    public void setPrepTime(int prepTime){this.prepTime = prepTime;}
    public void setCookTime(int cookTime){this.cookTime = cookTime;}
    public void setVegan(boolean vegan){this.vegan = vegan;}

    /**
     * Ingredients
     */

    // MODIFIES: this
    // EFFECTS: adds ingredient to list of recipe's ingredients
    public void addIngredient(String ingredient){
        this.ingredients.add(ingredient);
    }

    // REQUIRES: ingredient given is string
    // EFFECTS:  produces true if inputted ingredient is in Recipe
    public boolean usesIngredient(String ingredient) {
        return ingredients.contains(ingredient);
    }

    /**
     * Steps
     */

    // MODIFIES: this
    // EFFECTS: adds step (instruction string) to recipe at a given step number
    public void addStep(Integer stepNum, String instruction){
        steps.put(stepNum, instruction);
    }

    // EFFECTS: returns the instruction string for a given step number
    public String getStep(Integer stepNum){
        return steps.get(stepNum);
    }



}
