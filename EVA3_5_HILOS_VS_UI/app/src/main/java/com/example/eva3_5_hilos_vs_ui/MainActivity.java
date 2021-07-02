package com.example.eva3_5_hilos_vs_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtViewmsj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtViewmsj=findViewById(R.id.txtVwMensa);
       // txtViewmsj.setText("HOLA MUNDO CRUEL");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    try {
                        Thread.sleep(1000);
                        String cade = "i = "+i;
                        i++;
                        txtViewmsj.append(cade + "\n");
                        Log.wtf("runnable", cade);
                    }catch ( InterruptedException e){
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
//hilo debe comunicar info en la interfaz grafica, habran problemas
//la unica manera de modificar es mediante el hilo principal
//mandar notificacion al hilo principal para que haga lo que se le solicita
