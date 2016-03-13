package net.qs77.wifiassistant.app;

import android.app.Application;

/**
 * Created by xuyingqi on 16/3/12.
 */
public class WifiAssistantApp extends Application{
    private static WifiAssistantApp mInstance = null;
    public static WifiAssistantApp getInstance() {
        return mInstance;
    }
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
