package com.example.harddiskshowroom.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.Navigation;

import com.example.harddiskshowroom.Models.Disk;
import com.example.harddiskshowroom.Models.User;
import com.example.carshowroom.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DataBaseHelper extends SQLiteOpenHelper {

    @SuppressLint("SdCardPath")
    private static String DB_PATH;
    public static final String DB_NAME = "harddiskshowroom.db";
    private static final int DBNAME_VERSION = 1;

    public Context context;
    static SQLiteDatabase sqliteDataBase;

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DBNAME_VERSION);
        this.context = context;
        DB_PATH = context.getFilesDir().getPath() + DB_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
    }

    public void createDataBase() throws IOException {
        //check if the database exists
        boolean databaseExist = checkDataBase();

        if (databaseExist) {
            Log.d("db", "databaseExist=" + true);
            // Do Nothing.
        } else {
            Log.d("db", "databaseExist=" + false);
            this.getWritableDatabase();
            copyDataBase();
        }// end if else dbExist
    } // end createDataBase().

    public boolean checkDataBase() {
        File databaseFile = new File(DB_PATH);
        return databaseFile.exists();
    }

    private void copyDataBase() throws IOException {
        //Open your local db as the input stream
        InputStream myInput = context.getAssets().open(DB_NAME);
        // Path to the just created empty db
        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(DB_PATH);
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
        sqliteDataBase = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public synchronized void close() {
        if (sqliteDataBase != null)
            sqliteDataBase.close();
        super.close();
    }

    private static final String TABLE_USERS = "users";
    private static final String TABLE_USERS_COLUMN_PHONE = "phone";
    private static final String TABLE_USERS_COLUMN_ID = "_id";
    private static final String TABLE_USERS_COLUMN_USERNAME = "username";
    private static final String TABLE_USERS_COLUMN_EMAIL = "email";
    private static final String TABLE_USERS_COLUMN_PASSWORD = "password";

    private static final String TABLE_CARS = "cars";
    private static final String TABLE_CARS_COLUMN_VIN = "VIN";
    private static final String TABLE_CARS_COLUMN_BRAND = "brand";
    private static final String TABLE_CARS_COLUMN_MODEL = "model";
    private static final String TABLE_CARS_COLUMN_YEAR = "year";
    private static final String TABLE_CARS_COLUMN_PRICE = "price";
    private static final String TABLE_CARS_COLUMN_COLOR = "color";
    private static final String TABLE_CARS_COLUMN_TRANSMISSION = "transmission";
    private static final String TABLE_CARS_COLUMN_DRIVE_UNIT = "drive_unit";
    private static final String TABLE_CARS_COLUMN_MILEAGE = "mileage";
    private static final String TABLE_CARS_COLUMN_ENGINE = "engine";
    private static final String TABLE_CARS_COLUMN_BODY = "body";
    private static final String TABLE_CARS_COLUMN_CONDITION = "condition";
    private static final String TABLE_CARS_COLUMN_STEERING_WHEEL = "steering_wheel";
    private static final String TABLE_CARS_COLUMN_PHOTO = "photo";

    private static final String TABLE_FAVORITES = "favorites";
    private static final String TABLE_FAVORITES_COLUMN_VIN = "VIN";
    private static final String TABLE_FAVORITES_COLUMN_ID = "_id";

    private static final String TABLE_REVIEWS = "reviews";
    private static final String TABLE_REVIEWS_COLUMN_ID = "_id";
    private static final String TABLE_REVIEWS_COLUMN_REVIEW = "review";

    public void addToReviews(int userId, String review) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_REVIEWS_COLUMN_ID, userId);
        contentValues.put(TABLE_REVIEWS_COLUMN_REVIEW, review);
        sqliteDataBase.insert(TABLE_REVIEWS, null, contentValues);
    }

    public void addToFavorites(String VIN, int userId) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_FAVORITES_COLUMN_VIN, VIN);
        contentValues.put(TABLE_FAVORITES_COLUMN_ID, userId);
        sqliteDataBase.insert(TABLE_FAVORITES, null, contentValues);
    }

    public void deleteFromFavorites(String VIN, int userId) {
        sqliteDataBase.delete(TABLE_FAVORITES, "VIN = ? AND _id = ?", new String[]{VIN, String.valueOf(userId)});
    }

    @SuppressLint("Range")
    public ArrayList<Disk> getDiskAdsFromDatabase() {
        ArrayList<Disk> disks = new ArrayList<>();
        Cursor cursor = sqliteDataBase.query(TABLE_CARS, null, null, null,
                null, null, null);
        while (cursor.moveToNext()) {
            //Создание авто
            Disk disk = new Disk(cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_VIN)), cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_BRAND)),
                    cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_MODEL)), cursor.getInt(cursor.getColumnIndex(TABLE_CARS_COLUMN_YEAR)),
                    cursor.getInt(cursor.getColumnIndex(TABLE_CARS_COLUMN_PRICE)), cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_COLOR)),
                    cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_TRANSMISSION)), cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_DRIVE_UNIT)),
                    cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_MILEAGE)), cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_ENGINE)),
                    cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_BODY)), cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_CONDITION)),
                    cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_STEERING_WHEEL)), cursor.getString(cursor.getColumnIndex(TABLE_CARS_COLUMN_PHOTO)));
            disks.add(disk);
        }
        if (disks.isEmpty()) {
            Log.e("DB", "Error getting cars");
        } else {
            Log.d("DB", "Cars has been got");
        }
        cursor.close();
        return disks;
    }

    public User insertUser(String username, String email, String phone, String password) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TABLE_USERS_COLUMN_USERNAME, username);
        contentValues.put(TABLE_USERS_COLUMN_EMAIL, email);
        contentValues.put(TABLE_USERS_COLUMN_PHONE, phone);
        contentValues.put(TABLE_USERS_COLUMN_PASSWORD, password);
        long id = sqliteDataBase.insert(TABLE_USERS, null, contentValues);
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
            int id = cursor.getInt(cursor.getColumnIndex(TABLE_USERS_COLUMN_ID));
            String fullName = cursor.getString(cursor.getColumnIndex(TABLE_USERS_COLUMN_USERNAME));
            String email = cursor.getString(cursor.getColumnIndex(TABLE_USERS_COLUMN_EMAIL));
            String phone = cursor.getString(cursor.getColumnIndex(TABLE_USERS_COLUMN_PHONE));
            String password = cursor.getString(cursor.getColumnIndex(TABLE_USERS_COLUMN_PASSWORD));
            ArrayList<Disk> favorites = new ArrayList<>();
            Cursor favCursor = sqliteDataBase.query(TABLE_FAVORITES, null, "_id = ?", new String[]{String.valueOf(id)}, null, null, null);
            while (favCursor.moveToNext()) {
                String VIN = favCursor.getString(0);
                Cursor carCursor = sqliteDataBase.query(TABLE_CARS, null, " VIN = ?", new String[]{VIN},
                        null, null, null);
                while (carCursor.moveToNext()) {
                    //Создание авто
                    Disk disk = new Disk(carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_VIN)), carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_BRAND)),
                            carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_MODEL)), carCursor.getInt(carCursor.getColumnIndex(TABLE_CARS_COLUMN_YEAR)),
                            carCursor.getInt(carCursor.getColumnIndex(TABLE_CARS_COLUMN_PRICE)), carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_COLOR)),
                            carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_TRANSMISSION)), carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_DRIVE_UNIT)),
                            carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_MILEAGE)), carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_ENGINE)),
                            carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_BODY)), carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_CONDITION)),
                            carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_STEERING_WHEEL)), carCursor.getString(carCursor.getColumnIndex(TABLE_CARS_COLUMN_PHOTO)));
                    favorites.add(disk);
                }
                if (favorites.isEmpty()) {
                    Log.e("DB", "Error getting cars");
                } else {
                    Log.d("DB", "Cars has been got");
                }
                carCursor.close();
            }
            favCursor.close();
            // Создайте объект пользователя с полученными данными
            user = new User(id, fullName, email, phone, password, favorites);
        }

        cursor.close();
        return user;
    }

    @SuppressLint("Range")
    public ArrayList<User> getAllUsers() {
        Cursor cursor = sqliteDataBase.query(TABLE_USERS, null, null,
                null, null, null, null);
        ArrayList<User> users = new ArrayList<>();
        while (cursor.moveToNext()) {
            users.add(new User(cursor.getInt(cursor.getColumnIndex(TABLE_USERS_COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(TABLE_USERS_COLUMN_USERNAME)),
                    cursor.getString(cursor.getColumnIndex(TABLE_USERS_COLUMN_EMAIL)),
                    cursor.getString(cursor.getColumnIndex(TABLE_USERS_COLUMN_PHONE)),
                    cursor.getString(cursor.getColumnIndex(TABLE_USERS_COLUMN_PASSWORD))));
        }
        cursor.close();
        return users;
    }

}