package com.test.myplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.media.MediaDrm;
import java.security.MessageDigest;
import java.util.*;

/**
 * This class echoes a string called from JavaScript.
 */
public class myPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("drmuuid")) {
            String message = args.getString(0);
            this.drmuuid(message, callbackContext);
            return true;
        }
        return false;
    }

    private void drmuuid(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(getUniqueID());
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
    
    
    String getUniqueID() {
    UUID wideVineUuid = new UUID(-0x121074568629b532L, -0x5c37d8232ae2de13L);
    try {
        MediaDrm wvDrm = new MediaDrm(wideVineUuid);
        byte[] wideVineId = wvDrm.getPropertyByteArray(MediaDrm.PROPERTY_DEVICE_UNIQUE_ID);
        return Arrays.toString(wideVineId);
    } catch (Exception e) {
        // Inspect exception
        return null;
    }
    // Close resources with close() or release() depending on platform API
    // Use ARM on Android P platform or higher, where MediaDrm has the close() method
    }


}

