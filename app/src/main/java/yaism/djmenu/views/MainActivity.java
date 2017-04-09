package yaism.djmenu.views;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import net.sqlcipher.database.SQLiteDatabase;

import layout.AddMenuFragment;
import layout.HomeFragment;
import yaism.djmenu.R;
import yaism.djmenu.database.DataBaseOpenHelper;
import yaism.djmenu.database.Entity.DaoMaster;
import yaism.djmenu.database.Entity.DaoSession;
import yaism.djmenu.database.Entity.StarterEntity;
import yaism.djmenu.database.Entity.StarterEntityDao;
import yaism.djmenu.views.manager.NavigationManager;

public class MainActivity extends BaseActivity
implements HomeFragment.OnFragmentInteractionListener, AddMenuFragment.OnFragmentInteractionListener{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            /*switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }*/

            return NavigationManager.showFragment(item.getItemId());
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
