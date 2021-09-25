package com.example.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooddeliveryapp.databinding.ActivityUserProfileBinding;

public class UserProfile extends Fragment {

    ActivityUserProfileBinding binding;

    public static UserProfile newInstance() {
        
        Bundle args = new Bundle();
        
        UserProfile fragment = new UserProfile();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_user_profile, container, false);


        return binding.getRoot();
    }
}