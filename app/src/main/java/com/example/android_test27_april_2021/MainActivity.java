package com.example.android_test27_april_2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RelativeLayout snackBar = (RelativeLayout) findViewById(R.id.snackBar);
        RelativeLayout seekBar = (RelativeLayout) findViewById(R.id.seekBar);
        RelativeLayout datePicker = (RelativeLayout) findViewById(R.id.datePicker);
        RelativeLayout landscape = (RelativeLayout) findViewById(R.id.landscape);
        RelativeLayout videoView = (RelativeLayout) findViewById(R.id.videoView);
        RelativeLayout customToast = (RelativeLayout) findViewById(R.id.customToast);
        RelativeLayout webView = (RelativeLayout) findViewById(R.id.webView);
        RelativeLayout ratingBar = (RelativeLayout) findViewById(R.id.ratingBar);
        RelativeLayout randNum = (RelativeLayout) findViewById(R.id.randNum);

        snackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(v, "Are you a genius?", Snackbar.LENGTH_LONG)
                        .setAction("YES", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(v, "Shakal Dekh Apni", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                snackbar.show();
            }
        });

        seekBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Seek_Bar.class);
                startActivity(intent);
            }
        });

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Date_Picker.class);
                startActivity(intent);
            }
        });

        landscape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progDialog = new ProgressDialog(MainActivity.this);
                progDialog.setMessage("Loading Video..."); // Setting Message
                progDialog.setTitle("Please Wait"); // Setting Title
                progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                progDialog.show(); // Display Progress Dialog
                progDialog.setCancelable(false);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        progDialog.dismiss();
                        startActivity(new Intent(MainActivity.this, Video_View.class));
                    }
                }).start();
            }
        });

        customToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();
            }
        });

        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Web_View.class));
            }
        });

        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Rating_Bar.class);
                startActivity(intent);
            }
        });

        randNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Random_Numbers.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.exit)
        {
            finish();
            System.exit(0);
        }
        return true;
    }

    public void showToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));
        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastImage = layout.findViewById(R.id.toast_image);
        toastText.setText("YEH HAI BEHTAREEN WAALA CUSTOM TOAST");
        toastImage.setImageResource(R.drawable.happy_crying_meme);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}