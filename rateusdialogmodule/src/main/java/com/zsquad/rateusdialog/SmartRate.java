package com.zsquad.rateusdialog;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class SmartRate {


    private static final long DONT_ASK_AGAIN_VALUE = -1;
    private static final String SP_LIBRARY_NAME = "SP_RATE_LIBRARY";
    private static final String SP_KEY_LAST_ASK_TIME = "SP_KEY_LAST_ASK_TIME";
    private static final String SP_KEY_INIT_TIME = "SP_KEY_INIT_TIME";
    private static final long DEFAULT_TIME_BETWEEN_DIALOG_MS = 1000l * 60 * 60 * 24 * 6; // 3 days
    private static final long DEFAULT_DELAY_TO_ACTIVATE_MS = 1000l * 60 * 60 * 24 * 3; // 3 days


    public static void Rate(
            final Activity activity
            , final int _hoursBetweenCalls
            , final int _hoursDelayToActivate
    ) {

        final long timeBetweenCalls_Ms = (_hoursBetweenCalls >= 0 && _hoursBetweenCalls < 366 * 24) ? 1000l * 60 * 60 * _hoursBetweenCalls : DEFAULT_TIME_BETWEEN_DIALOG_MS;
        final long timeDelayToActivate_Ms = (_hoursDelayToActivate >= 0 && _hoursDelayToActivate < 366 * 24) ? 1000l * 60 * 60 * _hoursDelayToActivate : DEFAULT_DELAY_TO_ACTIVATE_MS;


        if (_hoursBetweenCalls != -1 && _hoursDelayToActivate != -1) {
            // no force asking mode
            long initTime = getInitTime(activity);
            if (initTime == 0) {
                initTime = System.currentTimeMillis();
                setInitTime(activity, initTime);
            }
            if (System.currentTimeMillis() < initTime + timeDelayToActivate_Ms) {
                return;
            }

            if (getLastAskTime(activity) == DONT_ASK_AGAIN_VALUE) {
                // user already rate or click on never ask button
                return;
            }
            if (System.currentTimeMillis() < getLastAskTime(activity) + timeBetweenCalls_Ms) {
                // There was not enough time between the calls.
                return;
            }
        }

        setLastAskTime(activity, System.currentTimeMillis());

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog, null);
        dialogBuilder.setView(dialogView);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);


        if (_hoursBetweenCalls == -1 && _hoursDelayToActivate == -1) {
            // force asking mode
        }

        alertDialog.show();
    }

    private static void launchMarket(Activity activity) {
        Uri uri = Uri.parse("market://details?id=" + activity.getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            activity.startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(activity, " unable to find google play app", Toast.LENGTH_LONG).show();
        }
    }

    private static long getLastAskTime(Activity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SP_LIBRARY_NAME, Context.MODE_PRIVATE);
        long val = sharedPreferences.getLong(SP_KEY_LAST_ASK_TIME, 0);
        return val;
    }

    private static void setLastAskTime(Activity activity, long time) {
        SharedPreferences.Editor editor = activity.getSharedPreferences(SP_LIBRARY_NAME, Context.MODE_PRIVATE).edit();
        editor.putLong(SP_KEY_LAST_ASK_TIME, time);
        editor.apply();
    }

    private static long getInitTime(Activity activity) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(SP_LIBRARY_NAME, Context.MODE_PRIVATE);
        long val = sharedPreferences.getLong(SP_KEY_INIT_TIME, 0);
        return val;
    }

    private static void setInitTime(Activity activity, long time) {
        SharedPreferences.Editor editor = activity.getSharedPreferences(SP_LIBRARY_NAME, Context.MODE_PRIVATE).edit();
        editor.putLong(SP_KEY_INIT_TIME, time);
        editor.apply();
    }


}
