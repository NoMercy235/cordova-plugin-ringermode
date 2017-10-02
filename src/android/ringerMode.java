package com.cordova.plugins.ringermode;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.media.AudioManager;

/**
 * This class echoes a string called from JavaScript.
 */

public class ringerMode extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getRingerMode")) {
            this.getRingerMode(callbackContext);
            return true;
        } else if (action.equals("setRingerMode")) {
            this.setRingerMode(args, callbackContext);
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

    private void setRingerMode(String strMode, CallbackContext callbackContext) {
        Context context = this.cordova.getActivity().getApplicationContext();
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        int mode = Integer.parseInt(strMode); 
        switch (mode) {
            case 0:
                audioManager.setRingerMode(RINGER_MODE_SILENT);
                callbackContext.success("RINGER_MODE_SILENT");
                break;
            case 1:
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                callbackContext.success("RINGER_MODE_VIBRATE");
                break;
            case 2:
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL));
                callbackContext.success("RINGER_MODE_NORMAL");
                break;
        }
        callbackContext.error("NONE");
    }
}
