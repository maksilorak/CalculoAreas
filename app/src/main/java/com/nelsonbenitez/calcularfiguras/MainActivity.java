package com.nelsonbenitez.calcularfiguras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {

    EditText lado, base,radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lado=(EditText) findViewById(R.id.lado);
        base=(EditText) findViewById(R.id.base);
        radius=(EditText) findViewById(R.id.radio);
    }

    public void btnSeleccionado(View view) {
        boolean checked =((RadioButton) view).isChecked();

        switch (view.getId()){

            case R.id.circulo:
                radius.setVisibility(View.VISIBLE);

                break;

            case R.id.cuadro:

                break;


            case R.id.cubo:

                break;


            case R.id.triangulo:

                break;
        }

    }
}
