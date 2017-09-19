package com.pp.pagkaingpinoy.dagger.modules;

import com.pp.pagkaingpinoy.MainActivity;
import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Module public class MainActivityModule {
  private final MainActivity mainActivity;

  public MainActivityModule(MainActivity mainActivity) {
    this.mainActivity = mainActivity;
  }

  @Provides @UserScope MainActivity provideMainActivity() {
    return mainActivity;
  }
}
