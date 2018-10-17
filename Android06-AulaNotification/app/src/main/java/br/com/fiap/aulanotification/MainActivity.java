package br.com.fiap.aulanotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.service.autofill.Validators;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exibirNotificacao(View view) {
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId = "alertas";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    channelId,
                    "Meu canal de notificação",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationChannel.setDescription("Descrição explicando este canal...");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 2000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);

            NotificationCompat.Builder notification = new NotificationCompat
                    .Builder(this, channelId);

            notification.setContentTitle("Alerta");
            notification.setContentText("Seu download foi concluido...");
            notification.setSmallIcon(R.mipmap.ic_launcher);

            notificationManager.notify(100, notification.build());

            notification.setContentIntent(PendingIntent.getActivity(
                    this,
                    0,
                    new Intent(this, MainActivity.class),
                    PendingIntent.FLAG_UPDATE_CURRENT)
            );
            notification.setAutoCancel(true);
            notificationManager.notify(100, notification.build());
        }
    }
}
