package com.pp.pagkaingpinoy.dagger.modules;

import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.tablenumber.TableNumberActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Module public class TableNumberModule {
  private final TableNumberActivity tableNumberActivity;

  public TableNumberModule(final TableNumberActivity tableNumberActivity) {
    this.tableNumberActivity = tableNumberActivity;
  }

  @Provides @UserScope TableNumberActivity provideTableNumberActivity() {
    return tableNumberActivity;
  }
}
