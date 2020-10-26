package com.kh.reservetime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Chronometer chrono;
    Button btnStart, btnFinish;
    RadioGroup rGroup;
    RadioButton rdoDate, rdoTime;
    FrameLayout innerLayout;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView txtResult;

    View.OnClickListener rdoLis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == rdoDate) {
                datePicker.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            } else if (v == rdoTime) {
                datePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        setListener();
    }

    private void setListener() {
        btnStart.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
        rdoDate.setOnClickListener(rdoLis);
        rdoTime.setOnClickListener(rdoLis);
    }

    private void findview() {
        chrono      = findViewById(R.id.chrono);
        btnStart    = findViewById(R.id.btnStart);
        btnFinish   = findViewById(R.id.btnFinish);
        rGroup      = findViewById(R.id.rGroup);
        innerLayout = findViewById(R.id.innerLayout);
        rdoDate     = findViewById(R.id.rdoDate);
        rdoTime     = findViewById(R.id.rdoTime);
        datePicker  = findViewById(R.id.datePicker);
        timePicker  = findViewById(R.id.timePicker);
        txtResult   = findViewById(R.id.txtResult);
    }

    @Override
    public void onClick(View v) {
        if (v == btnStart) {
            chrono.start();
            rGroup.setVisibility(View.VISIBLE);
            innerLayout.setVisibility(View.VISIBLE);
        } else if (v == btnFinish) {
            chrono.stop();
            //Date get
            int year = datePicker.getYear();
            int month = datePicker.getMonth() + 1;
            int day = datePicker.getDayOfMonth();
            //Time get
            int hour = timePicker.getCurrentHour();
            int minute = timePicker.getCurrentMinute();
            String str = year +"-"+ month +"-"+ day +
                    " | "+ hour +":"+ minute +" -> 예약됨";
            txtResult.setText(str);
            btnStart.setEnabled(false);
        }
    }

}//class