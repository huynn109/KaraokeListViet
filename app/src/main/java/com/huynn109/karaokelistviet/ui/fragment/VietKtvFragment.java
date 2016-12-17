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
public class VietKtvFragment extends Fragment {

  public static VietKtvFragment newInstance() {
     Bundle args = new Bundle();
     VietKtvFragment fragment = new VietKtvFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_viet_ktv, container, false);
  }
}
