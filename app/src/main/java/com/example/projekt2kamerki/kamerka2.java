package com.example.projekt2kamerki;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class kamerka2 extends AppCompatActivity {

    private String videoUrl = "https://video.raciborz24.pl/hls/strzybniczek.m3u8";
    private ProgressDialog pd;
    VideoView video2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamerka2);

        video2 = findViewById(R.id.video2);
        pd = new ProgressDialog(this);
        pd.setMessage("Buforowanie...");

        playVideo();
    }

    private void playVideo() {
        try {
            getWindow().setFormat(PixelFormat.TRANSLUCENT);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(video2);

            //parse url as Uri
            Uri videoUri = Uri.parse(videoUrl);

            //set media controller to video view
            video2.setMediaController(mediaController);

            //set video Uri
            video2.setVideoURI(videoUri);
            video2.requestFocus();
            video2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    pd.dismiss();
                    video2.start();
                }
            });
        }
        catch (Exception ex) {
            //if anything goes wrong causing exception, get and show exception message
            pd.dismiss();
            Toast.makeText(this, "oops" + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}