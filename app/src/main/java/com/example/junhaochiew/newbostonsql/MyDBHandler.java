package com.example.junhaochiew.newbostonsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;

/**
 * Created by junhaochiew on 6/11/2015.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=3;
    private static final String DATABASE_NAME="location.db";
    public static final String TABLE_LOCATIONS="locations";

    public static final String COLUMN_ID="_id";
    public static final String COLUMN_LOCATIONNAME="locationname";
    public static final String COLUMN_LOCATIONCOORDINATES="locationcoordinates";
    public static final String COLUMN_LOCATIONDESCRIPTION="locationdescription";


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "CREATE TABLE " + TABLE_LOCATIONS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_LOCATIONNAME + " TEXT, " + COLUMN_LOCATIONCOORDINATES + " TEXT, " +
                COLUMN_LOCATIONDESCRIPTION + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
        onCreate(db);
    }

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public void addLocations(Locations location){
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_LOCATIONNAME,location.get_locationName());
        cv.put(COLUMN_LOCATIONCOORDINATES,location.get_locationCoordinates());
        cv.put(COLUMN_LOCATIONDESCRIPTION,location.get_locationDescription());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_LOCATIONS,null,cv);
        db.close();
    }

    public void deleteLocation(long id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(TABLE_LOCATIONS,COLUMN_ID + "=" + id, null);
    }

    public String databaseToString(){
        String dbString="";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM '" +TABLE_LOCATIONS + "' WHERE 1";

        Cursor c= db.rawQuery(query, null);

        c.moveToFirst();

        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex(COLUMN_LOCATIONNAME))!=null){
                dbString += c.getString(c.getColumnIndex(COLUMN_LOCATIONNAME)) + " ";
                dbString += c.getString(c.getColumnIndex(COLUMN_LOCATIONCOORDINATES)) + " ";
                dbString += c.getString(c.getColumnIndex(COLUMN_LOCATIONDESCRIPTION)) + " ";
                dbString += "\n";
            }
            c.moveToNext();
        }

        db.close();
        return dbString;
    }

    public String[] getLocationDetails(String name){
        String[] columns = new String[]{COLUMN_ID,COLUMN_LOCATIONNAME,COLUMN_LOCATIONCOORDINATES,COLUMN_LOCATIONDESCRIPTION};
        SQLiteDatabase db = getWritableDatabase();
        long i=1;
        Cursor c = db.query(TABLE_LOCATIONS, columns, COLUMN_LOCATIONNAME +" =?", new String[]{name},null,null,null);
        String[] s = new String[]{null,"location do not exist in database","location do not exist in database"};
        if(c!=null && !c.isAfterLast()){
            c.moveToFirst();
            s[0] = c.getString(0);
            s[1]=c.getString(2);
            s[2]=c.getString(3);
        }
        return s;
    }

    public void updateData(long id, String name, String coord, String desc){
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_LOCATIONNAME, name);
        cv.put(COLUMN_LOCATIONCOORDINATES, coord);
        cv.put(COLUMN_LOCATIONDESCRIPTION, desc);
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLE_LOCATIONS,cv,COLUMN_ID + "=" + id, null);

    }
}




















