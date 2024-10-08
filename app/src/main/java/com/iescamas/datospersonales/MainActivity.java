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

    EditText info1,info2,info3,info4;
    ImageButton btn_down,btn_up;
    SwitchCompat swc_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info1 = findViewById(R.id.txt_info1);
        info2 = findViewById(R.id.txt_info2);
        info3 = findViewById(R.id.txt_info3);
        info4 = findViewById(R.id.txt_info4);
        btn_down = findViewById(R.id.btn_Down);
        btn_up = findViewById(R.id.btn_Up);
        swc_info = findViewById(R.id.swc_Info);


        //Foco por defecto
        info1.requestFocus();

        //Comprobamos el estado del switch
        swc_info.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                swc_info.setChecked(b);
            }
        });
        //Realizamos cambio de foco mediante la pulsacion de botones
        btn_up.setOnClickListener(v->Arriba());
        btn_down.setOnClickListener(v->Abajo());

    }

    private void Arriba(){

        MostrarLog(swc_info.isChecked());

        if(info1.hasFocus()){
            info4.requestFocus();
        } else if (info2.hasFocus()) {
            info1.requestFocus();
        } else if (info3.hasFocus()) {
            info2.requestFocus();
        }
        else{
            info3.requestFocus();
        }

    }
    private void Abajo(){

        MostrarLog(swc_info.isChecked());

        if(info1.hasFocus()){
            info2.requestFocus();
        } else if (info2.hasFocus()) {
            info3.requestFocus();
        } else if (info3.hasFocus()) {
            info4.requestFocus();
        }
        else{
            info1.requestFocus();
        }
    }

    private void MostrarLog(Boolean estado){
        if(estado){
            if(info1.hasFocus()){
                Log.i("INFO","Dejo de tener el foco el nombre");
            } else if (info2.hasFocus()) {
                Log.i("INFO","Dejo de tener el foco los apellidos");
            } else if (info3.hasFocus()) {
                Log.i("INFO","Dejo de tener el foco el email");
            }
            else {
                Log.i("INFO","Dejo de tener el foco el teléfono");
            }
        }

    }


}