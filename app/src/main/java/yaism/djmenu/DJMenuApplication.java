package yaism.djmenu;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.sqlcipher.database.SQLiteDatabase;

import yaism.djmenu.database.DataBaseOpenHelper;
import yaism.djmenu.database.Entity.DaoMaster;
import yaism.djmenu.database.Entity.DaoSession;
import yaism.djmenu.database.Entity.RecipeEntity;
import yaism.djmenu.database.Entity.RecipeEntityDao;
import yaism.djmenu.manager.RecipeManager;
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
    private DaoMaster daoMaster;

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
        initApp();
    }

    private void initApp() {
        daoMaster=new DaoMaster(new DataBaseOpenHelper(getApplicationContext(), "Passwd").getEncryptedDatabase());
        DaoSession session = daoMaster.newSession();
        //TODO init a supprimer
        RecipeEntityDao recipeEntityDao = session.getRecipeEntityDao();
        if(recipeEntityDao.count() <= 0){
            for(int i = 0; i<50; i++){
                RecipeEntity recipeEntity= new RecipeEntity(new Long(i),"Title "+i,"Description "+i, RecipeManager.RecipeType.DISH.getNumericType());
                recipeEntityDao.insert(recipeEntity);
            }
        }

        RecipeEntity entity = recipeEntityDao.queryBuilder().where(RecipeEntityDao.Properties.Id.eq(new Long(1))).unique();

        if(entity != null){
            Log.d("First read greendao ! ", "STARTER NAME : "+ entity.getName());
        }
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

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }
}
