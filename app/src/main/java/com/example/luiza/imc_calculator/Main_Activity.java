package com.example.luiza.imc_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main_Activity extends AppCompatActivity {
    private TextView Peso;
    private TextView Altura;
    private TextView PIdeal;
    private TextView IMC;
    private TextView Info;
    private Button btn_clear;
    private Button btn_calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        Peso = (TextView) findViewById(R.id.form_peso);
        Altura = (TextView) findViewById(R.id.form_alt);
        PIdeal = (TextView) findViewById(R.id.res_pes_ideal);
        IMC = (TextView) findViewById(R.id.res_IMC);
        Info = (TextView) findViewById(R.id.res_interp);

        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_calc = (Button) findViewById(R.id.btn_calc);

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IMC.setText("");
                Info.setText("");
                PIdeal.setText("");
            }
        });

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float pes = Float.valueOf(Peso.getText().toString());
                float alt = Float.valueOf(Altura.getText().toString()) * 100;;
                float pes_ideal = (alt-100) - (((alt - pes)/4)*(5/100));
                float imc_calc = pes/(alt*alt);

                PIdeal.setText(String.valueOf(pes_ideal));
                IMC.setText(String.valueOf(imc_calc));

                if(imc_calc<25){
                    Info.setText("Peso Normal");
                }
            }
        });
    }
}
