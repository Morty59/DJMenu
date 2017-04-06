package yaism.djmenu;

import android.app.Application;

import net.sqlcipher.database.SQLiteDatabase;

/**
 * Created by Administrateur on 30/03/2017.
 */

public class DJMenuApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SQLiteDatabase.loadLibs(this);
    }
}
