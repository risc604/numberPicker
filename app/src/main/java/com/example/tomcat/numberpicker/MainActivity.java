package com.example.tomcat.numberpicker;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity
{
    public NumberPicker nP2, nP3;
    public TextView     tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textview01);
        tv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                alberDialogProcess(v);
            }
        });

        /*
        numberPicker = (NumberPicker) findViewById(R.id.numberPicker01);
        numberPicker.setMaxValue(40);
        numberPicker.setMinValue(35);
        numberPicker.setValue(36);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {
                tv.setText("pick number is " + format("%02d", newVal));
            }
        });
        */

    }

    public void alberDialogProcess(View v)
    {
        LayoutInflater  inflater = v.;
        View dialogView = v.findViewById(R.layout.dialog_numberpicker);
        final AlertDialog.Builder aBuilder = new AlertDialog.Builder(v.getContext());
        aBuilder.setTitle("Hello !!");
        aBuilder.setNegativeButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        }).show();
    }
}
