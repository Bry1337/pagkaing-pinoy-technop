package com.pp.pagkaingpinoy.dagger.modules;

import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.breakfast.BreakfastActivity;
import com.pp.pagkaingpinoy.ui.activities.breakfast.BreakfastPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Module public class BreakfastActivityModule {

  private final BreakfastActivity activity;

  public BreakfastActivityModule(BreakfastActivity activity) {
    this.activity = activity;
  }

  @Provides @UserScope BreakfastActivity provideBreakfastActivity() {
    return activity;
  }

  @Provides @UserScope BreakfastPresenter provideBreakfastPresenter() {
    return new BreakfastPresenter(activity);
  }
}
