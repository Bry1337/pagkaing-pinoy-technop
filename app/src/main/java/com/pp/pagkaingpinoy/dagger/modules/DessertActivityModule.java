package com.pp.pagkaingpinoy.dagger.modules;

import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.dessert.DessertActivity;
import com.pp.pagkaingpinoy.ui.activities.dessert.DessertPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bry1337 on 20/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Module public class DessertActivityModule {

  private final DessertActivity activity;

  public DessertActivityModule(DessertActivity activity) {
    this.activity = activity;
  }

  @Provides @UserScope DessertActivity provideDessertActivity() {
    return activity;
  }

  @Provides @UserScope DessertPresenter provideDessertPresenter() {
    return new DessertPresenter(activity);
  }
}
