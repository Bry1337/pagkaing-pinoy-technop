package com.pp.pagkaingpinoy.dagger.component.activities;

import com.pp.pagkaingpinoy.dagger.modules.DinnerActivityModule;
import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.dinner.DinnerActivity;
import dagger.Subcomponent;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Subcomponent(modules = { DinnerActivityModule.class }) public interface DinnerActivityComponent {
  DinnerActivity inject(DinnerActivity dinnerActivity);
}
