package dk.adamino.museumtimetracking.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import dk.adamino.museumtimetracking.R;
import dk.adamino.museumtimetracking.be.Guild;
import dk.adamino.museumtimetracking.be.VolunteerWork;
import dk.adamino.museumtimetracking.gui.model.GuildModel;

public class MainActivity extends AppCompatActivity {

    private TextView mVolunteerName;
    private Spinner mGuildSpinner;
    private NumberPicker mNumberPicker;
    private Button mDocumentHoursButton;

    private GuildModel mGuildModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGuildModel = new GuildModel();

        mVolunteerName = (TextView) findViewById(R.id.volunteerName);

        mGuildSpinner = (Spinner) findViewById(R.id.guildSpinner);

        mNumberPicker = (NumberPicker) findViewById(R.id.hourPicker);

        mDocumentHoursButton = (Button) findViewById(R.id.documentHoursButton);


        ArrayAdapter<Guild> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, mGuildModel.getActiveGuildsFromDB());


        mGuildSpinner.setAdapter(adapter);

        setNumberPickerValues();

        mDocumentHoursButton.setOnClickListener((View v) -> {

            int id = 134; //Adam Hansen
            String guild = mGuildSpinner.getSelectedItem().toString();
            Date date = new Date();
            int hours = mNumberPicker.getValue();
            VolunteerWork newWork = new VolunteerWork(id, guild, date, hours);

            boolean documented = mGuildModel.documentVolunteerHours(newWork);

            if (documented) {
                Toast.makeText(this, "Dokumenteret!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "SHEIT!", Toast.LENGTH_LONG).show();
            }

//            Toast.makeText(this, "Timer dokumenteret!", Toast.LENGTH_LONG).show();


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
