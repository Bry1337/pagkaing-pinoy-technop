package com.pp.pagkaingpinoy.dagger.component.activities;

import com.pp.pagkaingpinoy.dagger.modules.LunchActivityModule;
import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.lunch.LunchActivity;
import dagger.Subcomponent;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Subcomponent(modules = { LunchActivityModule.class }) public interface LunchActivityComponent {
  LunchActivity inject(LunchActivity lunchActivity);
}
