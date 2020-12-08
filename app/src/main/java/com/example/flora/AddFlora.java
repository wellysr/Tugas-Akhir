package com.example.flora;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddFlora extends AppCompatActivity{
    private MyDatabase db;
    private EditText Enama, Ekerajaan, Edivisi, Ekelas, Efamili, Ekarakteristik;
    private String Snama, Skerajaan, Sdivisi, Skelas, Sfamili, Skarakteristik;

//    ImageView img1;
//    final int kodeGallery = 100;
//    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flora);

        db = new MyDatabase(this);
        Enama = findViewById(R.id.create_nama);
        Ekerajaan = findViewById(R.id.create_kerajaan);
        Edivisi = findViewById(R.id.create_divisi);
        Ekelas = findViewById(R.id.create_kelas);
        Efamili = findViewById(R.id.create_famili);
        Ekarakteristik = findViewById(R.id.create_karakteristik);
        Button btnCreate = findViewById(R.id.btn_flora);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snama = String.valueOf(Enama.getText());
                Skerajaan = String.valueOf(Ekerajaan.getText());
                Sdivisi = String.valueOf(Edivisi.getText());
                Skelas = String.valueOf(Ekelas.getText());
                Sfamili = String.valueOf(Efamili.getText());
                Skarakteristik = String.valueOf(Ekarakteristik.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(AddFlora.this, "Silahkan Isi Nama", Toast.LENGTH_SHORT).show();
                }else if (Skerajaan.equals("")){
                    Ekerajaan.requestFocus();
                    Toast.makeText(AddFlora.this, "Silahkan Isi Kearjaan", Toast.LENGTH_SHORT).show();
                }else if (Sdivisi.equals("")){
                    Edivisi.requestFocus();
                    Toast.makeText(AddFlora.this, "Silahkan Isi Divisi", Toast.LENGTH_SHORT).show();
                }else if (Skelas.equals("")){
                    Ekelas.requestFocus();
                    Toast.makeText(AddFlora.this, "Silahkan Isi Kelas", Toast.LENGTH_SHORT).show();
                }else if (Sfamili.equals("")){
                    Efamili.requestFocus();
                    Toast.makeText(AddFlora.this, "Silahkan Isi famili", Toast.LENGTH_SHORT).show();
                }else if (Skarakteristik.equals("")){
                    Ekarakteristik.requestFocus();
                    Toast.makeText(AddFlora.this, "Silahkan Isi Karakteristik", Toast.LENGTH_SHORT).show();
                }else {
                    Enama.setText("");
                    Ekerajaan.setText("");
                    Edivisi.setText("");
                    Ekelas.setText("");
                    Efamili.setText("");
                    Ekarakteristik.setText("");
                    Toast.makeText(AddFlora.this,"Data Telah Ditambah",Toast.LENGTH_SHORT).show();
                    db.CreateFlora(new flora(null, Snama, Skerajaan, Sdivisi, Skelas, Sfamili, Skarakteristik));
                    Intent a = new Intent(AddFlora.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });

//        img1 = findViewById(R.id.tampil);
//        Button upload = findViewById(R.id.up_gambar);
//        upload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(intentGallery,kodeGallery);
//            }
//        });

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == kodeGallery && resultCode == RESULT_OK){
//            imageUri = data.getData();
//            img1.setImageURI(imageUri);
//        }
//    }
}