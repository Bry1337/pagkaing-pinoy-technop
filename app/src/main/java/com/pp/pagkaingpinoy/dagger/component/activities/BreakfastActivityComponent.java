package com.pp.pagkaingpinoy.dagger.component.activities;

import com.pp.pagkaingpinoy.dagger.modules.BreakfastActivityModule;
import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.breakfast.BreakfastActivity;
import dagger.Subcomponent;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Subcomponent(modules = { BreakfastActivityModule.class }) public interface BreakfastActivityComponent {
  BreakfastActivity inject(BreakfastActivity breakfastActivity);
}
