package com.example.eva3_21_broadcast_reciver_b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtVwVisualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwVisualizar=findViewById(R.id.txtVwVisualizar);
        BroadcastReceiver broadcastReceiver = new myBroadcast();
        IntentFilter intentFilter = new IntentFilter("Mi mensaje");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    class myBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            txtVwVisualizar.append(intent.getStringExtra("Mensaje")+"\n");
        }
    }
}