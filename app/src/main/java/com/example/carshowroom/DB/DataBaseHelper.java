package com.example.carshowroom.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.carshowroom.Data.Models.User;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String DBNAME = "carshowroom.db";
    private static final int DBNAME_VERSION = 1;

    public Context context;

    public DataBaseHelper(Context context) {
        super(context, DBNAME, null, DBNAME_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(_id INTEGER primary key, username TEXT, email TEXT, phone TEXT, password TEXT)");
//        MyDB.execSQL("create Table cars(VIN TEXT primary key, brand TEXT, model TEXT, year TEXT, price TEXT, color TEXT, transmission TEXT, drive_unit TEXT, " +
//                "mileage TEXT, engine TEXT, body TEXT, condition TEXT, steering_wheel TEXT, photo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
        //MyDB.execSQL("drop Table if exists cars");
        onCreate(MyDB);
    }

    public User insertData(String username, String email, String phone, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        contentValues.put("password", password);
        long id = MyDB.insert("users", null, contentValues);
        return new User((int) id, username, email, phone, password);
    }

    public boolean checkUserName(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        return cursor.getCount() > 0;
    }

    public boolean checkEmail(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select * from users where email = ?", new String[]{email});
        return cursor.getCount() > 0;
    }

    public boolean checkPhone(String phone) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select * from users where phone = ?", new String[]{phone});
        return cursor.getCount() > 0;
    }

    public Boolean checkUserNamePassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
        return cursor.getCount() > 0;
    }

    @SuppressLint("Range")
    public User getUserById(int userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE _id = ?", new String[]{String.valueOf(userId)});

        User user = null;
        if (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String fullName = cursor.getString(cursor.getColumnIndex("username"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            // Создайте объект пользователя с полученными данными
            user = new User(id, fullName, email, phone, password);
        }

        cursor.close();
        return user;
    }

    @SuppressLint("Range")
    public User getUserByName(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ?", new String[]{String.valueOf(username)});

        User user = null;
        if (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String fullName = cursor.getString(cursor.getColumnIndex("username"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            // Создайте объект пользователя с полученными данными
            user = new User(id, fullName, email, phone, password);
        }

        cursor.close();
        return user;
    }
}
