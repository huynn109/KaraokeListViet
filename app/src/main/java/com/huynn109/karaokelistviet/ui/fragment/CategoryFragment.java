package com.huynn109.karaokelistviet.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.huynn109.karaokelistviet.R;
import com.huynn109.karaokelistviet.data.model.Song;
import io.realm.Realm;
import io.realm.RealmResults;

//import com.huynn109.karaokelistviet.data.model.Song;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends BaseFragment {

  public static final String TAG = CategoryFragment.class.getSimpleName();

  @BindView(R.id.toolbar) Toolbar mToolbar;
  @BindView(R.id.recycler_category) RecyclerView mRecyclerView;
  private Realm mRealm;

  public static CategoryFragment  newInstance(int instance) {
    Bundle args = new Bundle();
    args.putInt(ARGS_INSTANCE, instance);
    CategoryFragment fragment = new CategoryFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_category, container, false);
    ButterKnife.bind(this, rootView);
    setupToolbar();
    return rootView;
  }

  @Override public void onStart() {
    super.onStart();
    mRealm = Realm.getDefaultInstance();
    setupRecyclerView();
  }


  @Override public void onStop() {
    super.onStop();
    mRealm.close();
  }

  private void setupRecyclerView() {
    RealmResults<Song> mArirangs = mRealm.where(Song.class).findAll();
    Log.d(TAG, "setupRecyclerView: " + mArirangs.size());
  }

  private void setupToolbar() {
    ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
    ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
  }

  @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.menu_category, menu);

    MenuItem itemCategory = menu.findItem(R.id.spinner_category);
    Spinner spinnerCategory = (Spinner) MenuItemCompat.getActionView(itemCategory);

    ArrayAdapter<CharSequence> adapterCategory =
        ArrayAdapter.createFromResource(getContext(), android.R.array.imProtocols,
            android.R.layout.simple_spinner_item);
    adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    spinnerCategory.setAdapter(adapterCategory);

    MenuItem itemVol = menu.findItem(R.id.spinner_vol);
    Spinner spinnerVol = (Spinner) MenuItemCompat.getActionView(itemVol);

    ArrayAdapter<CharSequence> adapterVol =
        ArrayAdapter.createFromResource(getContext(), android.R.array.imProtocols,
            android.R.layout.simple_spinner_item);
    adapterVol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    spinnerVol.setAdapter(adapterVol);

    MenuItem itemAlphabet = menu.findItem(R.id.spinner_alpha_bet);
    Spinner spinnerAlphabet = (Spinner) MenuItemCompat.getActionView(itemAlphabet);

    ArrayAdapter<CharSequence> adapterAlphabet =
        ArrayAdapter.createFromResource(getContext(), android.R.array.imProtocols,
            android.R.layout.simple_spinner_item);
    adapterAlphabet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    spinnerAlphabet.setAdapter(adapterAlphabet);

    super.onCreateOptionsMenu(menu, inflater);
  }
}
