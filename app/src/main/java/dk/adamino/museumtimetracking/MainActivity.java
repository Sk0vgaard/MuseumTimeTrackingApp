package dk.adamino.museumtimetracking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mVolunteerName;
    private Spinner mGuildSpinner;
    private NumberPicker mNumberPicker;
    private Button mDocumentHoursButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVolunteerName = (TextView) findViewById(R.id.volunteerName);

        mGuildSpinner = (Spinner) findViewById(R.id.guildSpinner);

        mNumberPicker = (NumberPicker) findViewById(R.id.hourPicker);

        mDocumentHoursButton = (Button) findViewById(R.id.documentHoursButton);

        List<String> guilds = new ArrayList<>();
        guilds.add("Adamino Laug");
        guilds.add("Rasmus Laug");
        guilds.add("Grøn Laug");
        guilds.add("Skovgaard Laug");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, guilds);

        mGuildSpinner.setAdapter(adapter);

        setNumberPickerValues();

        mDocumentHoursButton.setOnClickListener((View v) -> {

            Toast.makeText(this, "Timer dokumenteret!", Toast.LENGTH_LONG).show();
        });



    }

    /**
     * Set the min, max and default value on the NumberPicker
     */
    private void setNumberPickerValues() {
        mNumberPicker.setMinValue(1);

        mNumberPicker.setMaxValue(20);

        mNumberPicker.setValue(8);
    }
}
