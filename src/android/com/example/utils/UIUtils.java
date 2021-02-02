// (c) 1999 - 2019 OneSpan North America Inc. All rights reserved.


/////////////////////////////////////////////////////////////////////////////
//
//
// This file is example source code. It is provided for your information and
// assistance. See your licence agreement for details and the terms and
// conditions of the licence which governs the use of the source code. By using
// such source code you will be accepting these terms and conditions. If you do
// not wish to accept these terms and conditions, DO NOT OPEN THE FILE OR USE
// THE SOURCE CODE.
//
// Note that there is NO WARRANTY.
//
//////////////////////////////////////////////////////////////////////////////


package com.example.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

public class UIUtils {

    public static void displayAlert(final Context context, final String title, final String message) {
        Toast.makeText(context, title+ "/" + message, Toast.LENGTH_LONG).show();
        /*AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.create().show();*/
    }

    public static void displayAlertWithAction(final Context context, final String title, final String message,
                                              final String yes, final String no, final DialogInterface.OnClickListener yesListener, final DialogInterface.OnClickListener noListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(yes, yesListener);
        builder.setNegativeButton(no, noListener);
        builder.create().show();
    }

    public static Dialog displayProgress(Context context, String message) {
        return ProgressDialog.show(context, null, message, true, false, null);
    }

    public static void hideProgress(Dialog dialog) {
        if (dialog != null)
            dialog.dismiss();
    }
}
