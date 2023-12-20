package com.example.theodore_reangpusri_lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private TextView displayText;
    private EditText nameEditText;
    private Button saveNameButton;
    private TextView dynamicText;
    private TextView moodMessage;

    private ImageButton sadButton;
    private ImageButton happyButton;
    private ImageButton excitedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        displayText = findViewById(R.id.displayText);
        nameEditText = findViewById(R.id.nameEditText);
        saveNameButton = findViewById(R.id.saveNameButton);
        dynamicText = findViewById(R.id.dynamicText);
        moodMessage = findViewById(R.id.moodMessage);  // Initialize moodMessage

        sadButton = findViewById(R.id.sadButton);
        happyButton = findViewById(R.id.happyButton);
        excitedButton = findViewById(R.id.excitedButton);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                displayText.setVisibility(View.VISIBLE);
            } else {
                displayText.setVisibility(View.INVISIBLE);
            }
        });

        saveNameButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            if (!name.isEmpty()) {
                String greeting = "Hej " + name + "! Hur mår du idag? Välj någon av de 3 smileysarna";
                dynamicText.setText(greeting);
                dynamicText.setVisibility(View.VISIBLE);
            }
        });

        sadButton.setOnClickListener(v -> displayMoodMessage("ledsen"));
        happyButton.setOnClickListener(v -> displayMoodMessage("glad"));
        excitedButton.setOnClickListener(v -> displayMoodMessage("exalterad"));
    }

    private void displayMoodMessage(String mood) {
        String moodMessageText = "Du är " + mood + " idag";
        moodMessage.setText(moodMessageText);
        moodMessage.setVisibility(View.VISIBLE);
    }
}
