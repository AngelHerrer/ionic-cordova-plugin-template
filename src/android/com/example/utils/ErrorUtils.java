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

import com.multiva.bmdc.R;
import com.vasco.orchestration.client.errors.OrchestrationErrorCodes;
import com.vasco.orchestration.client.errors.OrchestrationWarningCodes;


public class ErrorUtils {


    public static String getErrorMessage(Context context, int errorCode) {

        switch (errorCode) {
            case OrchestrationErrorCodes.COMMAND_PARSING_ERROR:
                return "Failed to parse command";
            case OrchestrationErrorCodes.ACTIVATION_ERROR:
                return "Failed to activate";
            case OrchestrationErrorCodes.LOCAL_AUTHENTICATION_ERROR:
                return "Failed to perform local authentication";
            case OrchestrationErrorCodes.LOCAL_TRANSACTION_ERROR:
                return "Failed to perform local transaction";
            case OrchestrationErrorCodes.REMOTE_AUTHENTICATION_ERROR:
                return "Failed to perform remote authentication";
            case OrchestrationErrorCodes.REMOTE_TRANSACTION_ERROR:
                return "Failed to perform remote transaction";
            case OrchestrationErrorCodes.NOTIFICATION_REGISTRATION_ERROR:
                return "Failed to register for notifications";
            case OrchestrationErrorCodes.CHANGE_PASSWORD_ERROR:
                return "Failed to change PIN";
            case OrchestrationErrorCodes.MISSING_PERMISSION_LOCATION:
                return "Location permissions are missing";
            case OrchestrationErrorCodes.MISSING_PERMISSION_READ_PHONE_STATE:
                return "Read phone state permission are not granted";
            case OrchestrationErrorCodes.MISSING_PERMISSION_BLUETOOTH:
                return "Bluetooth permission is missing";
            case OrchestrationErrorCodes.MISSING_PERMISSION_WIFI:
                return "Wifi permission is missing";
            case OrchestrationErrorCodes.MISSING_MANDATORY_PERMISSIONS_FOR_CDDC:
                return "Mandatory permissions for CDDC are missing";
            case OrchestrationErrorCodes.USER_ID_NULL_OR_EMPTY:
                return "The user identifier is null or empty";
            case OrchestrationErrorCodes.USER_ID_WRONG_FORMAT:
                return "The user identifier contains invalid characters";
            case OrchestrationErrorCodes.ACTIVATION_PASSWORD_NULL_OR_EMPTY:
                return "The activation password is null or empty";
            case OrchestrationErrorCodes.ACTIVATION_PASSWORD_WRONG_LENGTH:
                return "The activation password has a wrong length";
            case OrchestrationErrorCodes.ACTIVATION_PASSWORD_WRONG_CHECKSUM:
                return "The activation password is not correct";
            case OrchestrationErrorCodes.PASSWORD_NULL:
                return "The PIN is null";
            case OrchestrationErrorCodes.PASSWORD_TOO_SHORT:
                return "The PIN is too short";
            case OrchestrationErrorCodes.PASSWORD_TOO_LONG:
                return "The PIN is too long";
            case OrchestrationErrorCodes.PASSWORD_WEAK:
                return "The entered is too weak";
            case OrchestrationErrorCodes.PASSWORD_WRONG:
                return "The entered PIN is wrong";
            case OrchestrationErrorCodes.PASSWORD_LOCK:
                return "The digipass is locked after too many wrong PIN";
            default:
                return "Unknown error";

        }
    }

    public static String getWarningMessage(Context context, int warningCode) {
        switch (warningCode) {
            case OrchestrationWarningCodes.UNKNOWN_WARNING:
                return "Internal error";
            case OrchestrationWarningCodes.BLUETOOTH_INFORMATION_NOT_SUPPORTED:
                return "Bluetooth information not supported";
            case OrchestrationWarningCodes.MISSING_BLUETOOTH_PERMISSION:
                return "Bluetooth permission not granted";
            case OrchestrationWarningCodes.MISSING_LOCATION_PERMISSION:
                return "Location permission not granted";
            case OrchestrationWarningCodes.MISSING_READ_PHONE_STATE_PERMISSION:
                return "Phone permission not granted";
            case OrchestrationWarningCodes.LOCATION_TIMEOUT:
                return "Timeout when retrieving location";
            case OrchestrationWarningCodes.LOCATION_UNAVAILABLE:
                return "Failed to get location";
            case OrchestrationWarningCodes.MISSING_WIFI_PERMISSION:
                return "Wifi permission not granted";
            default:
                return "Unknown error";

        }
    }
}
