package com.nelsonbenitez.calcularfiguras;

import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    Double area, perimetro;
    EditText side, radius, base, altura;
    TextView result;
    String seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radius=(EditText) findViewById(R.id.radio);
        side=(EditText) findViewById(R.id.lado);
        base=(EditText) findViewById(R.id.base);
        altura= (EditText) findViewById(R.id.altura);
        result=(TextView) findViewById(R.id.resultado);
        result.setEnabled(false);



    }

    public void btnSeleccionado(View view) {
        boolean checked =((RadioButton) view).isChecked();

        switch (view.getId()){

            case R.id.circulo:
                radius.setVisibility(view.VISIBLE);
                side.setVisibility(view.GONE);
                base.setVisibility(view.GONE);
                altura.setVisibility(view.GONE);
                if (checked){seleccion="Circulo";}
                break;

            case R.id.cuadro:
                side.setVisibility(view.VISIBLE);
                radius.setVisibility(view.GONE);
                base.setVisibility(view.GONE);
                altura.setVisibility(view.GONE);
                if (checked){seleccion="cuadrado";}
                break;


            case R.id.triangulo:
                side.setVisibility(view.GONE);
                base.setVisibility(view.VISIBLE);
                radius.setVisibility(view.GONE);
                altura.setVisibility(view.VISIBLE);
                if (checked){seleccion="Triangulo";}
                break;

            case R.id.cubo:

                side.setVisibility(view.VISIBLE);
                base.setVisibility(view.GONE);
                radius.setVisibility(view.GONE);
                altura.setVisibility(view.GONE);
                if (checked){seleccion="Cubo";}
                break;
        }

    }


    public void btnCalcular(View view) {

        String otros_datos="";

        switch (seleccion){
            case "Circulo":
                Double radio=Double.valueOf(radius.getText().toString());
                area=Math.pow(radio,2)*Math.PI;
                perimetro=2*radio*Math.PI;
                result.setVisibility(view.VISIBLE);
                otros_datos= "\n\nEl area del círculo es: "+String.format("%.3f",area)+"\n\n"
                                + "El perímetro de este circulo es: "+ String.format("%.3f",perimetro);

                break;

            case "cuadrado":
                Double lado= Double.valueOf(side.getText().toString());
                area=Math.pow(lado,2);
                perimetro=4*lado;
                otros_datos= "\n\nEl area del cuadrado es: "+String.format("%.3f",area)+"\n\n"
                        + "El perímetro de este cuadrado es: "+ String.format("%.3f",perimetro);
                result.setVisibility(view.VISIBLE);
                break;


            case "Triangulo":
                Double basee= Double.valueOf(base.getText().toString());
                Double alto= Double.valueOf(altura.getText().toString());
                Double hipotenusa;
                area=0.5*basee*alto;
                hipotenusa= Math.sqrt(Math.pow(basee,2)+Math.pow(alto,2));
                perimetro=basee+alto+hipotenusa;
                otros_datos= "\n\nEl area del triángulo es: "+String.format("%.3f",area)+"\n\n"
                        + "El perímetro de este triángulo es: "+ String.format("%.3f",perimetro);
                result.setVisibility(view.VISIBLE);
                break;

            case "Cubo":
                Double ldo= Double.valueOf(side.getText().toString());
                Double volumen =Math.pow(ldo,3);
                area=6*Math.pow(ldo,2);
                perimetro=12*ldo; //cubo de lado ldo

                otros_datos= "\n\nEl area del cubo es: "+String.format("%.3f",area)+"\n\n"
                        + "El perímetro de este cubo es: "+ String.format("%.3f",perimetro)+"\n\n"
                        + "El Volumen de este cubo es: " + String.format("%.3f",volumen);
                result.setVisibility(view.VISIBLE);
                break;
        }

        result.setText(otros_datos);
        result.setEnabled(true);

    }
}
