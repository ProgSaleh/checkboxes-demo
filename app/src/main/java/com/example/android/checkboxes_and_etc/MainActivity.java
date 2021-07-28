package com.example.android.checkboxes_and_etc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // put CheckBoxes in a list to treat it easily.
    private final List<CheckBox> mCheckBoxesList = new ArrayList<>();
    // Toast message with all the added toppings.
    StringBuilder allToppings = new StringBuilder("Toppings: ");
    // Layout controls.
    private CheckBox mChocolateSyrup;
    private CheckBox mSprinkles;
    private CheckBox mCrushedNuts;
    private CheckBox mCherries;
    private CheckBox mOrioCookieCrumbles;
    private Button showToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate control views.
        inflatingControls();

        // Add CheckBoxes in the list to treat them...
        mCheckBoxesList.add(mChocolateSyrup);
        mCheckBoxesList.add(mSprinkles);
        mCheckBoxesList.add(mCrushedNuts);
        mCheckBoxesList.add(mCherries);
        mCheckBoxesList.add(mOrioCookieCrumbles);

        // For each CheckBox, if it's checked, fire addTopping(CompoundButton)
        for (CheckBox box : mCheckBoxesList) {
            box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton viewButton, boolean isChecked) {
                    if (isChecked) {
                        addTopping(viewButton);
                    }
                }
            });
        }

        // On clicking the button,
        //     if no toppings were added, toast a clear message.
        //     else toast the toppings.
        showToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allToppings.toString().equals("Toppings: ")) {
                    Toast.makeText(MainActivity.this,
                            "No toppings were specified", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            allToppings.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    } // onCreate()

    /**
     * Inflate control views of the Context.
     */
    private void inflatingControls() {
        mChocolateSyrup = findViewById(R.id.chocolate_syrup);
        mSprinkles = findViewById(R.id.sprinkles);
        mCrushedNuts = findViewById(R.id.crushed_nuts);
        mCherries = findViewById(R.id.cherries);
        mOrioCookieCrumbles = findViewById(R.id.orio_cookie_crumbles);
        showToast = findViewById(R.id.show_toast);
    }

    /**
     * Update toppings string.
     */
    private void addTopping(Button compoundBtn) {
        allToppings.append(compoundBtn.getText().toString()).append(" ");
    }
}