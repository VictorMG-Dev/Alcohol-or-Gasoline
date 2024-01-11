package com.example.lcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText editPriceAlcohol, editPriceGasoline, editAutonomyAlcohol, editAutonomyGasoline;
    private TextView textResultado;

    private Button btnCalculated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPriceAlcohol = findViewById(R.id.editPriceAlcohol);
        editPriceGasoline = findViewById(R.id.editPriceGasoline);
        textResultado = findViewById(R.id.textResultado);
        editAutonomyAlcohol = findViewById(R.id.editAutonomyAlcohol);
        editAutonomyGasoline = findViewById(R.id.editAutonomyGasoline);
        btnCalculated = findViewById(R.id.btnCalculated);

        eventCalculatedPrice();
    }

    public void eventCalculatedPrice() {

        btnCalculated.setOnClickListener(view -> {

            String priceAlcohol = editPriceAlcohol.getText().toString();
            String priceGasoline = editPriceGasoline.getText().toString();
            String autonomyAlcohol = editAutonomyAlcohol.getText().toString();
            String autonomyGasoline = editAutonomyGasoline.getText().toString();

            Boolean camposValidados = validarCampos(priceAlcohol, priceGasoline, autonomyAlcohol, autonomyGasoline);
            if (camposValidados) {

                Double rendimentoAlcool = Double.parseDouble(autonomyAlcohol);
                Double rendimentoGasolina = Double.parseDouble(autonomyGasoline);

                Double autonomia = rendimentoAlcool / rendimentoGasolina;

                Double valorAlcool = Double.parseDouble(priceAlcohol);
                Double valorGasolina = Double.parseDouble(priceGasoline);

                Double resultado = valorAlcool / valorGasolina;

                if (resultado >= autonomia) {
                    textResultado.setText("Melhor utilizar Gasolina");
                } else {
                    textResultado.setText("Melhor utilizar Álcool");
                }
            } else {
                textResultado.setText("Preencha os preços primeiro!");
            }
        });

    }

    public Boolean validarCampos(String pAlcool, String pGasolina, String pautonomyAlcohol, String pautonomyGasoline) {

        Boolean camposValidados = true;


        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;

        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        } else if (pautonomyAlcohol == null || pautonomyAlcohol.equals("")) {
            camposValidados = false;
        } else if (pautonomyGasoline == null || pautonomyGasoline.equals("")) {
            camposValidados = false;

        }
        return camposValidados;

    }

}
