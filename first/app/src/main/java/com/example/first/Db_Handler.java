package com.example.first;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.first.model.personModel;

import java.util.ArrayList;
import java.util.List;

public class Db_Handler extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    Context context;
    private static  final String DATABASE_NAME = "TODO_DATABASE";
    private static  final String TABLE_NAME = "PERSON";
    private static  final String COL_1 = "ID";
    private static  final String COL_2 = "NAME";
    private static  final String COL_3 = "CONTACT";
    private static  final String COL_4 = "EMAIL";
    private static  final String COL_5 = "PASSWORD";

    public Db_Handler(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT, CONTACT TEXT, EMAIL TEXT, PASSWORD TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public void insertPerson(@NonNull personModel model){

        db = super.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2 , model.getName());
        values.put(COL_3 , model.getContact());
        values.put(COL_4 , model.getEmail());
        values.put(COL_5 , model.getPassword());
        db.insert(TABLE_NAME , null , values);
        Toast.makeText(context, "Added", Toast.LENGTH_LONG).show();
    }
    public  boolean checkPerson(String TableName, String emailColumn, String email,String passwordColumn, String pass) {
        db=super.getReadableDatabase();
        String Query = "Select * from " + TableName + " where " + emailColumn + " = '" + email+"' AND "+ passwordColumn + " = '" + pass+"'";
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

}
