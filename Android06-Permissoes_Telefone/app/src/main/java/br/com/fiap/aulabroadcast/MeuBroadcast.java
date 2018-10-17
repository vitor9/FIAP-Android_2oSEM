package br.com.fiap.aulabroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MeuBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle myBundle = intent.getExtras();
        SmsMessage[] messages = null;
        String strMessage = "";

        if (myBundle != null) {
            Object[] pdus = (Object[]) myBundle.get("pdus");
            messages = new SmsMessage[pdus.length];

            for (int i = 0; i < messages.length; i++) {
                // Se a versao do build for diferente do android Marshmallow
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String format = myBundle.getString("format");
                    // Vai utilizar a versao mais recente de createFromPdu
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i], format);
                } else {
                    // Caso contrario vai utilizar a versao mais antiga do createFromPdu
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                }

                strMessage += "SMS From: " + messages[i].getOriginatingAddress();
                strMessage += " : " + messages[i].getMessageBody();
                strMessage += "\n";
            }

            Toast.makeText(context, strMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
