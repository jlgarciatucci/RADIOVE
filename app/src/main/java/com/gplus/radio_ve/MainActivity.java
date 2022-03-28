package com.gplus.radio_ve;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imagePlayPause;
    private MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        imagePlayPause = findViewById(R.id.imagePlayPause);
        mediaplayer = new MediaPlayer();

        imagePlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaplayer.isPlaying()) {
                    mediaplayer.pause();

                    imagePlayPause.setImageResource(R.drawable.ic_play);
                } else {
                    mediaplayer.start();
                    imagePlayPause.setImageResource(R.drawable.ic_pause);
                }
            }
        });
        prepareMediaPlayer();
    }

    private void prepareMediaPlayer() {
        try {
            mediaplayer.setDataSource("https://server8.emitironline.com:18492/stream");
            mediaplayer.prepare(); }
        catch (Exception exception) {
        }
    }

}
