package com.pp.pagkaingpinoy.dagger.component.activities;

import com.pp.pagkaingpinoy.dagger.modules.DrinksActivityModule;
import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.drinks.DrinksActivity;
import dagger.Subcomponent;

/**
 * Created by bry1337 on 20/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Subcomponent(modules = { DrinksActivityModule.class }) public interface DrinksActivityComponent {
  DrinksActivity inject(DrinksActivity drinksActivity);
}
