package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by markmin on 16/6/19.
 */
public class EvaluateDialog extends DialogFragment{
    String[] mValues;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new  AlertDialog.Builder(getActivity());
        builder.setTitle("Evaluate!");
         mValues = new String[]{"aa","bb","cc"};
        builder.setItems(mValues, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                setResult(which);
            }
        } );


        return builder.create();
    }

    public void setResult(int which) {

        if (getTargetFragment() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("result",mValues[which]);
        getTargetFragment().onActivityResult(1, Activity.RESULT_OK,intent);


    }
}
