package com.example.eva3_2_multitarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //THREAD
        //crear propia clase que herede el thread
        //o crear una clase anonima
        //sobreescribir metodo run()
        Thread miHilo = new Thread(){
            //EN EL METODO RUN VAN A ESTAR LAS TAREAS EN SEGUNDO PLANO
            @Override
            public void run() {
                super.run();
                for (int i = 0; i<10; i++){
                    try {
                        Thread.sleep(1000);//DETIENE LA EJECUCI'ON DEL HILO ACTUAL 10 seg, durante 1000ms pausamos instrucciones
                        Log.wtf("HILO PRINCIPAL", "i= "+(i+1)); //msm que muestra que el hilo principal sigue funcionando
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        miHilo.start(); //iniciamos el hilo de ejecucion
        MiHilote miHilote = new MiHilote();
       // miHilote.run(); //llamada a funcion dentro del hilo principal
        miHilote.start();
    }
}

class MiHilote extends Thread{ //NO ES HILO
        //EN EL METODO RUN VAN A ESTAR LAS TAREAS EN SEGUNDO PLANO
        @Override
        public void run() {
            super.run();
            for (int i = 0; i<10; i++){
                try {
                    Thread.sleep(1000);
                    Log.wtf("miHilote", "i= "+(i+1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//Ambos son multitarea para hilos:
//thread: Clase --> para crear hilos
//runnable: Interfaz -->
//ambos tienen un metodo run() para ejecutar la tarea que queremos en segundo plano

//Start(): tiene instrucciones necesarias para que el codigo en run se ejecute en segundo plano de manera independiente del principal, un programa aparte
//Run(): funcion que ejecuta exactamente lo que decimos, solamente llamada a funcion

//hilo de ejecucion dura lo que el run en ejecutarse