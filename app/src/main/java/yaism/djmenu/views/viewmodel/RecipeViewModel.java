package yaism.djmenu.views.viewmodel;

import yaism.djmenu.views.model.RecipeView;

/**
 * Created by Administrateur on 29/08/2017.
 */

public class RecipeViewModel {
    private RecipeView recipeView;

    public RecipeViewModel(RecipeView recipe){
        this.recipeView = recipe;
    }

    /**
     * Handler onClick add recipe
     */
    public void onSaveRecipeClick(){
        System.out.println("Add RECIPE !");
    }
}
