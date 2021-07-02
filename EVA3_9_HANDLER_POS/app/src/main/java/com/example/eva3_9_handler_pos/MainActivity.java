package com.example.eva3_9_handler_pos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
//------TRABAJANDO CON RUNNABLES-----
public class MainActivity extends AppCompatActivity {
TextView txtVwMostrar;
Handler handler = new Handler();

//trabajo pesado en segundo plano
Runnable background = new Runnable() {
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                handler.post(foreground);
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
    }
}

};
//se anexa en el hilo principal y se comunica a traves del hilo principal
Runnable foreground = new Runnable() {
    @Override
    public void run() {
        txtVwMostrar.append("HOLA MUNDO \n");
    }
} ;
Thread thread;
//trabaja con la UI
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMostrar=findViewById(R.id.txtVwMostrar);
        thread = new Thread(background);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}

//en vez de poner el codigo en el hander message usamos runnables, en las dos practicas anteriores