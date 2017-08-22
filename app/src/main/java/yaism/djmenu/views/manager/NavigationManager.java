package yaism.djmenu.views.manager;

import android.support.v4.app.FragmentTransaction;

import yaism.djmenu.DJMenuApplication;
import yaism.djmenu.R;
import yaism.djmenu.views.fragments.AddMenuFragment;
import yaism.djmenu.views.fragments.SearchFragment;

/**
 * Gestion de la navigation
 */
public class NavigationManager {

    public static boolean showFragment(int id){
        boolean result = true;
        if(DJMenuApplication.getInstance().getFragmentManagerApplication() != null){

            FragmentTransaction ft = DJMenuApplication.getInstance().getFragmentManagerApplication().beginTransaction();

            if (id == R.id.navigation_home) {

            } else if (id == R.id.navigation_list_shopping) {
                ft.replace(R.id.main_content, new SearchFragment());
            } else if (id == R.id.navigation_add_menu) {
                ft.replace(R.id.main_content, new AddMenuFragment());
            }
            ft.commit();
        }else{
            result = false;
        }
        return result;
    }
}
