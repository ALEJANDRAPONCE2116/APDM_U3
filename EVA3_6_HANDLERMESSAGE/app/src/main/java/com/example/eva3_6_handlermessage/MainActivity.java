package com.example.eva3_6_handlermessage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
TextView txtViewmsj;
Thread thread;
Handler handler = new Handler(){
    @Override
    //metodo que se va a encargar de interactuar con la interfaz grafica
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        //AQUI PODEMOS MODIFICA LA NTERFAZ GRAFICA
        //Trabajo ligero --> tarea intensa va a trabar interfaz grafica
        String cade = (String)msg.obj;
        int what = msg.what;
        txtViewmsj.append("el hilo = "+what+"imprime: "+cade+"\n");
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtViewmsj=findViewById(R.id.textView2);
        //txtViewmsj.setText("HOLA MUNDO CRUEL");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    try {
                        Thread.sleep(1000);
                        String cade = "i = "+i;
                        //List img;
                        i++;
                        //solicitamos mensaje
                        //poner info en el mensaje
                        Message message = handler.obtainMessage(1000, cade);
                        handler.sendMessage(message);
                        Log.wtf("runnable", cade);

                    }catch ( InterruptedException e){
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        thread = new Thread(runnable);
        thread.start();
    }
}