package com.huynn109.karaokelistviet.ui.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.huynn109.karaokelistviet.R;
import com.huynn109.karaokelistviet.ui.fragment.BaseFragment;
import com.huynn109.karaokelistviet.ui.fragment.CategoryFragment;
import com.huynn109.karaokelistviet.ui.fragment.FavoriteFragment;
import com.huynn109.karaokelistviet.ui.fragment.SearchFragment;
import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity
    implements BaseFragment.FragmentNavigation, FragNavController.RootFragmentListener,
    FragNavController.TransactionListener {
  private FragNavController fragNavController;
  @BindView(R.id.bottom_bar_tab) BottomBar mBottomBar;

  private final int INDEX_SEARCH = FragNavController.TAB1;
  private final int INDEX_CATEGORY = FragNavController.TAB2;
  private final int INDEX_FAVORITE = FragNavController.TAB3;

  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setupFragment(savedInstanceState);
  }

  private void setupFragment(Bundle savedInstanceState) {
    fragNavController =
        new FragNavController(savedInstanceState, getSupportFragmentManager(), R.id.container, this,
            5, INDEX_SEARCH);
    mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
      @Override public void onTabSelected(@IdRes int tabId) {
        switch (tabId) {
          case R.id.tab_search:
            fragNavController.switchTab(INDEX_SEARCH);
            break;
          case R.id.tab_category:
            fragNavController.switchTab(INDEX_CATEGORY);
            break;
          case R.id.tab_favorite:
            fragNavController.switchTab(INDEX_FAVORITE);
            break;
        }
      }
    });

    mBottomBar.setOnTabReselectListener(new OnTabReselectListener() {
      @Override public void onTabReSelected(@IdRes int tabId) {
        fragNavController.clearStack();
      }
    });
  }

  @Override public void onBackPressed() {
    if (fragNavController.canPop()) {
      fragNavController.pop();
    } else {
      super.onBackPressed();
    }
  }

  @Override public void pushFragment(Fragment fragment) {
    if (fragNavController != null) {
      fragNavController.push(fragment);
    }
  }

  @Override public void onTabTransaction(Fragment fragment, int index) {
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(fragNavController.canPop());
    }
  }

  @Override public void onFragmentTransaction(Fragment fragment) {
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(fragNavController.canPop());
    }
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    if (fragNavController != null) {
      fragNavController.onSaveInstanceState(outState);
    }
  }

  @Override public Fragment getRootFragment(int index) {
    switch (index) {
      case INDEX_SEARCH:
        return SearchFragment.newInstance(0);
      case INDEX_CATEGORY:
        return CategoryFragment.newInstance(0);
      case INDEX_FAVORITE:
        return FavoriteFragment.newInstance(0);
    }
    throw new IllegalStateException("Need to send an index that we know");
  }
}
