package com.pp.pagkaingpinoy.dagger.modules;

import android.app.Application;
import android.content.Context;
import com.pp.pagkaingpinoy.managers.AppActivityManager;
import com.pp.pagkaingpinoy.managers.SharedPreferenceKeys;
import com.pp.pagkaingpinoy.managers.SharedPreferenceManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@Singleton @Module public class ApplicationModule {

  private final Application application;

  public ApplicationModule(final Application application) {
    this.application = application;
  }

  @Provides @Singleton Application provideApplication() {
    return application;
  }

  @Provides @Singleton AppActivityManager provideActivityManager() {
    return new AppActivityManager();
  }

  @Provides @Singleton SharedPreferenceManager provideSharedPreferenceManager() {
    return new SharedPreferenceManager(application.getApplicationContext()
        .getApplicationContext()
        .getSharedPreferences(SharedPreferenceKeys.MY_PREFERENCE, Context.MODE_PRIVATE));
  }
}
