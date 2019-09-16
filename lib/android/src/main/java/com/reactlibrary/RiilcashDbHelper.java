package com.reactlibrary;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.reactlibrary.RiilcasContract;

public class RiilcashDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RiilcashReader.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + RiilcasContract.Riilcash.TABLE_NAME + " (" +
                    RiilcasContract.Riilcash._ID + " INTEGER PRIMARY KEY," +
                    RiilcasContract.Riilcash.COLUMN_NAME_AMOUNT + " REAL," +
                    RiilcasContract.Riilcash.COLUMN_NAME_DEST_ACCOUNT_ID + " TEXT," +
                    RiilcasContract.Riilcash.COLUMN_NAME_METHOD + " REAL," +
                    RiilcasContract.Riilcash.COLUMN_NAME_SOURCE_ACCOUNT_PUB + " TEXT," +
                    RiilcasContract.Riilcash.COLUMN_NAME_UNIQUE_CODE + " TEXT," +
                    RiilcasContract.Riilcash.COLUMN_NAME_CURRENCY + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + RiilcasContract.Riilcash.TABLE_NAME;

    public RiilcashDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}