package com.example.fooddeliveryapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.fooddeliveryapp.databinding.ActivityNullBinding;


public class FragmentNull extends Fragment {
    ActivityNullBinding binding;

    public static FragmentNull newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentNull fragment = new FragmentNull();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_null, container, false);
        return binding.getRoot();
    }
}
