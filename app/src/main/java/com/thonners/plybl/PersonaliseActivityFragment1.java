package com.thonners.plybl;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * A placeholder fragment containing a simple view.
 */
public class PersonaliseActivityFragment1 extends Fragment implements SeekBar.OnSeekBarChangeListener, View.OnFocusChangeListener {

    private static final String LOG_TAG = "PersonaliseFrag1";

    private EditText etWidth;
    private EditText etHeight;
    private EditText etNoRows;
    private EditText etNoCols;
    private SeekBar height;
    private SeekBar width;
    private SeekBar no_rows;
    private SeekBar no_cols;

    public PersonaliseActivityFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_personalise_1, container, false);

        // Seek bars
        height = (SeekBar) v.findViewById(R.id.slider_height);
        width = (SeekBar) v.findViewById(R.id.slider_width);
        no_rows = (SeekBar) v.findViewById(R.id.slider_no_rows);
        no_cols = (SeekBar) v.findViewById(R.id.slider_no_columns);
        // OnSeekBarChangeListeners
        height.setOnSeekBarChangeListener(this);
        width.setOnSeekBarChangeListener(this);
        no_rows.setOnSeekBarChangeListener(this);
        no_cols.setOnSeekBarChangeListener(this);

        // Edit Texts
        etHeight = (EditText) v.findViewById(R.id.et_height);
        etWidth = (EditText) v.findViewById(R.id.et_width);
        etNoRows = (EditText) v.findViewById(R.id.et_no_rows);
        etNoCols = (EditText) v.findViewById(R.id.et_no_columns);
        // FocusListeners
        etHeight.setOnFocusChangeListener(this);
        etWidth.setOnFocusChangeListener(this);
        etNoRows.setOnFocusChangeListener(this);
        etNoCols.setOnFocusChangeListener(this);
        // Set initial values
        initialise();

        return v;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        EditText etToChange = null;
        String newEntry = "";
        switch (seekBar.getId()) {
            case R.id.slider_height:
                Log.d(LOG_TAG, "Height slider adjusted. progress = " + progress);
                etToChange = etHeight;
                double dimensionHeight = ((double) progress) / 1000.0;
                newEntry = String.format("%1$3.2f", dimensionHeight);
                break;
            case R.id.slider_width:
                Log.d(LOG_TAG, "Width slider adjusted");
                double dimensionWidth = ((double) progress) / 1000.0;
                newEntry = String.format("%1$.2f", dimensionWidth);
                etToChange = etWidth;
                break;
            case R.id.slider_no_rows:
                Log.d(LOG_TAG, "No rows slider adjusted");
                etToChange = etNoRows;
                newEntry = "" + progress;
                break;
            case R.id.slider_no_columns:
                Log.d(LOG_TAG, "No cols slider adjusted");
                etToChange = etNoCols;
                newEntry = "" + progress;
                break;
            default:
                Log.d(LOG_TAG, "Slider ID not recognised");
        }
        etToChange.setText(newEntry);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    private void initialise() {
        // Set some standard values
        // Height = 90cm
        height.setProgress(900);
        etHeight.setText("0.9");
        // Width = 1.5m
        width.setProgress(1500);
        etWidth.setText("1.5");
        // Rows = 3
        no_rows.setProgress(3);
        etNoRows.setText("3");
        // Columns = 2
        no_cols.setProgress(2);
        etNoCols.setText("2");
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        // Only interested in the EditTexts

        if (v instanceof EditText) {
            EditText et = (EditText) v;

            if (hasFocus) {
                // If the view gets focus, select all the text
                et.selectAll();
            } else {
                // Only interested in updating the slider once the view loses focus
                switch (v.getId()) {
                    case R.id.et_height:
                        double heightDouble = Double.parseDouble(et.getText().toString());
                        int newHeight = (int) (heightDouble * 1000) ;
                        height.setProgress(newHeight);
                        break;
                    case R.id.et_width:
                        double widthDouble = Double.parseDouble(et.getText().toString());
                        int newWidth = (int) (widthDouble * 1000) ;
                        width.setProgress(newWidth);
                        break;
                    case R.id.et_no_rows:
                        int newRows = Integer.parseInt(et.getText().toString()) ;
                        no_rows.setProgress(newRows);
                        break;
                    case R.id.et_no_columns:
                        int newCols = Integer.parseInt(et.getText().toString()) ;
                        no_cols.setProgress(newCols);
                        break;
                    default:
                        // Not something we're after
                        break;
                }
            }
        }
    }

}