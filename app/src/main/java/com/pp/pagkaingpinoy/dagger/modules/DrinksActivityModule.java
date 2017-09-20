package com.pp.pagkaingpinoy.dagger.modules;

import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.drinks.DrinksActivity;
import com.pp.pagkaingpinoy.ui.activities.drinks.DrinksPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bry1337 on 20/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Module public class DrinksActivityModule {

  private final DrinksActivity activity;

  public DrinksActivityModule(DrinksActivity activity) {
    this.activity = activity;
  }

  @Provides @UserScope DrinksActivity provideDrinksActivity() {
    return activity;
  }

  @Provides @UserScope DrinksPresenter provideDrinksPresenter() {
    return new DrinksPresenter(activity);
  }
}
