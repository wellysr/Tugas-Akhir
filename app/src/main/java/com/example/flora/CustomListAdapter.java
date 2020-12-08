package com.example.flora;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<flora> movieItems;
    public CustomListAdapter(Activity activity, List<flora> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.costum_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView nkerajaan = (TextView) convertView.findViewById(R.id.kerajaan);
        TextView ndivisi = (TextView) convertView.findViewById(R.id.divisi);
        TextView nkelas = (TextView) convertView.findViewById(R.id.kelas);
        TextView nfamili = (TextView) convertView.findViewById(R.id.famili);
        TextView nkarakteristik = (TextView) convertView.findViewById(R.id.karakteristik);
        //        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        flora m = movieItems.get(position);
        nama.setText("Nama : "+ m.get_nama());
        nkerajaan.setText("Kerajaan : "+ m.get_kerajaan());
        ndivisi.setText("Divisi :"+m.get_divisi());
        nkelas.setText("Kelas :"+ m.get_kelas());
        nfamili.setText("Famili :"+m.get_famili());
        nkarakteristik.setText("Karakteristik"+ m.get_karakteristik());
        return convertView;
    }
}