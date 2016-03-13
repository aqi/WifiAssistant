package net.qs77.wifiassistant.utils.wifi;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.util.Log;

import net.qs77.wifiassistant.app.WifiAssistantApp;

import java.lang.reflect.Method;

/**
 * Created by xuyingqi on 16/3/13.
 */
public class WolfWifiManager {
    private static final String TAG = WolfWifiManager.class.getSimpleName();
    private WifiManager mWifiManager = null;
    public WolfWifiManager() {
        mWifiManager = (WifiManager) WifiAssistantApp.getInstance().getSystemService(Context.WIFI_SERVICE);
    }

    public Boolean getApState() {
        Boolean bApState = Boolean.FALSE;

        try {
            Method method = mWifiManager.getClass().getMethod("isWifiApEnabled");
            bApState = (Boolean)method.invoke(mWifiManager);
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            bApState = false;
            e.printStackTrace();
        }
        return bApState;
    }

    public WifiConfiguration getApConfiguration() {
        WifiConfiguration apConfig = new WifiConfiguration();

        return apConfig;
    }

    public void setWifiAp(Boolean bOpen) {
        if (bOpen) {
            if (getApState()) {
                return;
            }
            mWifiManager.setWifiEnabled(false);
        }

        try {
            Method method = mWifiManager.getClass().getMethod(
                    "setWifiApEnabled", WifiConfiguration.class, Boolean.TYPE);
            method.invoke(mWifiManager, null, bOpen);

        } catch (Exception e) {
            Log.e(TAG, e.toString());
            e.printStackTrace();
        }
    }

}
