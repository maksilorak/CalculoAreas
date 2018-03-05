package com.nelsonbenitez.calcularfiguras;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    Double area, perimetro;
    EditText side, radius, base, altura;
    TextView result, valorLado, valorBase,valorAltura,valorRadio;
    String seleccion;
    RadioButton preseleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preseleccionado=(RadioButton) findViewById(R.id.cuadro);
        preseleccionado.setChecked(true);
        seleccion="cuadrado";
        radius=(EditText) findViewById(R.id.radio);
        side=(EditText) findViewById(R.id.lado);
        side.setText("1.00");
        base=(EditText) findViewById(R.id.base);
        altura= (EditText) findViewById(R.id.altura);
        result=(TextView) findViewById(R.id.resultado);
        valorLado=(TextView) findViewById(R.id.val_Lado);
        valorRadio=(TextView) findViewById(R.id.val_radio);
        valorAltura=(TextView) findViewById(R.id.val_altura);
        valorBase=(TextView) findViewById(R.id.val_base);
        result.setEnabled(false);



    }

    public void btnSeleccionado(View btn_selected) {

        boolean checked =((RadioButton) btn_selected).isChecked();

        switch (btn_selected.getId()){

            case R.id.circulo:
                radius.setVisibility(btn_selected.VISIBLE);
                side.setVisibility(btn_selected.GONE);
                base.setVisibility(btn_selected.GONE);
                altura.setVisibility(btn_selected.GONE);
                valorBase.setVisibility(btn_selected.GONE);
                valorAltura.setVisibility(btn_selected.GONE);
                valorLado.setVisibility(btn_selected.GONE);
                valorRadio.setVisibility(btn_selected.VISIBLE);
                if (checked){seleccion="Circulo";}
                break;

            case R.id.cuadro:
                side.setVisibility(btn_selected.VISIBLE);
                radius.setVisibility(btn_selected.GONE);
                base.setVisibility(btn_selected.GONE);
                altura.setVisibility(btn_selected.GONE);
                valorBase.setVisibility(btn_selected.GONE);
                valorAltura.setVisibility(btn_selected.GONE);
                valorLado.setVisibility(btn_selected.VISIBLE);
                valorRadio.setVisibility(btn_selected.GONE);
                if (checked){seleccion="cuadrado";}
                break;


            case R.id.triangulo:
                side.setVisibility(btn_selected.GONE);
                base.setVisibility(btn_selected.VISIBLE);
                radius.setVisibility(btn_selected.GONE);
                altura.setVisibility(btn_selected.VISIBLE);
                valorBase.setVisibility(btn_selected.VISIBLE);
                valorAltura.setVisibility(btn_selected.VISIBLE);
                valorLado.setVisibility(btn_selected.GONE);
                valorRadio.setVisibility(btn_selected.GONE);
                if (checked){seleccion="Triangulo";}
                break;

            case R.id.cubo:

                side.setVisibility(btn_selected.VISIBLE);
                base.setVisibility(btn_selected.GONE);
                radius.setVisibility(btn_selected.GONE);
                altura.setVisibility(btn_selected.GONE);
                valorBase.setVisibility(btn_selected.GONE);
                valorAltura.setVisibility(btn_selected.GONE);
                valorLado.setVisibility(btn_selected.VISIBLE);
                valorRadio.setVisibility(btn_selected.GONE);
                if (checked){seleccion="Cubo";}
                break;
        }

    }




    public void btnCalcular(View view) {
    

        String otros_datos="";


            switch (seleccion){
                case "Circulo":

                    if (valorRadioCorrecto())
                    {
                        Double radio=Double.valueOf(radius.getText().toString());
                        area=Math.pow(radio,2)*Math.PI;
                        perimetro=2*radio*Math.PI;
                        result.setVisibility(view.VISIBLE);
                        otros_datos= "\n\nÁrea: "+String.format("%.3f",area)+"\n\n"
                                + "Perímetro: "+ String.format("%.3f",perimetro);
                    }

                    else{otros_datos="Favor asignar un valor al radio";}

                    break;

                case "cuadrado":

                    if (valorLadoCorrecto())
                    {
                        Double lado= Double.valueOf(side.getText().toString());
                        area=Math.pow(lado,2);
                        perimetro=4*lado;
                        otros_datos= "\n\nÁrea: "+String.format("%.3f",area)+"\n\n"
                                + "Perímetro: "+ String.format("%.3f",perimetro);
                        result.setVisibility(view.VISIBLE);

                    }else{otros_datos="Favor asignar un valor al lado";}
                    break;


                case "Triangulo":

                    if (ladosCorrectos())
                    {
                        Double basee= Double.valueOf(base.getText().toString());
                        Double alto= Double.valueOf(altura.getText().toString());
                        Double hipotenusa;
                        area=0.5*basee*alto;
                        hipotenusa= Math.sqrt(Math.pow(basee,2)+Math.pow(alto,2));
                        perimetro=basee+alto+hipotenusa;
                        otros_datos= "\n\nÁrea: "+String.format("%.3f",area)+"\n\n"
                                + "Perímetro: "+ String.format("%.3f",perimetro);
                        result.setVisibility(view.VISIBLE);
                    }else{otros_datos="Favor asignar un valor a la base y a la altura";}
                    break;

                case "Cubo":
                    if (valorLadoCorrecto())
                    {
                        Double ldo= Double.valueOf(side.getText().toString());
                        Double volumen =Math.pow(ldo,3);
                        area=6*Math.pow(ldo,2);
                        perimetro=12*ldo; //cubo de lado ldo

                        otros_datos= "\n\nÁrea: "+String.format("%.3f",area)+"\n\n"
                                + "Perímetro: "+ String.format("%.3f",perimetro)+"\n\n"
                                + "Volumen: " + String.format("%.3f",volumen);
                        result.setVisibility(view.VISIBLE);

                    }else{otros_datos="Favor asignar un valor al lado";}
                    break;
            }

        result.setText(otros_datos);
        result.setEnabled(true);

    }

    private boolean ladosCorrectos() {
        if (base.length()!=0 && altura.length()!=0){return true;}
        else return false;
    }

    private boolean valorLadoCorrecto() {
        if (side.length()!=0){return true;}
        else return false;
    }

    private boolean valorRadioCorrecto() {
        if (radius.length()!=0){return true;}
        else return false;
    }
}
