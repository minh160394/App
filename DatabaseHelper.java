package finalproject.com.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by minh_ on 2017-08-07.
 */



public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String Tag= "DatabaseHelper";
    private static final String TABLE_NAME1= "registration";
    private static final String UserId= "userid";
    private static final String UserPass= "password";
    private static final String Email="emailTEXT";
    public DatabaseHelper (Context context) {
        super(context, TABLE_NAME1,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable ="CREATE TABLE " + TABLE_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + UserId + " TEXT, " + UserPass + " TEXT, " + Email + "  TEXT) ";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME1);
        onCreate(sqLiteDatabase);
    }
    public boolean Registration(String id, String pass, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(UserId, id);
        contentvalues.put(UserPass, pass);
        contentvalues.put(Email, email);
        long result= db.insert(TABLE_NAME1,null,contentvalues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME1,null);
        return data;

    }
    public  boolean validation(String id ){
        String selectQuery ="select * from " + TABLE_NAME1 + " where " + UserId + " = " + "'" + id + "'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0) {
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

    public  boolean signinvalidation(String id, String pass ){
        String selectQuery ="select * from " + TABLE_NAME1 + " where " + UserId + " = " + "'" + id + "'" + " AND " + UserPass + " = " + "'" + pass + "'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0) {
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

}
