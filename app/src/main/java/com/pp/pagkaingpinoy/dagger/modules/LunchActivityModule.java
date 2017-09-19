package com.pp.pagkaingpinoy.dagger.modules;

import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.lunch.LunchActivity;
import com.pp.pagkaingpinoy.ui.activities.lunch.LunchPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Module public class LunchActivityModule {

  private final LunchActivity activity;

  public LunchActivityModule(LunchActivity activity) {
    this.activity = activity;
  }

  @Provides @UserScope LunchActivity provideLunchActivity() {
    return activity;
  }

  @Provides @UserScope LunchPresenter provideLunchPresenter() {
    return new LunchPresenter(activity);
  }
}
