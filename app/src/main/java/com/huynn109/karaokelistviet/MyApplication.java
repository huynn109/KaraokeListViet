package com.huynn109.karaokelistviet;

import android.app.Application;
import android.support.annotation.Nullable;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by huyuit on 12/1/2016.
 */
public class MyApplication extends Application {
  private RealmConfiguration realmConfiguration;

  @Override public void onCreate() {
    super.onCreate();
    Realm.init(this);
    realmConfiguration = new RealmConfiguration.Builder()
        .deleteRealmIfMigrationNeeded()
        .build();
    copyBundledRealmFile(this.getResources().openRawResource(R.raw.default0), "default.realm");
  }

  @Nullable private String copyBundledRealmFile(InputStream inputStream, String outFileName) {
    try {
      File file = new File(this.getFilesDir(), outFileName);
      FileOutputStream outputStream = new FileOutputStream(file);
      byte[] buf = new byte[1024];
      int bytesRead;
      while ((bytesRead = inputStream.read(buf)) > 0) {
        outputStream.write(buf, 0, bytesRead);
      }
      outputStream.close();
      return file.getAbsolutePath();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}

