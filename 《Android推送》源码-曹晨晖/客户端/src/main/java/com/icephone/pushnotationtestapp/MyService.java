package com.icephone.pushnotationtestapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class MyService extends Service {
    private MyThread thread = null;
    private Socket socket = null;
    public static String tag = "MyService";
    private BufferedWriter bWriter = null;
    private OutputStreamWriter outs = null;
    private InputStreamReader ins = null;
    private BufferedReader bReader = null;
    private boolean isHeartBeatStop = false;
    //private IBinder stopBinder = new MyServiceBind();
    Timer heartBeatTimer = new Timer();
    TimerTask heartBeatTask = new TimerTask() {
        @Override
        public void run() {
            if (socket != null) {
                try {
                    if(!isHeartBeatStop) {
                        Log.e(tag, "客户端心跳");
                        bWriter.write("HEARTBEAT");
                        bWriter.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(tag, "开启推送服务");
        thread = new MyThread();
        thread.start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // ((MyServiceBind) stopBinder).stopPushService();
        Log.i(tag, "ondestroy 服务关闭");
        if(bWriter == null){
        return ;
        }
        try {
            bWriter.write("CLIENT_DISCONNECT");
            bWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        IOUtils.closeQuietly(socket);
        heartBeatTimer.cancel();
        this.stopSelf();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //return stopBinder;
        return null;
    }

    private void sendMessageToServer(String message){
        isHeartBeatStop = true;
        try {
            bWriter.write(message);
            bWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        isHeartBeatStop = false;
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                String tempStr = "";
                socket = new Socket("192.168.252.1", 9900);
                ins = new InputStreamReader(socket.getInputStream());
                bReader = new BufferedReader(ins);
                outs = new OutputStreamWriter(socket.getOutputStream());
                bWriter = new BufferedWriter(outs);
                while ((tempStr = bReader.readLine()) != null) {
                    String newStr = "";
                    Log.e(tag,tempStr);
                    if (tempStr.startsWith("CONNECT")) {
                        Log.e(tag,"连接成功");
                        sendMessageToServer("CLIENTLOGIN" + MainActivity.uuid + "\r\n");
                        heartBeatTimer.schedule(heartBeatTask, 0, 3 * 1000);
                    } else if (tempStr.startsWith("MESSAGE")) {
                        Intent intent = new Intent(MyService.this, MainActivity.class);
                        PendingIntent pendIntent = PendingIntent.getActivity(MyService.this, 0, intent, 0);
                        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        Notification pushNotify = new Notification();
                        pushNotify.icon = R.drawable.ic_launcher;
                        pushNotify.when = System.currentTimeMillis();
                        pushNotify.tickerText = tempStr.replaceFirst("MESSAGE", "");
                        pushNotify.flags = Notification.FLAG_AUTO_CANCEL;
                        pushNotify.defaults = Notification.DEFAULT_ALL;
                        pushNotify.setLatestEventInfo(MyService.this, "点击查看", tempStr.replaceFirst("MESSAGE", ""), pendIntent);
                        notificationManager.notify(0, pushNotify);
                    } else if (tempStr.startsWith("SERVER_DISCONNECT")) {
                        break;
                    }
                }
            } catch (SocketException e) {
                System.out.println("服务器连接断开");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(bWriter);
                IOUtils.closeQuietly(outs);
                IOUtils.closeQuietly(ins);
                IOUtils.closeQuietly(bReader);
                IOUtils.closeQuietly(socket);
            }
            Log.e(tag, "关闭推送服务");
            heartBeatTimer.cancel();
            MyService.this.stopSelf();
        }
    }


//    class MyServiceBind extends Binder {
//        public void stopPushService() {
//            if (socket != null) {
//                BufferedWriter bWriter = null;
//                OutputStreamWriter outs = null;
//                try {
//                    outs = new OutputStreamWriter(socket.getOutputStream());
//                    bWriter = new BufferedWriter(outs);
//                    bWriter.write("CLIENT_DISCONNECT");
//                    bWriter.flush();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    IOUtils.closeQuietly(bWriter);
//                    IOUtils.closeQuietly(outs);
//                }
//
//            }
//        }
//
//    }
}
