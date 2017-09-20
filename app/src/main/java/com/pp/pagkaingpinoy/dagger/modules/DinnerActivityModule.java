package com.pp.pagkaingpinoy.dagger.modules;

import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.dinner.DinnerActivity;
import com.pp.pagkaingpinoy.ui.activities.dinner.DinnerPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Module public class DinnerActivityModule {

  private final DinnerActivity activity;

  public DinnerActivityModule(DinnerActivity activity) {
    this.activity = activity;
  }

  @Provides @UserScope DinnerActivity provideDinnerActivity() {
    return activity;
  }

  @Provides @UserScope DinnerPresenter provideDinnerPresenter() {
    return new DinnerPresenter(activity);
  }
}
