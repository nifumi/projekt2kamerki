package com.example.projekt2kamerki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private String videoUrl = "https://video.raciborz24.pl/hls/polna.m3u8";
    VideoView videoView1, videoView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView1 = findViewById(R.id.videoView1);
        videoView2 = findViewById(R.id.videoView2);

        videoView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, kamerka1.class);
                startActivity(intent);
            }
        });

        videoView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, kamerka2.class);
                startActivity(intent);
            }
        });
    }
}