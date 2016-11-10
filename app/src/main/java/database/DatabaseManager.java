package database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chemcee. M. C on 10-11-2016.
 */
public class DatabaseManager {

    private Integer openCnt = 0;
    private static DatabaseManager instance;
    private static SQLiteOpenHelper dbHelper;
    private static SQLiteDatabase database;

    public static synchronized void initializedInstance(SQLiteOpenHelper helper){
        if(instance == null)
        {
            instance = new DatabaseManager();
            dbHelper = helper;
        }
    }

    public static synchronized DatabaseManager getInstance()
    {
        if(instance == null)
        {
            throw new IllegalStateException(DatabaseManager.class.getSimpleName() + " is not initialized, call initializeInstance() method first");
        }
        return instance;
    }

    public synchronized SQLiteDatabase openDB(){
        openCnt += 1;

        if (openCnt == 1)
        {
            database = dbHelper.getWritableDatabase();
        }
        return database;
    }

    public synchronized void closeDB(){
        openCnt -= 1;

        if(openCnt ==0)
        {
            database.close();
        }
    }
}