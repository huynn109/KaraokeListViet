package com.huynn109.karaokelistviet.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.huynn109.karaokelistviet.R;

/**
 * Created by huyuit on 12/10/2016.
 */

public class BaseFragment extends Fragment {
  public static final String ARGS_INSTANCE = "com.huynn109.karaokelistview.argsInstance";

  FragmentNavigation mFragmentNavigation;
  int mInt = 0;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    if (args != null) {
      mInt = args.getInt(ARGS_INSTANCE);
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof FragmentNavigation) {
      mFragmentNavigation = (FragmentNavigation) context;
    }
  }

  public interface FragmentNavigation {
    void pushFragment(Fragment fragment);
  }
}
