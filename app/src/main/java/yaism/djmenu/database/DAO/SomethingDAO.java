package yaism.djmenu.database.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

import yaism.djmenu.MainActivity;
import yaism.djmenu.database.FeedReaderContract;
import yaism.djmenu.database.FeedReaderDbHelper;

/**
 * Created by Administrateur on 30/03/2017.
 */

public class SomethingDAO extends BaseDAO{

    public SomethingDAO(Context context){
        super(context);
    }
    public void createSomething(){
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID, 1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "Easter Bunny has escaped!");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "A thrilling story which proves how fragile our hearts are...");

        db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);

        Cursor cursor = db.rawQuery("SELECT * FROM '" + FeedReaderContract.FeedEntry.TABLE_NAME + "';", null);
        Log.d(MainActivity.class.getSimpleName(), "Rows count: " + cursor.getCount());
        cursor.close();
        db.close();
    }
}
