package com.example.android_test27_april_2021;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class db extends SQLiteOpenHelper {

    static final String tb_1 = "ratings";
    static final String tb_1_col_1 = "id";
    static final String tb_1_col_2 = "rating";

    public db(@Nullable Context context) {
        super(context, "db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tb_1+" ("+tb_1_col_1+" integer primary key autoincrement, "+tb_1_col_2+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert_ratings(String rating) {
        ContentValues con = new ContentValues();
        con.put(tb_1_col_2, rating);

        SQLiteDatabase s = this.getWritableDatabase();
        long v = s.insert(tb_1, null, con);

        if (v == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
