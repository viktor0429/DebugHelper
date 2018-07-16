package yuxiaofei93.debughelper;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 0;

    private static final String CHANNEL_ID = "DebugHelper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        showNotification();
    }

    public void onDeveloperConfigClick(View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
        startActivity(intent);
    }

    public void onAccessibilityConfigClick(View view) {
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        startActivity(intent);
    }


    public void showNotification() {
        NotificationManagerCompat nmc = NotificationManagerCompat.from(this);
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification nfc = new NotificationCompat.Builder(this, "DebugHelper")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("DebugHelper")
                .setContentText("打开设置页面")
                .setContentIntent(pIntent)
                .setAutoCancel(false)
                .build();
        nmc.notify(NOTIFICATION_ID, nfc);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "DebugHelper", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager nm = getSystemService(NotificationManager.class);
            nm.createNotificationChannel(channel);
        }
    }
}
