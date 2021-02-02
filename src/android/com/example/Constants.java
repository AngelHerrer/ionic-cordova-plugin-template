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


public class Constants {

    // Android Sender ID used to register for push notifications
    // TODO: Paste here the Sender ID of your Android project, retrieved from the Google Firebase Console.
    public static final String ANDROID_SENDER_ID = "<android sender id>";

    // The ACCOUNT_IDENTIFIER can be found on the Community Portal ( https://community.onespan.com ) by first hovering over your username and selecting 'Sandbox'. On this page should be a field called 'Sandbox user'
    // TODO: Paste here your Account Identifier.
    //public static final String ACCOUNT_IDENTIFIER = "nestormorales-multiv";
    public static final String ACCOUNT_IDENTIFIER = "<account identifier>";
    public static final String CLOUD_SERVER_URL = ".sdb.tid.onespan.cloud";
    public static final String DOMAIN = ACCOUNT_IDENTIFIER.toLowerCase();
    // Adaptive Authentication web service URL
    // Add android:usesCleartextTraffic="true" to <application> tag in AndroidManifest
    // if you connecting to the server via http
    public static final String ENDPOINT_URL = "http://multiva-orchestration-api-esb-multiva.apps.dev.openshift.multivaloresgf.local/api/v1/command";


    // Salts used to diversify the protection mechanisms for sensitive features.
    // TODO: Paste here two different random strings of 64 hexadecimal characters.
    public static final String SALT_STORAGE = "0000000000000000000000000000000000000000000000000000000000000000";
    public static final String SALT_DIGIPASS = "1111111111111111111111111111111111111111111111111111111111111111";

    // JSON key for network requests
    public static final String SERVER_COMMAND_KEY = "command";
}
