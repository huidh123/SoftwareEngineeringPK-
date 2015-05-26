package com.icephone.pushnotationtestapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    public static String uuid;
    private Button btn_start_server;
    private Button btn_stop_server;
    private Button btn_change_uuid;

  //  private MyService.MyServiceBind myServiceBind;
    static String tag = "MainActivit";

//    private ServiceConnection serviceConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            myServiceBind = (MyService.MyServiceBind) service;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            myServiceBind = null;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uuid = Utils.getUuid(MainActivity.this);

        btn_start_server = (Button) findViewById(R.id.start_server);
        btn_start_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
//                bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
                startService(intent);
            }
        });
        btn_stop_server = (Button) findViewById(R.id.stop_sevrer);
        btn_stop_server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                unbindService(serviceConnection);
//                if(myServiceBind!=null){
//                    myServiceBind.stopPushService();
//                }
                Intent intent = new Intent(MainActivity.this,MyService.class);
                stopService(intent);
            }
        });

        btn_change_uuid = (Button) findViewById(R.id.btn_change_uuid);
        btn_change_uuid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uuid = Utils.changeUuid(MainActivity.this);
            }
        });
    }

}
