package com.example.first;
import android.annotation.SuppressLint;
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
    private static  final String TABLE_PERSON = "PERSON";
    private static  final String COL_ID = "ID";
    private static  final String COL_NAME = "NAME";
    private static  final String COL_CONTACT = "CONTACT";
    private static  final String COL_EMAIL = "EMAIL";
    private static  final String COL_PASSWORD = "PASSWORD";
    //setting attributes of second table
    private static  final String TABLE_TASK = "TASKS";
    private static  final String COL_TASK_ID = "ID";
    private static  final String COL_PERSON_ID = "PERSON_ID";
    private static  final String COL_TITLE = "TITLE";
    private static  final String COL_DESCRIPTION = "DESCRIPTION";
    private static  final String COL_TIME = "TIME";
    private static  final String COL_STATUS = "STATUS";



    public Db_Handler(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_PERSON + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , NAME TEXT NOT NULL, CONTACT TEXT NOT NULL, EMAIL TEXT NOT NULL, PASSWORD TEXT NOT NULL )");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_TASK + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,PERSON_ID INTEGET NOT NULL  , TITLE TEXT NOT NULL, DESCRIPTION TEXT NOT NULL, TIME TEXT NOT NULL, STATUS INTEGER NOT NULL, FOREIGN KEY (PERSON_ID) REFERENCES PERSON(ID) \n" +
                "ON UPDATE CASCADE       ON DELETE CASCADE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        onCreate(db);

    }
    public void insertPerson(@NonNull personModel model){

        db = super.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME , model.getName());
        values.put(COL_CONTACT , model.getContact());
        values.put(COL_EMAIL , model.getEmail());
        values.put(COL_PASSWORD , model.getPassword());
        db.insert(TABLE_PERSON , null , values);
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
    @SuppressLint("Range")
    public  int getPersonId(String TableName, String emailColumn, String email, String passwordColumn, String pass) {
        db=super.getReadableDatabase();
        String Query = "Select * from " + TableName + " where " + emailColumn + " = '" + email+"' AND "+ passwordColumn + " = '" + pass+"'";
        Cursor cursor = db.rawQuery(Query, null);
        int id=-1;
        if(cursor.getCount() <= 0){
            cursor.close();
            return id;
        }
        cursor.moveToFirst();
        id = cursor.getInt(cursor.getColumnIndex("ID"));

        //Toast.makeText(context, id+"", Toast.LENGTH_LONG).show();
        cursor.close();
        return id;
    }

}
