package yaism.djmenu.database;

import android.provider.BaseColumns;

/**
 * Created by Administrateur on 30/03/2017.
 */

public class FeedReaderContract {
    public FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "news";
        public static final String COLUMN_NAME_ENTRY_ID = "news_id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}
