package com.example.fernandaochoa.listaninjaweb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Fernanda Ochoa on 19/07/2015.
 */
public class NinjasAdapter extends ArrayAdapter<Ninjas> {
    Context context;
    int layoutResourceId;
    Ninjas datos[] = null;

    public NinjasAdapter(Context context, int layoutResourceId, Ninjas[] datos) {

        super(context, layoutResourceId, datos);

        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View renglon = convertView;
        NinjasHolder holder = null;
        if (renglon == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            renglon = inflater.inflate(layoutResourceId, parent, false);

            holder = new NinjasHolder();
            holder.imagen = (ImageView) renglon.findViewById(R.id.img_foto);
            holder.nombre = (TextView) renglon.findViewById(R.id.edt_nombre);
            renglon.setTag(holder);
        } else {
            holder = (NinjasHolder) renglon.getTag();
        }
        Ninjas ninjas = datos[position];
        holder.nombre.setText(ninjas.nombre);
        holder.imagen.setImageResource(ninjas.imagen);

        return renglon;
    }

    static class NinjasHolder {
        ImageView imagen;
        TextView nombre;
    }
}
