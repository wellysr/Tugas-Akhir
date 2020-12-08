package com.example.flora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UpDelFlora extends AppCompatActivity {
    private MyDatabase db;
    private TextView Enama, Ekerajaan, Edivisi, Ekelas, Efamili, Ekarakteristik;
    private String Sid, Snama, Skerajaan, Sdivisi, Skelas, Sfamili, Skarakteristik;
    public String SEid, SEnama, SEkerajaan, SEdivisi, SEkelas, SEfamili, SEkarakteristik;
    public String S2id, S2nama, S2kerajaan, S2divisi, S2kelas, S2famili, S2karakteristik;
//    public List<flora> ListFlora = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_del_flora);

        db = new MyDatabase(this);
        Intent j = this.getIntent();
        Sid = j.getStringExtra("Iid");
        Snama = j.getStringExtra("Inama");
        Skerajaan = j.getStringExtra("Ikerajaan");
        Sdivisi = j.getStringExtra("Idivisi");
        Skelas = j.getStringExtra("Ikelas");
        Sfamili = j.getStringExtra("Ifamili");
        Skarakteristik = j.getStringExtra("Ikarakteristik");
        Enama = (TextView) findViewById(R.id.nama_flora);
        Ekerajaan = (TextView) findViewById(R.id.isi_kerajaan);
        Edivisi = (TextView) findViewById(R.id.isi_divisi);
        Ekelas = (TextView) findViewById(R.id.isi_kelas);
        Efamili = (TextView) findViewById(R.id.isi_famili);
        Ekarakteristik = (TextView) findViewById(R.id.isi_karakteristik);
        Enama.setText(Snama);
        Ekerajaan.setText(Skerajaan);
        Edivisi.setText(Sdivisi);
        Ekelas.setText(Skelas);
        Efamili.setText(Sfamili);
        Ekarakteristik.setText(Skarakteristik);
        ImageView btnDelete = (ImageView) findViewById(R.id.btn_delet_flora);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteFlora(new flora(Sid, Snama, Skerajaan, Sdivisi, Skelas, Sfamili, Skarakteristik));
                Toast.makeText(UpDelFlora.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        SEid = Sid;
        SEnama = String.valueOf(Enama.getText());
        SEkerajaan = String.valueOf(Ekerajaan.getText());
        SEdivisi = String.valueOf(Edivisi.getText());
        SEkelas = String.valueOf(Ekelas.getText());
        SEfamili = String.valueOf(Efamili.getText());
        SEkarakteristik = String.valueOf(Ekarakteristik.getText());
    }

    public void edit_flora (View view){
////        Object o = mListView.getItemAtPosition(i);
//        flora obj_itemDetails = (flora) o;
        String Sid = SEid;
        String Snama = SEnama;
        String Skerajaan = SEkerajaan;
        String Sdivisi = SEdivisi;
        String Skelas = SEkelas;
        String Sfamili = SEfamili;
        String Skarakteristik = SEkarakteristik;
        Intent goUpdel = new Intent(UpDelFlora.this, UpdateFlora.class);
        goUpdel.putExtra("Iid2", Sid);
        goUpdel.putExtra("Inama2", Snama);
        goUpdel.putExtra("Ikerajaan2", Skerajaan);
        goUpdel.putExtra("Idivisi2", Sdivisi);
        goUpdel.putExtra("Ikelas2", Skelas);
        goUpdel.putExtra("Ifamili2", Sfamili);
        goUpdel.putExtra("Ikarakteristik2", Skarakteristik);
        startActivity(goUpdel);
//        Intent a = new Intent(UpDelFlora.this, UpdateFlora.class);
//        startActivity(a);
    }

    @Override
    protected void onResume() {
        super.onResume();
        db = new MyDatabase(this);
        Intent j = this.getIntent();
        Sid = j.getStringExtra("Iid");
        Snama = j.getStringExtra("Inama");
        Skerajaan = j.getStringExtra("Ikerajaan");
        Sdivisi = j.getStringExtra("Idivisi");
        Skelas = j.getStringExtra("Ikelas");
        Sfamili = j.getStringExtra("Ifamili");
        Skarakteristik = j.getStringExtra("Ikarakteristik");
        Enama = (TextView) findViewById(R.id.nama_flora);
        Ekerajaan = (TextView) findViewById(R.id.isi_kerajaan);
        Edivisi = (TextView) findViewById(R.id.isi_divisi);
        Ekelas = (TextView) findViewById(R.id.isi_kelas);
        Efamili = (TextView) findViewById(R.id.isi_famili);
        Ekarakteristik = (TextView) findViewById(R.id.isi_karakteristik);
        Enama.setText(Snama);
        Ekerajaan.setText(Skerajaan);
        Edivisi.setText(Sdivisi);
        Ekelas.setText(Skelas);
        Efamili.setText(Sfamili);
        Ekarakteristik.setText(Skarakteristik);
    }
}
