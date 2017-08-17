package yaism.djmenu.views.model;

import yaism.djmenu.manager.RecipeManager;

/**
 * Created by Administrateur on 09/04/2017.
 */

public class RecipeView {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RecipeManager.RecipeType getType() {
        return type;
    }

    public void setType(RecipeManager.RecipeType type) {
        this.type = type;
    }

    private RecipeManager.RecipeType type;
}
