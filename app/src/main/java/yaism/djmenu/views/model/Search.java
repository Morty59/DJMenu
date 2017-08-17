package yaism.djmenu.views.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;

import yaism.djmenu.database.Entity.RecipeEntity;

/**
 * Created by Administrateur on 09/04/2017.
 */

public class Search extends BaseObservable {

    public final ObservableArrayList<RecipeEntity> listRecipe = new ObservableArrayList<RecipeEntity>();

}
