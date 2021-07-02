package com.example.eva3_1_multitarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //linux --> proceso --> tiene un hilo de ejecuciopn principal, ciclo para que bloquee el programa cierto tiempo
        for (int i = 0; i<10; i++){
            try {
                Thread.sleep(1000);//DETIENE LA EJECUCI'ON DEL HILO ACTUAL 10 seg, durante 1000ms pausamos instrucciones
                Log.wtf("HILO PRINCIPAL", "i= "+(i+1)); //msm que muestra que el hilo principal sigue funcionando
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//hilo de ejecucion (Thread): secuencia de instrucciones que corre el programa
//hay un hilo de ejecucion principal, que controla la interfaz grafica
//cuando demandamos una funcion muy pesada, se pierde la interfaz grafica porque el hilo no funciona correctamente
//multitarea: multiples