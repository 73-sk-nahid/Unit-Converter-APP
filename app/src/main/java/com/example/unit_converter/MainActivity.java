package com.example.unit_converter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText valueInput;
    private Spinner unitFrom;
    private Spinner unitTo;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueInput = findViewById(R.id.valueInput);
        unitFrom = findViewById(R.id.unitFrom);
        unitTo = findViewById(R.id.unitTo);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        // Define the units and their conversion factors
        final String[] units = {"Centimeters", "Meters", "Inches", "Feet"};
        final double[] conversionFactors = {1.0, 0.01, 0.393701, 0.0328084};

        // Create an ArrayAdapter for the spinners
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapters for the spinners
        unitFrom.setAdapter(adapter);
        unitTo.setAdapter(adapter);

        /*convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double inputValue = Double.parseDouble(valueInput.getText().toString());
                int selectedUnitFrom = unitFrom.getSelectedItemPosition();
                int selectedUnitTo = unitTo.getSelectedItemPosition();

                // Define conversion factors
                double[] conversionFactors = {1.0, 0.01, 39.3701, 3.28084}; // Factors for Centimeters, Meters, Inches, Feet

                double conversionFactor = conversionFactors[selectedUnitTo] / conversionFactors[selectedUnitFrom];
                double result = inputValue * conversionFactor;
                resultText.setText(String.format("%.2f %s = %.2f %s", inputValue, unitFrom.getSelectedItem().toString(), result, unitTo.getSelectedItem().toString()));
                // change button color
                convertButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            }
        });*/

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValueStr = valueInput.getText().toString();
                if (inputValueStr.isEmpty()) {
                    // Handle empty input - Change the button color back to the original color
                    convertButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light)); // Change to your original color
                    resultText.setText("Please enter a value.");
                } else {
                    double inputValue = Double.parseDouble(inputValueStr);
                    int selectedUnitFrom = unitFrom.getSelectedItemPosition();
                    int selectedUnitTo = unitTo.getSelectedItemPosition();

                    double[] conversionFactors = {1.0, 0.01, 39.3701, 3.28084}; // Factors for Centimeters, Meters, Inches, Feet

                    double conversionFactor = conversionFactors[selectedUnitTo] / conversionFactors[selectedUnitFrom];
                    double result = inputValue * conversionFactor;
                    resultText.setText(String.format("%.2f %s = %.2f %s", inputValue, unitFrom.getSelectedItem().toString(), result, unitTo.getSelectedItem().toString()));
                    // Change button color to green
                    convertButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }
            }
        });

    }
}
