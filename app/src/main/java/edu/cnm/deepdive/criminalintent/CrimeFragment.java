package edu.cnm.deepdive.criminalintent;

import android.os.Bundle;
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
import java.util.UUID;

public class CrimeFragment extends Fragment {

  private static final String ARG_CRIME_ID = "crime_id";

  private Crime Crime;
  private EditText TitleField;
  private Button DateButton;
  private CheckBox SolvedCheckBox;

  public static CrimeFragment newInstance(UUID crimeId) {
    Bundle args = new Bundle();
    args.putSerializable(ARG_CRIME_ID, crimeId);

    CrimeFragment fragment = new CrimeFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
    Crime = CrimeLab.get(getActivity()).getCrime(crimeId);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
  View v = inflater.inflate(R.layout.fragment_crime, container, false);

  TitleField = (EditText) v.findViewById(R.id.crime_title);
  TitleField.setText(Crime.getTitle());
  TitleField.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Crime.setTitle(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
  });

    DateButton = (Button) v.findViewById(R.id.crime_date);
      DateButton.setText(Crime.getDate().toString());
      DateButton.setEnabled(false);
    SolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
    SolvedCheckBox.setChecked(Crime.isSolved());
    SolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Crime.setSolved(isChecked);


    }
  });



  return v;
  }
}
