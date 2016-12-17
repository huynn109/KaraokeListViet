package com.huynn109.karaokelistviet.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huynn109.karaokelistviet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CaliforniaFragment extends BaseFragment {

  public static CaliforniaFragment newInstance() {
     Bundle args = new Bundle();
     CaliforniaFragment fragment = new CaliforniaFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_california, container, false);
  }
}
