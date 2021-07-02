//adaptador: intermediario entre interfaz y ---- interpreta datos y los muestra
package com.example.eva1_12_clima_18550720;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*Clima[] aClimaCd={
            new Clima (R.drawable.sunny, "Chihuahua", 20.3, "despejado con viento"),
            new Clima (R.drawable.atmospher, "Delicias", 21.3, "viento"),
            new Clima (R.drawable.light_rain, "Parral", 22.3, "truenos"),
            new Clima (R.drawable.rainy, "Casas Grandes", 23.3, "nublado con viento"),
            new Clima (R.drawable.thunderstorm, "La Sierra", 24.3, "lluvia"),
            new Clima (R.drawable.tornado, "Jimenez", 25.3, "nieve"),
            new Clima (R.drawable.cloudy, "Guerrero", 26.3, "soleado"),
            new Clima (R.drawable.snow, "Cuahutemoc", 27.3, "tormenta")
    };*/
    List<Clima> lstCiudad = new ArrayList<>();
    ListView lstVwClima;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lstVwClima.findViewById(R.id.lstVwClima);
       // lstVwClima.setAdapter(new ClimaAdaptador(this,R.layout.mi_lista_clima,aClimaCd));
    }
                                            //url, nada, json (string)
    class conexionClima extends AsyncTask <String , Void, String>{
        //hacer conexion (trabajo en segundo plano)
        @Override
        protected String doInBackground(String... strings) {
            String sUrl = strings[0];
            String sResu = null;
            //httpURLconnection
            try {
                URL url = new URL(sUrl);
                //CONEXION
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                //verificar si la conexion fue exitosa
                if (httpCon.getResponseCode()==HttpURLConnection.HTTP_OK){
                    //AQUI ES como leer un archivo de texto (inputString)
                    InputStreamReader isReader = new InputStreamReader(httpCon.getInputStream());
                    //convertir info en text con BufferedReader
                    BufferedReader brDatos = new BufferedReader(isReader);
                    sResu = brDatos.readLine(); //readLine: pone texto en una sola linea sin importar su tamano
                }
                //CONEXION FIN
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;
        }

        //llenar la lista con datos
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}