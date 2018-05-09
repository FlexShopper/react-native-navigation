package com.reactnativenavigation.params;

import android.os.Bundle;
import android.os.Build;

public class NavigationParams {
    public static final NavigationParams EMPTY = new NavigationParams(Bundle.EMPTY);

    private static final String SCREEN_INSTANCE_ID = "screenInstanceID";
    private static final String NAVIGATOR_ID = "navigatorID";
    private static final String NAVIGATOR_EVENT_ID = "navigatorEventID";
    private static final String IS_SIMULATOR_ID = "isSimulator";

    private static final boolean IS_SIMULATOR = Build.FINGERPRINT.startsWith("generic")
            || Build.FINGERPRINT.startsWith("unknown")
            || Build.MODEL.contains("google_sdk")
            || Build.MODEL.contains("Emulator")
            || Build.MODEL.contains("Android SDK built for x86")
            || Build.MANUFACTURER.contains("Genymotion")
            || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
            || "google_sdk".equals(Build.PRODUCT);

    public String screenInstanceId;
    public String navigatorId;
    public String navigatorEventId;


    public NavigationParams(Bundle bundle) {
        screenInstanceId = bundle.getString(SCREEN_INSTANCE_ID);
        navigatorId = bundle.getString(NAVIGATOR_ID);
        navigatorEventId = bundle.getString(NAVIGATOR_EVENT_ID);
    }

    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putString(SCREEN_INSTANCE_ID, screenInstanceId);
        b.putString(NAVIGATOR_ID, navigatorId);
        b.putString(NAVIGATOR_EVENT_ID, navigatorEventId);
        b.putBoolean(IS_SIMULATOR_ID, IS_SIMULATOR);
        return b;
    }
}
