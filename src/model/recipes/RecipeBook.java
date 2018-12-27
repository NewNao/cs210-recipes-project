package model.recipes;

import java.util.HashSet;
import java.util.Set;

//todo: figure out how to / if I should use Singleton design pattern
public class RecipeBook{

    private Set<Recipe> recipes;

    public RecipeBook(){
        recipes = new HashSet<>();
    }


    public void addRecipe(Recipe r){
        if(!recipes.contains(r)) {
            recipes.add(r);
        }
    }

    public void removeRecipe(Recipe r){
        if(recipes.contains(r)){
            recipes.remove(r);
        }
    }
}
