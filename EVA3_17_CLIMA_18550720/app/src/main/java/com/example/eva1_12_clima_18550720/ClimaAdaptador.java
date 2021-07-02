package com.example.eva1_12_clima_18550720;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ClimaAdaptador extends ArrayAdapter <Clima> {
    private Context context;
    private int layout;
    private Clima [] cCiudades;

    public ClimaAdaptador(@NonNull Context context, int resource, @NonNull Clima[] objects) {
        super(context, resource, objects);
        this.context=context;
        this.layout=resource;
        this.cCiudades=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //FILA: NO EXISTA
        if (convertView == null){
        convertView=((Activity)context).getLayoutInflater().inflate(layout, parent, false); //creo todos los componentes y los pongo en el convertView
        }
        //FILA:EXISTA
        //else{ }
        ImageView imgVWClima;
        TextView txtVwCd,txtVwTemp, txtVWDesc;

        //vincularlas para poder usarlas
        imgVWClima=convertView.findViewById(R.id.imgVwClima);
        txtVwCd=convertView.findViewById(R.id.txtVwCd);
        txtVWDesc=convertView.findViewById(R.id.txtVwDesc);
        txtVwTemp=convertView.findViewById(R.id.txtVwtemp);

        //llenar los widgets con datos (arreglo CCiudades)
        imgVWClima.setImageResource(cCiudades[position].getImagen());
        txtVwCd.setText(cCiudades[position].getCiudad());
        txtVwTemp.setText(cCiudades[position].getTemp()+"°C");
        txtVWDesc.setText(cCiudades[position].getDesc());

        return convertView;


    }
}
