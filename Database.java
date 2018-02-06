package finalproject.com.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Statement;

/**
 * Created by minh_ on 2017-08-09.
 */

public class Database extends SQLiteOpenHelper {

    private static final String NameManga= "manganame";
    private static final String TABLE_NAME2= "manga";
    private static final String MangaEp= "Eposides";

    public Database (Context context) {
        super(context, TABLE_NAME2,null,1);
        UpdateTable();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable1 ="CREATE TABLE " + TABLE_NAME2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + NameManga + " TEXT, " + MangaEp + " INT) ";

        db.execSQL(createTable1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME2);
        
        onCreate(sqLiteDatabase);
    }
    public void UpdateTable(){
        SQLiteDatabase db = getWritableDatabase();

        String attack = "INSERT INTO " + TABLE_NAME2 +"("+ NameManga+ "," + MangaEp+") " +" VALUES ('AttackOfTatian', 10)";
        String onepiece = "INSERT INTO " + TABLE_NAME2 +"("+ NameManga+ "," + MangaEp+") " +" VALUES ('OnePiece', 5)";
        String naruto = "INSERT INTO " + TABLE_NAME2 +"("+ NameManga+ "," + MangaEp+") " +" VALUES ('Naruto', 5)";
        String death = "INSERT INTO " + TABLE_NAME2 +"("+ NameManga+ "," + MangaEp+") " +" VALUES ('DeathNote', 3)";
        db.execSQL(attack);
        db.execSQL(onepiece);
        db.execSQL(naruto);
        db.execSQL(death);
    }
    public int findEpsiode(String name){
        int eposide =0;
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery ="SELECT " + MangaEp + " FROM " + TABLE_NAME2 + " WHERE " + NameManga + " = " + "'" + name + "'";
        Cursor cursor = getReadableDatabase().rawQuery(selectQuery,null);
        cursor.moveToFirst();
        eposide = cursor.getInt(0);
        return eposide;

    }

}
