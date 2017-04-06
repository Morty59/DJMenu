package yaism.djmenu.database.DAO;

import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.EncryptedDatabase;

import yaism.djmenu.database.FeedReaderDbHelper;

/**
 * Created by Administrateur on 30/03/2017.
 */

public abstract class BaseDAO {
    protected final SQLiteDatabase db;

    public BaseDAO(Context context){
        db = FeedReaderDbHelper.getInstance(context).getWritableDatabase("somePass");
        EncryptedDatabase encryptedDatabase = new EncryptedDatabase(db);
    }
}
