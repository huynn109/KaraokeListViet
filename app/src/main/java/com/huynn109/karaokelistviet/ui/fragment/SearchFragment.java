package com.huynn109.karaokelistviet.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.WindowManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.huynn109.karaokelistviet.R;
import com.huynn109.karaokelistviet.ui.adapter.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment {

  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.viewpager) ViewPager mViewPager;
  @BindView(R.id.tabs) TabLayout mTabLayout;
  private View rootView;

  public static SearchFragment  newInstance(int instance) {
    Bundle args = new Bundle();
    args.putInt(ARGS_INSTANCE, instance);
    SearchFragment fragment = new SearchFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    rootView = inflater.inflate(R.layout.fragment_search, container, false);
    ButterKnife.bind(this, rootView);
    setHasOptionsMenu(true);
    setupToolbar();
    setupTabs();
    return rootView;
  }

  private void setupTabs() {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
    adapter.addFragment(ArirangFragment.newInstance(), "Arirang");
    adapter.addFragment(MusicCoreFragment.newInstance(), "MusicCore");
    adapter.addFragment(CaliforniaFragment.newInstance(), "California");
    adapter.addFragment(VietKtvFragment.newInstance(), "VietKTV");
    mViewPager.setAdapter(adapter);
    mTabLayout.setupWithViewPager(mViewPager);
  }

  private void setupToolbar() {
    ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
    ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
  }
}
