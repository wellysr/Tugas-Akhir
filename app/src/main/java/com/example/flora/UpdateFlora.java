package com.example.flora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateFlora extends AppCompatActivity {

    private MyDatabase db;
    private TextView Enama, Ekerajaan, Edivisi, Ekelas, Efamili, Ekarakteristik;
    private String Sid, Snama, Skerajaan, Sdivisi, Skelas, Sfamili, Skarakteristik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_flora);

        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid2");
        Snama = i.getStringExtra("Inama2");
        Skerajaan = i.getStringExtra("Ikerajaan2");
        Sdivisi = i.getStringExtra("Idivisi2");
        Skelas = i.getStringExtra("Ikelas2");
        Sfamili = i.getStringExtra("Ifamili2");
        Skarakteristik = i.getStringExtra("Ikarakteristik2");
        Enama = (TextView) findViewById(R.id.update_nama);
        Ekerajaan = (TextView) findViewById(R.id.update_kerajaan);
        Edivisi = (TextView) findViewById(R.id.update_divisi);
        Ekelas = (TextView) findViewById(R.id.update_kelas);
        Efamili = (TextView) findViewById(R.id.update_famili);
        Ekarakteristik = (TextView) findViewById(R.id.update_karakteristik);
        Enama.setText(Snama);
        Ekerajaan.setText(Skerajaan);
        Edivisi.setText(Sdivisi);
        Ekelas.setText(Skelas);
        Efamili.setText(Sfamili);
        Ekarakteristik.setText(Skarakteristik);
        Button btnUpdate = (Button) findViewById(R.id.btn_update_flora);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Skerajaan = String.valueOf(Ekerajaan.getText());
                Sdivisi = String.valueOf(Edivisi.getText());
                Skelas = String.valueOf(Ekelas.getText());
                Sfamili = String.valueOf(Efamili.getText());
                Skarakteristik = String.valueOf(Ekarakteristik.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(UpdateFlora.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Skerajaan.equals("")) {
                    Ekerajaan.requestFocus();
                    Toast.makeText(UpdateFlora.this, "Silahkan isi kerajaan",
                            Toast.LENGTH_SHORT).show();
                } else if (Sdivisi.equals("")){
                    Edivisi.requestFocus();
                    Toast.makeText(UpdateFlora.this, "Silahkan isi divisi",
                            Toast.LENGTH_SHORT).show();
                } else if (Skelas.equals("")){
                    Ekelas.requestFocus();
                    Toast.makeText(UpdateFlora.this, "Silahkan isi kelas",
                            Toast.LENGTH_SHORT).show();
                } else if (Sfamili.equals("")){
                    Efamili.requestFocus();
                    Toast.makeText(UpdateFlora.this, "Silahkan isi famili",
                            Toast.LENGTH_SHORT).show();
                } else if (Skarakteristik.equals("")){
                    Ekarakteristik.requestFocus();
                    Toast.makeText(UpdateFlora.this, "Silahkan isi karakteristik",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateFlora(new flora(Sid, Snama, Skerajaan, Sdivisi, Skelas, Sfamili, Skarakteristik));
                    Toast.makeText(UpdateFlora.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
//                    Intent a = new Intent(UpdateFlora.this, MainActivity.class);
//                    startActivity(a);
                    finish();
                }
            }
        });
    }
}
