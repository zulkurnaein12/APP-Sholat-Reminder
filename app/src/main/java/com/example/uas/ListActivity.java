package com.example.uas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ListActivity extends AppCompatActivity {
    private TextView currentDay;
    private TextView currentDate;
    private String[] options = {
            "Sudah Shalat", "Berhalangan", "Tidak Shalat"
    };

    // List of Shalat List Layout
    private LinearLayout subuhOption;
    private LinearLayout dzuhurOption;
    private LinearLayout asharOption;
    private LinearLayout maghribOption;
    private LinearLayout isyaOption;

    // List image icon
    private ImageView subuhOptionImage;
    private ImageView dzuhurOptionImage;
    private ImageView asharOptionImage;
    private ImageView maghribOptionImage;
    private ImageView isyaOptionImage;

    private TextView accumulatorView;public void createPrompt(ImageView icon) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Absen Shalat");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String selected = options[which];
                changeImageIcon(selected, icon);
            }
        });
        builder.show();
    }

    public void changeImageIcon(String status, ImageView icon) {
        switch (status) {
            case "Sudah Shalat":
                icon.setImageResource(R.drawable.ic_check);
                break;
            case "Berhalangan":
                icon.setImageResource(R.drawable.ic_remove);
                break;
            case "Tidak Shalat":
                icon.setImageResource(R.drawable.ic_close);
                break;
            default: icon.setImageResource(R.drawable.ic_circle);
        }
    }

    // Get date
    public void generateCalendar(TextView currentDay, TextView currentDate) {
        Date date = new Date();
        Locale local = new Locale("id", "ID");

        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, local);

        String dt = df.format(date);
        String pattern = "EEEE";
        SimpleDateFormat dy = new SimpleDateFormat(pattern);

        currentDate.setText(df.format(date));
        currentDay.setText(dy.format(date));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Get layouts
        subuhOption = (LinearLayout) findViewById(R.id.subuhOption);
        subuhOptionImage = (ImageView) findViewById(R.id.subuhOptionImage);

        dzuhurOption = (LinearLayout) findViewById(R.id.dzuhurOption);
        dzuhurOptionImage = (ImageView) findViewById(R.id.dzuhurOptionImage);

        asharOption = (LinearLayout) findViewById(R.id.asharOption);
        asharOptionImage = (ImageView) findViewById(R.id.asharOptionImage);

        maghribOption = (LinearLayout) findViewById(R.id.maghribOption);
        maghribOptionImage = (ImageView) findViewById(R.id.maghribOptionImage);

        isyaOption = (LinearLayout) findViewById(R.id.isyaOption);
        isyaOptionImage = (ImageView) findViewById(R.id.isyaOptionImage);

        // Generate tanggal
        currentDate = (TextView) findViewById(R.id.currentDate);
        currentDay = (TextView) findViewById(R.id.currentDay);
        generateCalendar(currentDay, currentDate);

        // Tap actions
        subuhOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPrompt(subuhOptionImage);
            }
        });

        dzuhurOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPrompt(dzuhurOptionImage);
            }
        });

        asharOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPrompt(asharOptionImage);
            }
        });

        maghribOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPrompt(maghribOptionImage);
            }
        });

        isyaOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPrompt(isyaOptionImage);
            }
        });
    }
}