package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by markmin on 16/6/29.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
//        dialogBuilder.setTitle("Forceoffline");
//        dialogBuilder.setMessage("you are forced to be offonlie");
//        dialogBuilder.setCancelable(false);
//        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//           finishANDcreat(context);
//
//            }
//        });
//
//        AlertDialog alertDialog = dialogBuilder.create();
//        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
//
//        alertDialog.show();


        finishANDcreat(context);

        Toast.makeText(context,"FORCE ",Toast.LENGTH_SHORT).show();
    }

    private void finishANDcreat(Context context) {
        ActivityCollector.finishAll();
        Intent intent1 = new Intent(context, LoginActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
