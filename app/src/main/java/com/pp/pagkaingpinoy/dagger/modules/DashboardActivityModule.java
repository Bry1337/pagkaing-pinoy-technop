package com.pp.pagkaingpinoy.dagger.modules;

import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.dashboard.DashboardActivity;
import com.pp.pagkaingpinoy.ui.activities.dashboard.DashboardPresenter;
import com.pp.pagkaingpinoy.ui.activities.dashboard.NavMenuAdapter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Module public class DashboardActivityModule {

  private final DashboardActivity activity;

  public DashboardActivityModule(DashboardActivity activity) {
    this.activity = activity;
  }

  @Provides @UserScope DashboardActivity provideDashboardActivity() {
    return activity;
  }

  @Provides @UserScope NavMenuAdapter provideNavMenuAdapter() {
    return new NavMenuAdapter(activity);
  }

  @Provides @UserScope DashboardPresenter provideDashboardPresenter() {
    return new DashboardPresenter(activity);
  }
}
