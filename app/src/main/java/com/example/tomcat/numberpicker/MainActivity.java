package com.example.tomcat.numberpicker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {
    public NumberPicker nP2, nP3;
    public TextView tv;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tv = (TextView) findViewById(R.id.textview01);

        show();

        tv = (TextView)findViewById(R.id.textview01);
        tv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               //alberDialogProcess(v);
                show();
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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void show()
    {
        final Dialog dialog = new Dialog(MainActivity.this);
        Button setBTN, cancelBTN;

        dialog.setTitle("Limit setting");
        dialog.setContentView(R.layout.dialog_numberpicker);

        setBTN = (Button) dialog.findViewById(R.id.btn_Set);
        cancelBTN = (Button) dialog.findViewById(R.id.btn_Cancel);

        final NumberPicker intPicker = (NumberPicker) dialog.findViewById(R.id.numberPicker);
        intPicker.setMinValue(36);
        intPicker.setMaxValue(42);
        intPicker.setWrapSelectorWheel(true);
        intPicker.setOnValueChangedListener((NumberPicker.OnValueChangeListener) this);

        final NumberPicker floatPicker = (NumberPicker) dialog.findViewById(R.id.numberPicker2);
        floatPicker.setMinValue(0);
        floatPicker.setMaxValue(99);
        floatPicker.setWrapSelectorWheel(true);
        floatPicker.setOnValueChangedListener((NumberPicker.OnValueChangeListener) this);

        setBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(String.valueOf(intPicker.getValue()) + "." + String.valueOf(floatPicker.getValue()));
                dialog.dismiss();
            }
        });

        cancelBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void alberDialogProcess(View v) {
        //LayoutInflater  inflater = v.findViewWithTag();
        //View dialogView = v.findViewById(R.layout.dialog_numberpicker);
        final AlertDialog.Builder aBuilder = new AlertDialog.Builder(v.getContext());
        aBuilder.setTitle("Hello !!");
        aBuilder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
