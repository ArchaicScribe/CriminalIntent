package edu.cnm.deepdive.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class CrimeListFragment extends Fragment {

  private Crime crime;
  private EditText titleField;
  private Button dateButton;
  private CheckBox solvedCheckBox;

//  TextView.setText(R.string.some_string);

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    crime = new Crime();
  }


  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_crime, container, false);

    titleField = (EditText) v.findViewById(R.id.crime_title);
    titleField.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count,
          int after) {
        // This space intentionally left blank
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before,
          int count) {
        crime.setTitle(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {
        // This left blank too
      }
    });

    dateButton = (Button) v.findViewById(R.id.crime_date);
    dateButton.setText(crime.getDate().toString());
    dateButton.setEnabled(false);

    solvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
    solvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView,
          boolean isChecked) {
        crime.setSolved(isChecked);
      }
    });

    return v;
  }
}