package com.example.android_test27_april_2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rating_Bar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        // initiate rating bar and a button
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        Button submit = (Button) findViewById(R.id.btn_submit);



        // perform click event on button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db database = new db(getApplicationContext());
                Boolean kuchbhi = database.insert_ratings(String.valueOf(ratingBar.getRating()));

                if (kuchbhi == true)
                {
                    int reqCode = 1;
                    showNotification(Rating_Bar.this, "Muhammad Zain Qadri", "The data has been inserted to the database", reqCode);                }

                else
                {
                    Toast.makeText(Rating_Bar.this, "Data Insertion Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void showNotification(Context context, String title, String message, int reqCode) {

        String CHANNEL_ID = "channel_name";// The id of the channel.
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.happy_crying_meme)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Channel Name";// The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(reqCode, notificationBuilder.build()); // 0 is the request code, it should be unique id

        Log.d("showNotification", "showNotification: " + reqCode);
    }
}