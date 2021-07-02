package com.example.eva3_10_looper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView textView;
Handler handler = new Handler(Looper.getMainLooper()){
    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        textView.append((String)msg.obj+"");
    }
};
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        for (int i=0; i<20; i++){
            try {
                Thread.sleep(1000);
                Message message = handler.obtainMessage(100, "i = "+ i);
                handler.sendMessage(message);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.txtVwMostrar);
    }
}