package com.cordova.plugins.ringermode;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.apache.commons.lang.ArrayUtils;

import android.content.Context;
import android.media.AudioManager;

/**
 * This class echoes a string called from JavaScript.
 */

public class ringerMode extends CordovaPlugin {
    private int[] validModes = new int[]{ AudioManager.RINGER_MODE_SILENT, AudioManager.RINGER_MODE_VIBRATE, AudioManager.RINGER_MODE_NORMAL };

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getRingerMode")) {
            this.getRingerMode(callbackContext);
            return true;
        } else if (action.equals("setRingerSilent")) {
            this.setRingerSilent(callbackContext);
            return true;
        } else if (action.equals("setRingerVibrate")) {
            this.setRingerVibrate(callbackContext);
            return true;
        } else if (action.equals("setRingerNormal")) {
            this.setRingerNormal(callbackContext);
            return true;
        }
        return false;
    }

    private void getRingerMode(CallbackContext callbackContext) {
        Context context = this.cordova.getActivity().getApplicationContext();
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        switch (audioManager.getRingerMode()) {
            case AudioManager.RINGER_MODE_SILENT:
                callbackContext.success("RINGER_MODE_SILENT");
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                callbackContext.success("RINGER_MODE_VIBRATE");
                break;
            case AudioManager.RINGER_MODE_NORMAL:
                callbackContext.success("RINGER_MODE_NORMAL");
                break;
        }
        callbackContext.error("NONE");
    }

    private void setRingerMode(CallbackContext callbackContext, int mode, String echoedResponse) {
        Context context = this.cordova.getActivity().getApplicationContext();
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        if (this.isValidMode(mode)) {
            audioManager.setRingerMode(mode);
            callbackContext.success(echoedResponse);
        } else {
            callbackContext.error("NONE");
        }
    }

    private void setRingerSilent(CallbackContext callbackContext) {
        this.setRingerMode(callbackContext, AudioManager.RINGER_MODE_SILENT, "RINGER_MODE_SILENT");
    }

    private void setRingerVibrate(CallbackContext callbackContext) {
        this.setRingerMode(callbackContext, AudioManager.RINGER_MODE_VIBRATE, "RINGER_MODE_VIBRATE");
    }

    private void setRingerNormal(CallbackContext callbackContext) {
        this.setRingerMode(callbackContext, AudioManager.RINGER_MODE_NORMAL, "RINGER_MODE_NORMAL");
    }

    private boolean isValidMode(final int mode) {     
        return ArrayUtils.contains(this.validModes, mode);
    }
}
