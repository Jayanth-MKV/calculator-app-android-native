package com.jay.mynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    Context ct;
    private static final String Database_Name ="MYNOTES";
    private static final int Database_Version =1;
    private static final String Table_Name ="MyNotes";
    private static final String Col_1 ="Id";
    private static final String Col_2 ="Title";
    private static final String Col_3 ="Description";

    public Database(@Nullable Context context) {
        super(context, Database_Name, null, Database_Version);
        this.ct=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query=
                "CREATE TABLE " + Table_Name + " (" +
                        Col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        Col_2 + " TEXT," +
                        Col_3 + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }

    void addNotes(String title,String desc){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(Col_2,title);
        cv.put(Col_3,desc);
        Long result=db.insert(Table_Name,null,cv);

        if(result==-1){
            Toast.makeText(ct, "The Values are not Stored", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(ct, "Successfully inserted values", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query= "select * from "+ Table_Name;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=null;
        if (db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;

    }

    void removeData(){

    }

    void updateNotes(String title, String desc, String id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(Col_2,title);
        cv.put(Col_3,desc);
        int result = db.update(Table_Name,cv,"Title=?",new String[]{title});
//        Log.e("result", String.valueOf(result));

        if(result==-1){
            Toast.makeText(ct, "The Values are not Updated", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(ct, "Successfully Updated values", Toast.LENGTH_SHORT).show();
        }
    }

    public void delsingleitem(String id) {
        SQLiteDatabase db=this.getWritableDatabase();

        int res=db.delete(Table_Name,"Id=?",new String[]{id});

        if(res==-1){
            Toast.makeText(ct,"Item not Deleted",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ct,"Item Deleted Successfully",Toast.LENGTH_LONG).show();

        }
    }
}
