package com.example.codeplay.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class Utils {

    Context context;
    public Utils(Context context) {

        this.context = context;

    }

    //AlertDialog to show custom message

    //Toast Message to display
    public static void showToastMessage(String message, Context context) {

        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
}
