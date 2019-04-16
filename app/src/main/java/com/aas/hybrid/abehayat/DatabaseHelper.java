package com.aas.hybrid.abehayat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.zip.CheckedOutputStream;

/**
 * Created by Mansoor ul Islam on 3/12/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "customer_db";
    public static final int DATABASE_VERSION = 23;


    public static final String CREATE_TABLE = "CREATE TABLE " + customerInformation.custm.TABLE_NAME +
            "(" + customerInformation.custm.CUSTOMER_ID + " NUMERIC PRIMARY KEY, " + customerInformation.custm.CUSTOMER_NAME + " TEXT, " + customerInformation.custm.CUSTOMER_PHONE + " TEXT, " + customerInformation.custm.CUSTOMER_ADDRESS + " TEXT, " + customerInformation.custm.CUSTOMER_EMAIL + " TEXT, "
            + customerInformation.custm.CUSTOMER_PASSWORD + " TEXT, " + customerInformation.custm.CORDER_NO + " INTEGER, " + customerInformation.custm.CRECEIPT_NO + " INTEGER, " + " FOREIGN KEY ("+customerInformation.custm.CRECEIPT_NO+") REFERENCES "+ReceiptNote.recpt.tablname+" ("+ReceiptNote.recpt.recpNo+") , FOREIGN KEY ("+customerInformation.custm.CORDER_NO+") REFERENCES "+OrderClass.ord.tablename+" ("+OrderClass.ord.ordNo+"));";

    public static final String CrEATe_TABLE = "CREATE TABLE " + OrderClass.ord.tablename +
            "(" + OrderClass.ord.ordNo + " NUMERIC PRIMARY KEY, " + OrderClass.ord.CusmID + " NUMERIC, " + OrderClass.ord.ordSt + " TEXT, " + OrderClass.ord.OrdDate + " DATE, "
            + OrderClass.ord.ordDelDate + " DATE, " + OrderClass.ord.ordQuan + " INTEGER, "
            + OrderClass.ord.BotlSize + " TEXT, " + " FOREIGN KEY ("+OrderClass.ord.CusmID+") REFERENCES "+customerInformation.custm.TABLE_NAME+" ("+customerInformation.custm.CUSTOMER_ID+"));";

   public static final String CREATe_TABLE = "CREATE TABLE " + employee.emplo.taBlename +
            "(" + employee.emplo.empID + " NUMERIC PRIMARY KEY, " + employee.emplo.empname + " TEXT, " + employee.emplo.contactNo + " TEXT, "
            + employee.emplo.ads + " TEXT, " + employee.emplo.age + " NUMERIC, "
            + employee.emplo.salary + " NUMERIC " + ");";

    public static final String CREAte_TABLE = "CREATE TABLE " + complaint.comp.tableName +
            "(" + complaint.comp.CusMID + " NUMERIC, " + complaint.comp.ComplaintNo + " INTEGER, " + complaint.comp.Compl + " TEXT, "
            + complaint.comp.Compstatus + " TEXT, " + complaint.comp.orderNo + " INTEGER, "
            + complaint.comp.OrderDate + " DATE,  " + complaint.comp.orderSt + " TEXT " + ");";


    public static final String CREaTe_TABLE = "CREATE TABLE " + ReceiptNote.recpt.tablname +
            "(" + ReceiptNote.recpt.recpNo + " NUMERIC PRIMARY KEY, " + ReceiptNote.recpt.CustmId + " NUMERIC, "
            + ReceiptNote.recpt.orNo + " NUMERIC, " + " FOREIGN KEY ("+ReceiptNote.recpt.CustmId+") REFERENCES "+customerInformation.custm.TABLE_NAME+" ("+customerInformation.custm.CUSTOMER_ID+") , FOREIGN KEY ("+ReceiptNote.recpt.orNo+") REFERENCES "+OrderClass.ord.tablename+" ("+OrderClass.ord.ordNo+"));";


    public static final String CrEaTe_TABLE = "CREATE TABLE " + Company.company.TaBLE_NAME +
            "(" + Company.company.compNAme + " NUMERIC PRIMARY KEY, " + Company.company.Company_contact + " TEXT, "
            + Company.company.Company_loc + " TEXT " + ");";

    public static final String DROP_TABLE = "DROP TABLE IF EXITSTS" + customerInformation.custm.TABLE_NAME;
    public static final String DROP_tABLE = "DROP TABLE IF EXITSTS" + OrderClass.ord.tablename;
    public static final String DRoP_tABLE = "DROP TABLE IF EXITSTS" + employee.emplo.taBlename;
    public static final String DroP_tABLE = "DROP TABLE IF EXITSTS" + complaint.comp.tableName;
    public static final String DroP_tABlE = "DROP TABLE IF EXITSTS" + ReceiptNote.recpt.tablname;
    public static final String Drop_tABlE = "DROP TABLE IF EXITSTS" + Company.company.TaBLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operations", "Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CrEATe_TABLE);
       db.execSQL(CREATe_TABLE);

       db.execSQL(CREAte_TABLE);
       db.execSQL(CREaTe_TABLE);
       db.execSQL(CrEaTe_TABLE);
        Log.d("Database Operations", "TABLE Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
      db.execSQL(DROP_tABLE);
        db.execSQL(DRoP_tABLE);
        db.execSQL(DroP_tABLE);
        db.execSQL(DroP_tABlE);
        db.execSQL(Drop_tABlE);
        Log.d("Database Operations", "Table Dropped");
        onCreate(db);
        onCreate(db);
        onCreate(db);
        onCreate(db);
        onCreate(db);

    }

    public void addcustomer(String id, String nam, String phone, String address, String email, String password, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(customerInformation.custm.CUSTOMER_ID,id);
        contentValues.put(customerInformation.custm.CUSTOMER_NAME, nam);
        contentValues.put(customerInformation.custm.CUSTOMER_PHONE, phone);
        contentValues.put(customerInformation.custm.CUSTOMER_ADDRESS, address);
        contentValues.put(customerInformation.custm.CUSTOMER_EMAIL, email);
        contentValues.put(customerInformation.custm.CUSTOMER_PASSWORD, password);
        /*contentValues.put(Customers.customer.CORDER_NO,ordno);
        contentValues.put(Customers.customer.CRECEIPT_NO,recno);
        + customerInformation.custm.CORDER_NO + " INTEGER " +
            customerInformation.custm.CRECEIPT_NO + " INTEGER "*/

        database.insert(customerInformation.custm.TABLE_NAME , null, contentValues);
        Log.d("Database Operations", "One Row Inserted");
    }

    public Cursor readcusmInfo(SQLiteDatabase database) {
        String[] data = {customerInformation.custm.CUSTOMER_ID, customerInformation.custm.CUSTOMER_NAME,
                customerInformation.custm.CUSTOMER_PHONE, customerInformation.custm.CUSTOMER_ADDRESS,
                customerInformation.custm.CUSTOMER_EMAIL, customerInformation.custm.CUSTOMER_PASSWORD};
     Cursor cursor= database.query(customerInformation.custm.TABLE_NAME,data, null, null, null, null,null);

     return cursor;

    }

    public void placeOder(Integer quant,String Sze,SQLiteDatabase database){
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(OrderClass.ord.ordQuan,quant);
         contentvalues.put(OrderClass.ord.BotlSize,Sze);

        database.insert(OrderClass.ord.tablename , null, contentvalues);
        Log.d("Database Operations", "Order Inserted");
    }


}


