package net.qs77.wifiassistant.Activity;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import net.qs77.wifiassistant.R;
import net.qs77.wifiassistant.utils.wifi.WolfWifiManager;

import java.lang.reflect.Method;

public class MainActivity extends BaseActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                WolfWifiManager manager = new WolfWifiManager();
                manager.setWifiAp(true);
            }
        }).start();
    }

    protected void InitView() {
        setContentView(R.layout.activity_main);
    }
}
