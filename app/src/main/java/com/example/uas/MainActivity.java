package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView ButtonNext = null;
    private TextView haditsArea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.adzan);
        music.start();
        music.setLooping(true);


        // Random Hadits
        String[] hadits = {
                "Yang pertama kali ditanyakan kepada seorang hamba pada hari kiamat adalah perhatian kepada sholatnya. Jika sholatnya baik, dia akan beruntung (dalam sebuah riwayat disebutkan dia akan berhasil). Dan jika salatnya rusak, dia akan gagal dan merugi.",
                "Peliharalah segala shalat(mu), dan (peliharalah) shalat wusthaa. Berdirilah untuk Allah (dalam shalatmu) dengan khusyu.",
                "Yang pertama kali akan dihisab dari seseorang pada hari kiamat adalah salat. Jika salatnya baik, akan baik pula seluruh amalnya. Jika salatnya rusak akan rusak pula seluruh amal perbuatannya."
        };

        haditsArea = (TextView) findViewById(R.id.haditsArea);
        int random = new Random().nextInt(hadits.length);

        haditsArea.setText(hadits[random]);

        // Toast
        Toast.makeText(this, "20302017 - Zulkurnaein", Toast.LENGTH_SHORT).show();

        // Button Next animation
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        ButtonNext = (ImageView)findViewById(R.id.buttonNext);

        // Animate
        ButtonNext.startAnimation(shake);

        // navigate to list
        ButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this, ListActivity.class
                );
                //playAudio();
                music.stop();
                startActivity(intent);
            }
        });
    }
}