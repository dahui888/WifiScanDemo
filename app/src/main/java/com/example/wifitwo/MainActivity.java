package com.example.wifitwo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.thanosfisherman.wifiutils.WifiUtils;

public class MainActivity extends AppCompatActivity {
    //  url:    https://github.com/ThanosFisherman/WifiUtils.git
    String wifiName1 = "mindor-AP-2019-07-03";
    String wifiPassword1 = "123456789";
    String wifiName2 = "DESKTOP-3PNAKUO 7694";
    String wifiPassword2 = "9783V&h3";
    String wifiName3 = "wanye_2021";
    String wifiPassword3 = "123456789";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 555);
            return;

        }


        Button btn_open = findViewById(R.id.btn_open);
        Button btn_close = findViewById(R.id.btn_close);
        Button btn_scan = findViewById(R.id.btn_scan);
        Button btn_wifiConnect = findViewById(R.id.btn_wifiConnect);
        Button btn_cancelWifiConnect = findViewById(R.id.btn_cancelWifiConnect);
        Button btn_wpsWifiConnect = findViewById(R.id.btn_wpsWifiConnect);
        Button btn_disConnectWifiConnect = findViewById(R.id.btn_disConnectWifiConnect);
        Button btn_disConnectDeleteWifiConnect = findViewById(R.id.btn_disConnectDeleteWifiConnect);


        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ConnectionManager(MainActivity.this).openWithWAP();

            }
        });


        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ConnectionManager(MainActivity.this).closeWithWAP();

            }
        });


        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ConnectionManager(MainActivity.this).scanWithWAP();

            }
        });

        btn_wifiConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ConnectionManager(MainActivity.this).connectWifiWithWAP(wifiName3, wifiPassword3);

            }
        });

        btn_cancelWifiConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ConnectionManager(MainActivity.this).connectWifiWithWAP(wifiName3, wifiPassword3);

            }
        });

        btn_wpsWifiConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这个bssid是扫描扫出来的，跟ssid对应 ，ssid其实就是wifi名称
                new ConnectionManager(MainActivity.this).wpsConnectWithWAP("54:a7:03:dd:9e:96", wifiPassword3);

            }
        });

        btn_disConnectWifiConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ConnectionManager(MainActivity.this).disConnectWithWAP();

            }
        });

        btn_disConnectDeleteWifiConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ConnectionManager(MainActivity.this).disConnectDeleteWithWAP(wifiName3);

            }
        });

    }
}