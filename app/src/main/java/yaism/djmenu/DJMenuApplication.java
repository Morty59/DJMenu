package yaism.djmenu;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import net.sqlcipher.database.SQLiteDatabase;

import yaism.djmenu.utils.preferences.PreferencesUtils;

/**
 * Created by Administrateur on 30/03/2017.
 */

public class DJMenuApplication extends Application {

    private static DJMenuApplication ourInstance = new DJMenuApplication();
    private static Context applicationContext;
    private AppCompatActivity mCurrentActivity = null;
    private static FragmentManager applicationFragmentManager;
    private PreferencesUtils preferencesUtils;

    public static DJMenuApplication getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        ourInstance = this;
        applicationContext = getApplicationContext();
        applicationFragmentManager = getCurrentFragmentManager();
        super.onCreate();

        SQLiteDatabase.loadLibs(this);
    }

    public AppCompatActivity getCurrentActivity(){
        return mCurrentActivity;
    }
    public void setCurrentActivity(AppCompatActivity mCurrentActivity){
        this.mCurrentActivity = mCurrentActivity;
    }

    private FragmentManager getCurrentFragmentManager(){
        AppCompatActivity activity = ((DJMenuApplication) getApplicationContext()).getCurrentActivity();
        if(activity != null){
            return activity.getSupportFragmentManager();
        }
        return null;
    }

    public FragmentManager getFragmentManagerApplication() {
        if(applicationFragmentManager == null){
            applicationFragmentManager = getCurrentFragmentManager();
        }
        return applicationFragmentManager;
    }

    public static Context getContextApplication() {
        return applicationContext;
    }

    public PreferencesUtils getPreferencesUtils() {
        if(preferencesUtils == null){
            preferencesUtils = new PreferencesUtils(this);
        }
        return preferencesUtils;
    }
}
