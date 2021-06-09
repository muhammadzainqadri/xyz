package com.example.android_test27_april_2021;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;

interface RingtoneHelper {
    void stopRingtone();
}

class Utility {

    public static RingtoneHelper ringtoneHelper;
}

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int reqCode = 1;
        showNotification(context, "Muhammad Zain Qadri", "Wake Up Johny! You have to go to school", reqCode);

        TextView mTextView = (TextView) Alarm.instance.findViewById(R.id.textView);
        mTextView.setText("It's Time");
    }

    public void showNotification(Context context, String title, String message, int reqCode) {
        String CHANNEL_ID = "channel_name";// The id of the channel.
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.happy_crying_meme)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.TYPE_ALARM));

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
