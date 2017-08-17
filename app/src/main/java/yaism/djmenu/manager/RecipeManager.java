package yaism.djmenu.manager;

import yaism.djmenu.views.model.RecipeView;

/**
 * Created by Administrateur on 09/04/2017.
 */

public class RecipeManager {

    public enum RecipeType{
        STARTER(1),
        DISH(2),
        DESSERT(3);

        RecipeType (int i)
        {
            this.type = i;
        }

        private int type;

        public int getNumericType()
        {
            return type;
        }
    }

    public boolean addRecipe(RecipeView recipeView){
        return false;
    }
}
