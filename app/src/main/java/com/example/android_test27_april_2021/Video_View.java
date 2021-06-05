package com.example.android_test27_april_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        VideoView videoView = findViewById(R.id.video_view);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.are_you_gonna_miss;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                startActivity(new Intent(Video_View.this, MainActivity.class));
            }
        });

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


    }
}