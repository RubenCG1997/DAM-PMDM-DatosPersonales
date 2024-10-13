package com.iescamas.datospersonales;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SwitchCompat swc_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swc_info = findViewById(R.id.swc_Info);
        //Foco por defecto
        findViewById(R.id.txt_info1).requestFocus();
        //Comprobamos el estado del switch
        swc_info.setOnCheckedChangeListener((compoundButton, b) -> swc_info.setChecked(b));
        //Realizamos cambio de foco mediante la pulsacion de botones
        findViewById(R.id.btn_Up).setOnClickListener(v->Arriba());
        findViewById(R.id.btn_Down).setOnClickListener(v->Abajo());
    }

    private void Arriba(){

        MostrarLog(swc_info.isChecked());

        if(findViewById(R.id.txt_info1).hasFocus()){
            findViewById(R.id.txt_info4).requestFocus();
        } else if (findViewById(R.id.txt_info2).hasFocus()) {
            findViewById(R.id.txt_info1).requestFocus();
        } else if (findViewById(R.id.txt_info3).hasFocus()) {
            findViewById(R.id.txt_info2).requestFocus();
        }
        else{
            findViewById(R.id.txt_info3).requestFocus();
        }

    }
    private void Abajo(){

        MostrarLog(swc_info.isChecked());

        if(findViewById(R.id.txt_info1).hasFocus()){
            findViewById(R.id.txt_info2).requestFocus();
        } else if (findViewById(R.id.txt_info2).hasFocus()) {
            findViewById(R.id.txt_info3).requestFocus();
        } else if (findViewById(R.id.txt_info3).hasFocus()) {
            findViewById(R.id.txt_info4).requestFocus();
        }
        else{
            findViewById(R.id.txt_info1).requestFocus();
        }
    }

    private void MostrarLog(Boolean estado){
        if(estado){
            if(findViewById(R.id.txt_info1).hasFocus()){
                Log.i("INFO","Dejo de tener el foco el nombre");
            } else if (findViewById(R.id.txt_info2).hasFocus()) {
                Log.i("INFO","Dejo de tener el foco los apellidos");
            } else if (findViewById(R.id.txt_info3).hasFocus()) {
                Log.i("INFO","Dejo de tener el foco el email");
            }
            else {
                Log.i("INFO","Dejo de tener el foco el teléfono");
            }
        }

    }


}