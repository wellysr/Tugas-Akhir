package com.example.floradanfauna;

import android.net.Uri;

public class flora {
    private String _id, _nama, _kerajaan, _divisi, _kelas, _famili, _karakteristik;
//    private Uri _gambar;
    public flora (String id, String nama, String kerajaan, String divisi, String kelas, String famili, String karakteristik) {
        this._id = id;
        this._nama = nama;
        this._kerajaan = kerajaan;
        this._divisi = divisi;
        this._kelas = kelas;
        this._famili = famili;
        this._karakteristik = karakteristik;
//        this._gambar = gambar;
    }

    public flora() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nama() {
        return _nama;
    }

    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public String get_kerajaan() {
        return _kerajaan;
    }

    public void set_kerajaan(String _kerajaan) {
        this._kerajaan = _kerajaan;
    }

    public String get_divisi() {
        return _divisi;
    }

    public void set_divisi(String _divisi) {
        this._divisi = _divisi;
    }

    public String get_kelas() {
        return _kelas;
    }

    public void set_kelas(String _kelas) {
        this._kelas = _kelas;
    }

    public String get_famili() {
        return _famili;
    }

    public void set_famili(String _famili) {
        this._famili = _famili;
    }

    public String get_karakteristik() {
        return _karakteristik;
    }

    public void set_karakteristik(String _karakteristik) {
        this._karakteristik = _karakteristik;
    }

//    public Uri get_gambar() {
//        return _gambar;
//    }
//
//    public void set_gambar(Uri _gambar) {
//        this._gambar = _gambar;
//    }
}
