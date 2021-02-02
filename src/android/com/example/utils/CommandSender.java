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

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import com.example.Constants;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CommandSender extends AsyncTask<String, Void, String> {

    private static final String TAG = CommandSender.class.getName();

    private CommandSenderCallback commandSenderCallback;

    public CommandSender(Context applicationContext, CommandSenderCallback commandSenderCallback) {
        this.commandSenderCallback = commandSenderCallback;
        HTTPUtils.enableTLSv1_2(applicationContext);
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            assert strings != null;
            String command = strings[0];

            // Make HTTP call
            Map<String, String> request = new HashMap<>();
            request.put(Constants.SERVER_COMMAND_KEY, command);
            Map<String, String> serverResponse = HTTPUtils.performJSONRequest(Constants.ENDPOINT_URL, request, true);

            JSONObject obj = new JSONObject(serverResponse.get("result"));
            if (!obj.has(Constants.SERVER_COMMAND_KEY)){
                return null;
            }

            /*if (!serverResponse.containsKey(Constants.SERVER_COMMAND_KEY)) {
                return null;
            }*/

            // Return received command
            return obj.getString(Constants.SERVER_COMMAND_KEY);

        } catch (Exception e) {
            Log.e(TAG, "Exception in CommandSender", e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(String serverCommand) {

        if (serverCommand == null)
            commandSenderCallback.onCommandSendingFailure();
        else
            commandSenderCallback.onCommandSendingSuccess(serverCommand);

    }
}
