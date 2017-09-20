package com.pp.pagkaingpinoy.dagger.component.activities;

import com.pp.pagkaingpinoy.dagger.modules.DessertActivityModule;
import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.dessert.DessertActivity;
import dagger.Subcomponent;

/**
 * Created by bry1337 on 20/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Subcomponent(modules = { DessertActivityModule.class }) public interface DessertActivityComponent {
  DessertActivity inject(DessertActivity dessertActivity);
}
