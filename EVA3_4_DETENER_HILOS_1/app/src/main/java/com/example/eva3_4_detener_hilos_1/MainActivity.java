package com.example.eva3_4_detener_hilos_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    //-----------HILO DE EJECUCION QUE NO SE DETENGA------------//
    Thread infinito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hilo propio que no se detiene
         infinito = new Thread(){
            @Override
            public void run() {
                super.run();
                int i=0;
                while (true) { //permite ejecutar tarea siempre
                    Log.wtf("Hilo infinito", "i=" + i);
                    try {
                        Thread.sleep(500); //cuando hilo esta dormido se genera la excepcion y no se detiene porque
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        break;
                    }
                    i++;
                }
            }
        };
        infinito.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        infinito.interrupt();
    }
}
