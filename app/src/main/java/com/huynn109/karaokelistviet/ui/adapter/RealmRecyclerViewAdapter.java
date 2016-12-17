package com.huynn109.karaokelistviet.ui.adapter;

import android.support.v7.widget.RecyclerView;
import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;

/**
 * Created by huyuit on 12/1/2016.
 */

public abstract class RealmRecyclerViewAdapter<T extends RealmObject> extends RecyclerView.Adapter {
  private RealmBaseAdapter<T> realmBaseAdapter;

  public void setRealmAdapter(RealmBaseAdapter<T> realmAdapter) {
    realmBaseAdapter = realmAdapter;
  }

  public T getItem(int position) {
    return realmBaseAdapter.getItem(position);
  }

  public RealmBaseAdapter<T> getRealmAdapter() {
    return realmBaseAdapter;
  }
}
