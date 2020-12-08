package com.example.flora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<flora> ListFlora = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListFlora );
        mListView = (ListView) findViewById(R.id.list_mahasiswa);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListFlora.clear();
        List<flora> contacts = db.ReadFlora();
        for (flora cn : contacts) {
            flora judulModel = new flora();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_kelas(cn.get_kelas());
            judulModel.set_kerajaan(cn.get_kerajaan());
            judulModel.set_divisi(cn.get_divisi());
            judulModel.set_famili(cn.get_famili());
            judulModel.set_karakteristik(cn.get_karakteristik());
            ListFlora.add(judulModel);
            if ((ListFlora.isEmpty()))
                Toast.makeText(MainActivity.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }



        BottomNavigationView bottomNav = findViewById(R.id.menu);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            Fragment selectetdFragment = null;

            switch (menuItem.getItemId()){
                case R.id.menu_flora:
                    Intent b = new Intent(MainActivity.this, DataFlora.class);
                    startActivity(b);
                    break;
                case R.id.menu_add:
                    Intent a = new Intent(MainActivity.this, AddFlora.class);
                    startActivity(a);
                    break;
                case R.id.menu_about:
                    Intent c = new Intent(MainActivity.this, About.class);
                    startActivity(c);
                    break;
            }

            return true;
        }
    };

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==R.id.menu_about){
            startActivity(new Intent(this, About.class));
        }

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        flora obj_itemDetails = (flora) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Skerajaan = obj_itemDetails.get_kerajaan();
        String Sdivisi = obj_itemDetails.get_divisi();
        String Skelas = obj_itemDetails.get_kelas();
        String Sfamili = obj_itemDetails.get_famili();
        String Skarakteristik = obj_itemDetails.get_karakteristik();
        Intent goUpdel = new Intent(MainActivity.this, UpDelFlora.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ikerajaan", Skerajaan);
        goUpdel.putExtra("Idivisi", Sdivisi);
        goUpdel.putExtra("Ikelas", Skelas);
        goUpdel.putExtra("Ifamili", Sfamili);
        goUpdel.putExtra("Ikarakteristik", Skarakteristik);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListFlora.clear();
        mListView.setAdapter(adapter_off);
        List<flora> contacts = db.ReadFlora();
        for (flora cn : contacts) {
            flora judulModel = new flora();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_kelas(cn.get_kelas());
            judulModel.set_kerajaan(cn.get_kerajaan());
            judulModel.set_divisi(cn.get_divisi());
            judulModel.set_famili(cn.get_famili());
            judulModel.set_karakteristik(cn.get_karakteristik());
            ListFlora.add(judulModel);
            if ((ListFlora.isEmpty()))
                Toast.makeText(MainActivity.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }

}
