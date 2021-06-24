package com.example.projekt2kamerki;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class kamerka1 extends AppCompatActivity {

    private String videoUrl = "https://video.raciborz24.pl/hls/polna.m3u8";
    private ProgressDialog pd;
    VideoView video1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamerka1);

        video1 = findViewById(R.id.video1);
        pd = new ProgressDialog(this);
        pd.setMessage("Buforowanie...");
        
        playVideo();
    }

    private void playVideo() {
        try {
            getWindow().setFormat(PixelFormat.TRANSLUCENT);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(video1);

            //parse url as Uri
            Uri videoUri = Uri.parse(videoUrl);

            //set media controller to video view
            video1.setMediaController(mediaController);

            //set video Uri
            video1.setVideoURI(videoUri);
            video1.requestFocus();
            video1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    pd.dismiss();
                    video1.start();
                }
            });
        }
        catch (Exception ex) {
            //if anything goes wrond causing exception, get and show exception message
            pd.dismiss();
            Toast.makeText(this, "oops" + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}