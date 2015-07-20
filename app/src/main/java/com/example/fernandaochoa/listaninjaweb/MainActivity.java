package com.example.fernandaochoa.listaninjaweb;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Declaro mi array
        Ninjas ninjas_datos[] = new Ninjas[]{
                new Ninjas(R.mipmap.ic_andy, "Javier"),
                new Ninjas(R.mipmap.ic_andy, "Luisa"),
                new Ninjas(R.mipmap.ic_andy, "Salguero"),
                new Ninjas(R.mipmap.ic_andy, "Rosita"),
                new Ninjas(R.mipmap.ic_andy, "Anna"),
                new Ninjas(R.mipmap.ic_andy, "Melvin"),
                new Ninjas(R.mipmap.ic_andy, "Lily"),
                new Ninjas(R.mipmap.ic_andy, "Fernanda")
        };

        //Paso los parametros, contexto (this), el diseño (Renglon), fuente de datos (ninja_datos)
        NinjasAdapter adapter = new NinjasAdapter(this, R.layout.renglon, ninjas_datos);
        ls = (ListView) findViewById(R.id.listView);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                TextView v = (TextView) arg1.findViewById(R.id.edt_nombre);
                Toast.makeText(getApplicationContext(), v.getText(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
