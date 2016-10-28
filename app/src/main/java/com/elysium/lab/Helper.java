package com.elysium.lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jay on 10/28/16.
 */

public class Helper extends SQLiteOpenHelper {

    // employees

    public static final String EMPLOYEE_TABLE = "employee";
    public static final String COL_ID = "ssn";
    public static final String COL_FIRST = "first_name";
    public static final String COL_LAST = "last_name";
    public static final String COL_DOB = "year_born";
    public static final String COL_CITY = "city";

    // companies

    public static final String COMPANY_TABLE = "company";
    public static final String COL_SSN = "employee_ssn";
    public static final String COL_NAME = "company_name";
    public static final String COL_SALARY = "salary";
    public static final String COL_TENURE = "tenure";

    //constructor

    private Helper(Context context) {
        super(context, "db", null, 0);
    }

    private static Helper Instance;

    public static synchronized Helper getInstance(Context context) {

        if (Instance == null)
            Instance = new Helper(context.getApplicationContext());
        return Instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES_EMPLOYEE);
        db.execSQL(SQL_CREATE_ENTRIES_COMPANY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_ENTRIES_EMPLOYEE);
        db.execSQL(SQL_DELETE_ENTRIES_COMPANY);
        onCreate(db);
    }

    private static final String SQL_CREATE_ENTRIES_EMPLOYEE =

            "CREATE TABLE" +
                    EMPLOYEE_TABLE + " (" +
                    COL_ID + "INTEGER PRIMARY KEY," +
                    COL_FIRST + "TEXT," +
                    COL_LAST + "TEXT," +
                    COL_DOB + "TEXT" +
                    COL_CITY + "TEXT" + ")";

    private static final String SQL_CREATE_ENTRIES_COMPANY =

            "CREATE COMPANY TABLE" +
                    COMPANY_TABLE + " (" +
                    COL_SSN + " INTEGER FOREIGN KEY," +
                    COL_NAME + " TEXT," +
                    COL_SALARY + " TEXT," +
                    COL_TENURE + " TEXT" + ")";

    private static final String SQL_DELETE_ENTRIES_EMPLOYEE = "DROP TABLE IF EXISTS " +
            EMPLOYEE_TABLE;

    private static final String SQL_DELETE_ENTRIES_COMPANY = "DROP TABLE IF EXISTS " +
            COMPANY_TABLE;

    public void insertRow(Employee employee) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put()

    }
}
