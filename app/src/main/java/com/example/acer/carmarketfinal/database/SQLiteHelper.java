package com.example.acer.carmarketfinal.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.acer.carmarketfinal.beans.Perdoruesi;
import com.example.acer.carmarketfinal.beans.Vetura;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context) {
        super(context, "carMarketDB.sqlite", null, 1);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }


    public void insertVetura(Vetura vetura){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO VETURA VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, vetura.getTitulli());
        statement.bindString(2, vetura.getViti());
        statement.bindString(3, vetura.getKilometrazha());
        statement.bindString(4, vetura.getTransmetuesi());
        statement.bindString(5, vetura.getKarburanti());
        statement.bindString(6, vetura.getNgjyra());
        statement.bindString(7, vetura.getStruktura());
        statement.bindString(8, vetura.getKomuna());
        statement.bindString(9, vetura.getTel());
        statement.bindString(10, vetura.getPershkrimi());
        statement.bindString(11, vetura.getLloji());
        statement.bindBlob(12, vetura.getFoto());
        statement.bindString(13,vetura.getEmail());
        statement.executeInsert();

    }

    public void insertPerdorues(Perdoruesi perdoruesi){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO PERDORUESI VALUES (null, ?, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,perdoruesi.getEmail());
        statement.bindString(2,perdoruesi.getUsername());
        statement.bindString(3,perdoruesi.getPassword());

        statement.executeInsert();
    }

    public void insertPerdorues(String username, String email, String password){
        SQLiteDatabase database = getWritableDatabase();

        String sql = "INSERT INTO PERDORUESI VALUES (null, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,username);
        statement.bindString(2,email);
        statement.bindString(3,password);

        statement.executeInsert();

        database.close();
    }

    public String getSinglePerdorues(String email) {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("PERDORUESI", null, " email=?", new String[]{email}, null, null, null);
        if (cursor.getCount() < 1) // email Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("password"));
        cursor.close();
        return password;
    }



    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    public void updateData(Vetura vetura,int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "UPDATE VETURA SET " +
                VETURA_TITULLI + "=?," +
                VETURA_VITI + "=?," +
                VETURA_KILOMETRAZHA + "=?," +
                VETURA_TRANSMETUESI + "=?," +
                VETURA_KARBURANTI + "=?," +
                VETURA_NGJYRA+ "=?," +
                VETURA_STRUKTURA + "=?," +
                VETURA_KOMUNA + "=?," +
                VETURA_KONTAKTI + "=?," +
                VETURA_PERSHKRIMI + "=?," +
                VETURA_LLOJI + "=?," +
                VETURA_FOTO + "=?" +
                " where id=?";

        SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);
        statement.bindString(1, vetura.getTitulli());
        statement.bindString(2, vetura.getViti());
        statement.bindString(3, vetura.getKilometrazha());
        statement.bindString(4, vetura.getTransmetuesi());
        statement.bindString(5, vetura.getKarburanti());
        statement.bindString(6, vetura.getNgjyra());
        statement.bindString(7, vetura.getStruktura());
        statement.bindString(8, vetura.getKomuna());
        statement.bindString(9, vetura.getTel());
        statement.bindString(10, vetura.getPershkrimi());
        statement.bindString(11, vetura.getLloji());
        statement.bindBlob(12, vetura.getFoto());
        statement.bindDouble(13,id);

        statement.execute();
        sqLiteDatabase.close();
    }
    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM VETURA WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static final String ID ="id";
    public static final String TABLE_VETURA = "VETURA";
    public static final String  VETURA_TITULLI = "titulli";
    public static final String  VETURA_VITI = "viti";
    public static final String  VETURA_KILOMETRAZHA = "kilometrazha";
    public static final String  VETURA_TRANSMETUESI = "transmetuesi";
    public static final String  VETURA_KARBURANTI = "karburanti";
    public static final String  VETURA_NGJYRA = "ngjyra";
    public static final String  VETURA_STRUKTURA = "struktura";
    public static final String  VETURA_KOMUNA = "komuna";
    public static final String  VETURA_KONTAKTI = "kontakti";
    public static final String  VETURA_PERSHKRIMI = "pershkrimi";
    public static final String  VETURA_LLOJI = "lloji";
    public static final String  VETURA_FOTO = "foto";
    public static final String  PERDORUESI_EMAIL= "email";

    public static final String CREATE_TABLE_VETURA = "CREATE TABLE IF NOT EXISTS "
            + TABLE_VETURA
            + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VETURA_TITULLI + " VARCHAR,"
            + VETURA_VITI + " VARCHAR,"
            + VETURA_KILOMETRAZHA + " VARCHAR,"
            + VETURA_TRANSMETUESI + " VARCHAR,"
            + VETURA_KARBURANTI + " VARCHAR,"
            + VETURA_NGJYRA + " VARCHAR,"
            + VETURA_STRUKTURA + " VARCHAR,"
            + VETURA_KOMUNA + " VARCHAR,"
            + VETURA_KONTAKTI + " VARCHAR,"
            + VETURA_PERSHKRIMI + " VARCHAR,"
            + VETURA_LLOJI + " VARCHAR,"
            + VETURA_FOTO + " BLOB,"
            + PERDORUESI_EMAIL + " DATETIME"
            + ")";
}
