package com.example.floradanfauna;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_project";
    private static final String tb_flora = "tb_flora";
    private static final String tb_flora_id = "id";
    private static final String tb_flora_nama = "nama";
    private static final String tb_flora_kerajaan = "kerajaan";
    private static final String tb_flora_divisi = "divisi";
    private static final String tb_flora_kelas = "kelas";
    private static final String tb_flora_famili = "famili";
    private static final String tb_flora_karakteristik = "karakteristik";
//    private static final String tb_flora_image = "gambar";
    private static final String CREATE_TABLE_FLORA = "CREATE TABLE " +
            tb_flora + "("
            + tb_flora_id + " INTEGER PRIMARY KEY ,"
            + tb_flora_nama + " TEXT,"
            + tb_flora_kerajaan + " TEXT,"
            + tb_flora_divisi + " TEXT,"
            + tb_flora_kelas + " TEXT,"
            + tb_flora_famili + " TEXT,"
            + tb_flora_karakteristik + " TEXT" + ")";

//    private static final String CREATE_TABLE_FLORA = "CREATE TABLE " +
//            tb_flora + "("
//            + tb_flora_id + " INTEGER PRIMARY KEY ,"
//            + tb_flora_nama + " TEXT,"
//            + tb_flora_kerajaan + " TEXT,"
//            + tb_flora_divisi + " TEXT,"
//            + tb_flora_kelas + " TEXT,"
//            + tb_flora_famili + " TEXT,"
//            + tb_flora_karakteristik + " TEXT,"
//            + tb_flora_image + " BLOB " + ")";

    public MyDatabase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_FLORA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreateFlora (flora mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_flora_id, mdNotif.get_id());
        values.put(tb_flora_nama, mdNotif.get_nama());
        values.put(tb_flora_kerajaan, mdNotif.get_kerajaan());
        values.put(tb_flora_divisi, mdNotif.get_divisi());
        values.put(tb_flora_kelas, mdNotif.get_kelas());
        values.put(tb_flora_famili, mdNotif.get_famili());
        values.put(tb_flora_karakteristik, mdNotif.get_karakteristik());
//        values.put(tb_flora_image, mdNotif.get_gambar());
        db.insert(tb_flora, null, values);
        db.close();
    }
    public List<flora> ReadMahasiswa() {
        List<flora> judulModelList = new ArrayList<flora>();
        String selectQuery = "SELECT * FROM " + tb_flora;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                flora mdKontak = new flora();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_kerajaan(cursor.getString(2));
                mdKontak.set_divisi(cursor.getString(3));
                mdKontak.set_kelas(cursor.getString(4));
                mdKontak.set_famili(cursor.getString(5));
                mdKontak.set_karakteristik(cursor.getString(6));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateMahasiswa (flora mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_flora_nama, mdNotif.get_nama());
        values.put(tb_flora_kerajaan, mdNotif.get_kerajaan());
        values.put(tb_flora_divisi, mdNotif.get_divisi());
        values.put(tb_flora_kelas, mdNotif.get_kelas());
        values.put(tb_flora_famili, mdNotif.get_famili());
        values.put(tb_flora_karakteristik, mdNotif.get_karakteristik());
        return db.update(tb_flora, values, tb_flora_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteMahasiswa (flora mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_flora, tb_flora_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
