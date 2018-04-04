package com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by AkshayeJH on 13/07/17.
 */

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String notification_title = remoteMessage.getNotification().getTitle();
        String notification_message = remoteMessage.getNotification().getBody();

        String click_action = remoteMessage.getNotification().getClickAction();

        String from_user_id = remoteMessage.getData().get("user_id");

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setColor(getResources().getColor(R.color.white))
                        .setSmallIcon(R.drawable.p)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.p))
                        .setContentTitle(notification_title)
                        .setContentText(notification_message)
                        .setAutoCancel(true)
                        .setSound(Settings.System.DEFAULT_NOTIFICATION_URI);


        Intent resultIntent = new Intent(click_action);
        resultIntent.putExtra("user_id", from_user_id);


        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent);




        int mNotificationId = (int) System.currentTimeMillis();

        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        mNotifyMgr.notify(mNotificationId, mBuilder.build());


    }
}
