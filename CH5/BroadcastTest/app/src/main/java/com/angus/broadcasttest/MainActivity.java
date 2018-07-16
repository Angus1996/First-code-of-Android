package com.angus.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;

    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*首先构建了一个Intent对象， 并把要发送的广播的值传入*/
                Intent intent = new Intent();
                intent.setAction("BROADCAST_ACTION");
                /*调用Context的sendBroadcast()方法将广播发送出去，这样所有监听com.angus.broadcasttest.MY_BROADCAST这条广播的广播接收器就会收到消息*/
                /*sendBroadcast(intent);*/
                //sendOrderedBroadcast()方法接收两个参数，第一个参数仍然是Intent,第二个参数是一个与权限相关的字符串
                sendOrderedBroadcast(intent, null);
            }
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver =  new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

     class NetworkChangeReceiver extends BroadcastReceiver {
         @Override
         public void onReceive(Context context, Intent intent) {
             /*Toast.makeText(context, "network changes!", Toast.LENGTH_SHORT).show();*/
             ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
             NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
             if (networkInfo != null && networkInfo.isAvailable()) {
                 Toast.makeText(context, "network is availabel", Toast.LENGTH_SHORT).show();
             } else {
                 Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
             }
         }
     }
}
