package com.huynn109.karaokelistviet.data.model;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by huyuit on 12/2/2016.
 */

public class Song extends RealmObject {
  @PrimaryKey public int id;
  @Index public int number;
  @Index public int vol;
  public String abbr;
  public String language;
  @Index public String lyric;
  @Index public String lyricClean;
  @Index public String manufacture;
  public String meta;
  public String metaClean;
  @Index public String name;
  @Index public String nameClean;
  public String youtube;
}
