package yaism.djmenu.database.Entity;

import android.util.Log;

import org.junit.Test;

import yaism.djmenu.DJMenuApplication;
import yaism.djmenu.database.DataBaseOpenHelper;

import static org.junit.Assert.*;

/**
 * Created by Administrateur on 08/04/2017.
 */
public class StarterEntityDaoTest {

    @Test
    public void readEntity() throws Exception {
        DaoMaster daoMaster=new DaoMaster(new DataBaseOpenHelper(new DJMenuApplication(), "Passwd").getEncryptedDatabase());
        DaoSession session = daoMaster.newSession();

        StarterEntityDao starterEntityDao = session.getStarterEntityDao();

        StarterEntity starter= new StarterEntity(Long.valueOf(1),"Starter 1");
        starterEntityDao.insert(starter);
        StarterEntity entity = starterEntityDao.queryBuilder().where(StarterEntityDao.Properties.Id.eq(Long.valueOf(1))).unique();

        if(entity != null){
            Log.d("First read greendao ! ", "STARTER NAME : "+ entity.getName());
        }
    }

}