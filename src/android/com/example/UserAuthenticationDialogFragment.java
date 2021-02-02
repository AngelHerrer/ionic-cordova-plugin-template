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


package com.example;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.multiva.bmdc.R;
import com.vasco.orchestration.client.authentication.UserAuthenticationInputCallback;

@SuppressLint("ValidFragment")
public class UserAuthenticationDialogFragment extends DialogFragment {

    private UserAuthenticationInputCallback inputCallback;
    private Activity activity;
    private boolean isEnrollment; //indicates if a new password must be set
    private int dialogMessage; //error message to display in case of password error
    private boolean confirmError; //indicates that new and confirm passwords don't match

    public UserAuthenticationDialogFragment(Activity activity, UserAuthenticationInputCallback inputCallback, boolean isEnrollment, int message) {
        this.activity = activity;
        this.inputCallback = inputCallback;
        this.isEnrollment = isEnrollment;
        this.dialogMessage = message;
        this.confirmError = false;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                EditText password = ((AlertDialog) dialog).findViewById(R.id.password);
                EditText passwordConfirm = ((AlertDialog) dialog).findViewById(R.id.password_confirm);

                if(isEnrollment){
                    if(!password.getText().toString().equals(passwordConfirm.getText().toString())){
                        dialogMessage = R.string.orch_pinpad_error_confirmation;
                        confirmError = true;
                        dismiss();
                        return;
                    }
                }
                inputCallback.onUserAuthenticationInputSuccess(password.getText());
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(passwordConfirm.getWindowToken(), 0);
                dismiss();
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        inputCallback.onUserAuthenticationInputAborted();
                        dismiss();
                    }
                })
                .setView(inflater.inflate(R.layout.dialog_password, null))
                .setTitle(R.string.orch_pinpad_text_authentication);
        if(dialogMessage != 0){
            builder.setMessage(dialogMessage);
        }

        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);

        if(!isEnrollment) {
            Dialog.OnShowListener showListener = new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    ((AlertDialog) dialogInterface).findViewById(R.id.password_confirm).setVisibility(View.GONE);
                }
            };
            alertDialog.setOnShowListener(showListener);
        }

        return alertDialog;
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        if(confirmError){
            UserAuthenticationDialogFragment dialog = new UserAuthenticationDialogFragment(activity, inputCallback, isEnrollment, dialogMessage);
            android.app.FragmentManager fragmentManager = getFragmentManager();
            dialog.show(fragmentManager, "dialog");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout to use as dialog or embedded fragment
        return inflater.inflate(R.layout.dialog_password, container, false);
    }

}