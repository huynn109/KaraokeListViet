package com.huynn109.karaokelistviet.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.huynn109.karaokelistviet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends BaseFragment {

  public static FavoriteFragment  newInstance(int instance) {
    Bundle args = new Bundle();
    args.putInt(ARGS_INSTANCE, instance);
    FavoriteFragment fragment = new FavoriteFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_favorite, container, false);
    ButterKnife.bind(this, view);
    return view;
  }
}
