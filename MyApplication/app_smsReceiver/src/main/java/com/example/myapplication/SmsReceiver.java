package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    private static final String SENDER_ADDRESS = "number here";

    public SmsReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] messages = (Object[]) bundle.get("pdus");
        SmsMessage[] sms = new SmsMessage[messages.length];

        for (int n = 0; n< messages.length; n++) {
            sms[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
        }

        for (SmsMessage msg : sms) {
            if (TextUtils.equals(msg.getOriginatingAddress(),SENDER_ADDRESS)) {
                abortBroadcast();

                Toast.makeText(context,
                        "Receiver msg" + msg.getMessageBody(),
                        Toast.LENGTH_SHORT).show();
            }
        }



    }
}
