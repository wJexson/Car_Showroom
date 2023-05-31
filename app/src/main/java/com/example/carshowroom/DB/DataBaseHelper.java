package com.example.carshowroom.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.Navigation;

import com.example.carshowroom.Data.Models.User;
import com.example.carshowroom.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class DataBaseHelper extends SQLiteOpenHelper {

    @SuppressLint("SdCardPath")
    private static final String DB_PATH = "/data/data/com.example.carshowroom/databases/";
    public static final String DBNAME = "carshowroom.db";
    private static final int DBNAME_VERSION = 1;

    public Context context;
    static SQLiteDatabase sqliteDataBase;

    public DataBaseHelper(Context context) {
        super(context, DBNAME, null, DBNAME_VERSION);
        this.context = context;
    }

    public void createDataBase() throws IOException {
        //check if the database exists
        boolean databaseExist = checkDataBase();

        if (databaseExist) {
            // Do Nothing.
        } else {
            this.getWritableDatabase();
            copyDataBase();
        }// end if else dbExist
    } // end createDataBase().

    public boolean checkDataBase() {
        String path = DB_PATH + DBNAME;
        File databaseFile = new File(DB_PATH + DBNAME);
        return databaseFile.exists();
    }

    private void copyDataBase() throws IOException {
        //Open your local db as the input stream
        InputStream myInput = context.getAssets().open(DBNAME);
        // Path to the just created empty db
        String outFileName = DB_PATH + DBNAME;
        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);
        //transfer bytes from the input file to the output file
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() throws SQLException {
        //Open the database
        String myPath = DB_PATH + DBNAME;
        sqliteDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public synchronized void close() {
        if (sqliteDataBase != null)
            sqliteDataBase.close();
        super.close();
    }

    private static final String TABLE_USER = "user";
    private static final String TABLE_USER_COLUMN_PHONE = "phone";
    private static final String TABLE_USER_COLUMN_ID = "_id";
    private static final String TABLE_USER_COLUMN_USERNAME = "username";
    private static final String TABLE_USER_COLUMN_EMAIL = "email";
    private static final String TABLE_USER_COLUMN_IMAGE = "image";

    @Override
    public void onCreate(SQLiteDatabase MyDB) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {

    }

    public User insertUser(String username, String email, String phone, String password) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        contentValues.put("password", password);
        contentValues.put("image", "userimage1");
        long id = sqliteDataBase.insert("users", null, contentValues);
        return new User((int) id, username, email, phone, password);
    }

    public boolean checkUserName(String username) {
        @SuppressLint("Recycle") Cursor cursor = sqliteDataBase.rawQuery("Select * from users where username = ?", new String[]{username});
        return cursor.getCount() > 0;
    }

    public boolean checkEmail(String email) {
        @SuppressLint("Recycle") Cursor cursor = sqliteDataBase.rawQuery("Select * from users where email = ?", new String[]{email});
        return cursor.getCount() > 0;
    }

    public boolean checkPhone(String phone) {
        @SuppressLint("Recycle") Cursor cursor = sqliteDataBase.rawQuery("Select * from users where phone = ?", new String[]{phone});
        return cursor.getCount() > 0;
    }

    public Boolean checkUserNamePassword(String username, String password) {
        @SuppressLint("Recycle") Cursor cursor = sqliteDataBase.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
        return cursor.getCount() > 0;
    }

    public void signUp(String userName, String mail, String phone, String pass, View view) {
        if (userName.equals("") || mail.equals("") || phone.equals("") || pass.equals("")) {
            Toast.makeText(context, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
        } else if (Pattern.matches(User.EMAIL_PATTERN, mail)) {
            Toast.makeText(context, "Некорректные данные почты", Toast.LENGTH_SHORT).show();
        } else if (Pattern.matches(User.PHONE_PATTERN, phone)) {
            Toast.makeText(context, "Некорректные данные номера телефона", Toast.LENGTH_SHORT).show();
        } else {
            boolean checkUser = checkUserName(userName);
            boolean checkEmail = checkEmail(mail);
            boolean checkPhone = checkPhone(phone);
            if (!checkUser & !checkEmail & !checkPhone) {
                User user = insertUser(userName, mail, phone, pass);
                if (user != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(User.SELECTED_USER, user);
                    Toast.makeText(context, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_mainFragment, bundle);
                } else {
                    Toast.makeText(context, "Регистрация не удалась", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "Пользователь c такими данными уже существует. Пожалуйста войдите", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void signIn(String userName, String pass, View view) {
        if (userName.equals("") || pass.equals(""))
            Toast.makeText(context, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
        else {
            Boolean checkuserpass = checkUserNamePassword(userName, pass);
            if (checkuserpass) {
                User user = getUserByName(userName);
                Bundle bundle = new Bundle();
                bundle.putParcelable(User.SELECTED_USER, user);
                Toast.makeText(context, "Вход успешен", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_mainFragment, bundle);
            } else {
                Toast.makeText(context, "Недействительные учетные данные", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("Range")
    public User getUserByName(String username) {
        Cursor cursor = sqliteDataBase.rawQuery("SELECT * FROM users WHERE username = ?", new String[]{String.valueOf(username)});

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
