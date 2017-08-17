package yaism.djmenu.database;

import android.content.Context;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

import org.greenrobot.greendao.database.EncryptedDatabase;

import yaism.djmenu.database.Entity.DaoMaster;

/**
 * Created by Administrateur on 30/03/2017.
 */

public class DataBaseOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DJMenu.db";
    private final SQLiteDatabase db;
    private final EncryptedDatabase encryptedDatabase;

    public SQLiteDatabase getDb() {
        return db;
    }

    public EncryptedDatabase getEncryptedDatabase() {
        return encryptedDatabase;
    }

    public DataBaseOpenHelper(Context context, String password){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase(password);

        encryptedDatabase = new EncryptedDatabase(db);
        DaoMaster.createAllTables(encryptedDatabase, true);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
