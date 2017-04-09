package yaism.djmenu.views.manager;

import android.support.v4.app.FragmentTransaction;

import layout.AddMenuFragment;
import layout.HomeFragment;
import yaism.djmenu.R;
import yaism.djmenu.DJMenuApplication;

/**
 * Created by a105225 on 23/03/2017.
 */

public class NavigationManager {

    public static boolean showFragment(int id){
        boolean result = true;
        if(DJMenuApplication.getInstance().getFragmentManagerApplication() != null){

            FragmentTransaction ft = DJMenuApplication.getInstance().getFragmentManagerApplication().beginTransaction();

            if (id == R.id.navigation_home) {
                ft.replace(R.id.main_content, new HomeFragment());
            } else if (id == R.id.navigation_search_menu) {
                ft.replace(R.id.main_content, new AddMenuFragment());
            } else if (id == R.id.navigation_add_menu) {
            }
            ft.commit();
        }else{
            result = false;
        }
        return result;
    }
}
