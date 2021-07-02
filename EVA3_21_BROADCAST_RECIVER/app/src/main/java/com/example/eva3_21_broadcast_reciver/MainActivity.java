package com.example.eva3_21_broadcast_reciver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwVisualizar;
    Intent inServicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwVisualizar=findViewById(R.id.txtVwVisualizar);
        inServicio= new Intent(this, inServicio.getClass());

        BroadcastReceiver broadcastReceiver=new miBroadcast();
        //filtro:
        IntentFilter intentFilter = new IntentFilter("MI_MENSAJE");
        registerReceiver(broadcastReceiver, intentFilter);
    }
    public void iniciar (View view){
        startService(inServicio);
    }

    public void detener (View view){
        stopService(inServicio);
    }

    //PROCESO DE COMUNICARNOS CON ELS ERVICIO
    class miBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //leer los mensajes del servicio
            txtVwVisualizar.append(intent.getStringExtra("MENSAJE +\n"));
        }
    }
}