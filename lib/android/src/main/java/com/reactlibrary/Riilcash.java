package com.reactlibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import com.reactlibrary.RiilcashDbHelper;
import com.reactlibrary.RiilcasContract;


public class Riilcash {

    private Double amount;
    private String currency;
    private String dest_account_id;
    private String unique_code;
    private String source_account_pub;
    private Double method;

    private RiilcashDbHelper dbHelper;

    public Riilcash() {
    }

    public Riilcash(Double amount, String currency, String dest_account_id, Double method, String unique_code, String source_account_pub) {
        this.amount = amount;
        this.currency = currency;
        this.dest_account_id = dest_account_id;
        this.unique_code = unique_code;
        this.source_account_pub = source_account_pub;
        this.method = method;
    }

    public long insert(Context context) {
        dbHelper = new RiilcashDbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RiilcasContract.Riilcash.COLUMN_NAME_AMOUNT, this.amount);
        values.put(RiilcasContract.Riilcash.COLUMN_NAME_CURRENCY, this.currency);
        values.put(RiilcasContract.Riilcash.COLUMN_NAME_DEST_ACCOUNT_ID, this.dest_account_id);
        values.put(RiilcasContract.Riilcash.COLUMN_NAME_UNIQUE_CODE, this.unique_code);
        values.put(RiilcasContract.Riilcash.COLUMN_NAME_METHOD, this.method);
        values.put(RiilcasContract.Riilcash.COLUMN_NAME_SOURCE_ACCOUNT_PUB, this.source_account_pub);
        return db.insert(RiilcasContract.Riilcash.TABLE_NAME, null, values);
    }

    public String getAll(Context context) throws JSONException {
        dbHelper = new RiilcashDbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                RiilcasContract.Riilcash.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        List<JSONObject> itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(RiilcasContract.Riilcash.COLUMN_NAME_AMOUNT,cursor.getDouble(cursor.getColumnIndex(RiilcasContract.Riilcash.COLUMN_NAME_AMOUNT)));
            jsonObject.put(RiilcasContract.Riilcash.COLUMN_NAME_CURRENCY,cursor.getString(cursor.getColumnIndex(RiilcasContract.Riilcash.COLUMN_NAME_CURRENCY)));
            jsonObject.put(RiilcasContract.Riilcash.COLUMN_NAME_DEST_ACCOUNT_ID,cursor.getString(cursor.getColumnIndex(RiilcasContract.Riilcash.COLUMN_NAME_DEST_ACCOUNT_ID)));
            jsonObject.put(RiilcasContract.Riilcash.COLUMN_NAME_METHOD,cursor.getDouble(cursor.getColumnIndex(RiilcasContract.Riilcash.COLUMN_NAME_METHOD)));
            jsonObject.put(RiilcasContract.Riilcash.COLUMN_NAME_UNIQUE_CODE,cursor.getString(cursor.getColumnIndex(RiilcasContract.Riilcash.COLUMN_NAME_UNIQUE_CODE)));
            jsonObject.put(RiilcasContract.Riilcash.COLUMN_NAME_SOURCE_ACCOUNT_PUB,cursor.getString(cursor.getColumnIndex(RiilcasContract.Riilcash.COLUMN_NAME_SOURCE_ACCOUNT_PUB)));

            itemIds.add(jsonObject);
        }
        cursor.close();
        return String.valueOf(itemIds);
    }

    public int delete(Context context, int id){
        dbHelper = new RiilcashDbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selection = RiilcasContract.Riilcash._ID + " = "+id;
        int deletedRows = db.delete(RiilcasContract.Riilcash.TABLE_NAME, selection, null);
        return  deletedRows;
    }


}
