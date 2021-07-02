package com.example.eva3_3_handler_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
ImageView imgMonaco, imgSimionato, imgCorelli;
Thread tBanner;
int cont = 0;

//A TRAVES DE UN HANDLER MESSAGE INTERACTUAR CON LA UI
    Handler handler = new Handler() {
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
      //  Toast.makeText(getApplicationContext(),"funciona", Toast.LENGTH_SHORT).show();
        //INTERACTUAR CON LA UI
        int imagen;
        if (cont==0){
            imagen=R.drawable.delmonaco;
            cont++;
        }else if (cont==1){
            imagen=R.drawable.franco1;
            cont++;
        }else{
            imagen=R.drawable.simionato;
            cont=0;
        }
        imgMonaco.setImageResource(imagen);
        //Log.wtf("UOPS" + "\n");
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgMonaco=findViewById(R.id.imgMonaco);
        tBanner=new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(1000);

                        //SOLICITAR MENSAJE
                        Message message = handler.obtainMessage(1000);
                        handler.sendMessage(message);
                    }
                    //ENVIAR MENSAJE
                    catch (InterruptedException e){
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        tBanner.start();;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tBanner.interrupt();
    }
}