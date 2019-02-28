package edu.cnm.deepdive.criminalintent;

import android.support.v4.app.Fragment;
/*
A controller class
 */

public class CrimeListActivity extends SingleFragmentActivity{


  @Override
  protected Fragment createFragment() {
    return new CrimeListFragment();
  }
}