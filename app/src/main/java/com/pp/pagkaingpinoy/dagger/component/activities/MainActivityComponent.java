package com.pp.pagkaingpinoy.dagger.component.activities;

import com.pp.pagkaingpinoy.MainActivity;
import com.pp.pagkaingpinoy.dagger.modules.MainActivityModule;
import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import dagger.Subcomponent;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Subcomponent(modules = { MainActivityModule.class }) public interface MainActivityComponent {
  MainActivity inject(MainActivity mainActivity);
}
