package com.example.android.diptea;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AddSignupData {
    public static final String KEY_ROWID="_id";
    public static final String KEY_EMAIL="_email";
    public static final String KEY_PWD="_pwd";

    private static final String db_Name="DipTea_db";
    private static final String db_Table="Signup_Table";
    private static final int db_Version=1;

    private static DbHelper ourHelper;
    private static Context ourContext;
    private static SQLiteDatabase ourDatabase;

    public AddSignupData(Context c) {
        super();
        ourContext=c;
    }

    public long createEntry(String email, String password) {
        ContentValues cv=new ContentValues();
        cv.put(KEY_EMAIL,email);
        cv.put(KEY_PWD,password);
        return ourDatabase.insert(db_Table,null,cv);

    }

    private static class DbHelper extends SQLiteOpenHelper {

        public DbHelper(Context context) {
            super(context, db_Name, null, db_Version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(
                    "CREATE TABLE" + db_Table + "(" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_EMAIL + " TEXT NOT NULL, " +
                            KEY_PWD + " PASSWORD NOT NULL);"

            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + db_Table);
            onCreate(db);
        }

    }

        public AddSignupData open(){
            ourHelper=new DbHelper(ourContext);
            ourDatabase=ourHelper.getWritableDatabase();
            return this;
        }

        public void close(){
            ourHelper.close();
        }

}
