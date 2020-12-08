package com.example.floradanfauna.ui.flora;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.floradanfauna.R;

public class FloraFragment extends Fragment{

    private FloraViewModel FloraViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FloraViewModel =
                ViewModelProviders.of(this).get(FloraViewModel.class);
        View root = inflater.inflate(R.layout.fragment_flora, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        FloraViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}