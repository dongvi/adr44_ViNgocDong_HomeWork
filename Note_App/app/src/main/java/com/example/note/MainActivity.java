package com.example.note;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.note.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ActivityMainBinding binding;

    private int lastSelectedHour = 0, lastSelectedMinute = 0;
    private  int lastSelectedDay = 0, lastSelectedMonth = 0, lastSelectedYear = 0;
    private String[] tags = {"Family", "Game", "Android", "VTC", "FPT", "Friend"};
    private List<String> tagsSelected = new ArrayList<>();
    private String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Saturday", "Sunday"};
    private List<String> weeksSelected = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

// set current date
        if(lastSelectedYear == 0 || lastSelectedMonth == 0 || lastSelectedDay == 0){
            Calendar calendar = Calendar.getInstance();
            lastSelectedDay = calendar.get(Calendar.DATE);
            lastSelectedMonth = calendar.get(Calendar.MONTH);
            lastSelectedYear = calendar.get(Calendar.YEAR);
            binding.tvDate.setText(String.format("%02d/%02d/%04d", lastSelectedDay, lastSelectedMonth, lastSelectedYear));
        }

        //String[] types = {"Work", "Friend", "Family"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, types);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.types, android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(this);

        binding.tvTags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tagsDialog();
            }
        });

        binding.tvWeeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weeksDialog();
            }
        });

        binding.tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTime();
            }
        });

        binding.tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectDate();
            }
        });

        binding.btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(getBaseContext());
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void selectTime()  {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                binding.tvTime.setText(String.format("%02d:%02d", hour, minute));
                lastSelectedHour = hour;
                lastSelectedMinute = minute;
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, timeSetListener, lastSelectedHour, lastSelectedMinute, true);
        timePickerDialog.show();
    }

    private void selectDate(){

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                binding.tvDate.setText(String.format("%02d/%02d/%04d", day, month, year));
                lastSelectedDay = day;
                lastSelectedMonth = month;
                lastSelectedYear = year;
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, lastSelectedYear, lastSelectedMonth, lastSelectedDay);
        datePickerDialog.show();
    }

    private void tagsDialog(){
        boolean[] check = new boolean[tags.length];

        for (int tag = 0; tag < tags.length; tag++)
            for(String j : tagsSelected)
                if(tags[tag].compareTo(j) == 0)
                    check[tag] = true;

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Choose tags:")
                .setMultiChoiceItems(tags, check, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b)   tagsSelected.add(tags[i]);
                        else    tagsSelected.remove(tags[i]);
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String rs = "";
                        for(int j = 0; j < tagsSelected.size(); j++){
                            rs += tagsSelected.get(j);
                            if(j < tagsSelected.size() - 1)
                                rs += ", ";
                        }
                        binding.tvTags.setText(rs);
                        if(tagsSelected.size() == 0)
                            binding.tvTags.setText("Click here!");
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create();
        alertDialog.show();
    }

    private void weeksDialog(){
        boolean[] check = new boolean[weeks.length];

        for (int tag = 0; tag < weeks.length; tag++)
            for(String j : weeksSelected)
                if(weeks[tag].compareTo(j) == 0)
                    check[tag] = true;

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Choose weeks:")
                .setMultiChoiceItems(weeks, check, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if(b)   weeksSelected.add(weeks[i]);
                        else    weeksSelected.remove(weeks[i]);
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String rs = "";
                        int count = 0;
                        for(int pst = 0; pst < check.length; pst++){
                            if(check[pst]) {
                                rs += weeks[pst].subSequence(0, 3);
                                count++;
                                if (count < weeksSelected.size())
                                    rs += ", ";
                            }
                        }
                        binding.tvWeeks.setText(rs);
                        if(weeksSelected.size() == 0)
                            binding.tvWeeks.setText("Click here!");
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create();
        alertDialog.show();
    }

    private void popupMenu(){
        PopupMenu popupMenu = new PopupMenu(this, binding.btnTune);
        popupMenu.inflate(R.menu.menu_popup);

        Menu menu = popupMenu.getMenu();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return fromDefaultDialog();
            }
        });

        popupMenu.show();
    }

    private boolean fromDefaultDialog(){
        String[] fromDefault = {"Nexus Tune", "Winphone Tune", "Peep Tune", "Nokia Tune", "Etc"};
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setSingleChoiceItems(fromDefault, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create();
        alertDialog.show();
        return true;
    }
}