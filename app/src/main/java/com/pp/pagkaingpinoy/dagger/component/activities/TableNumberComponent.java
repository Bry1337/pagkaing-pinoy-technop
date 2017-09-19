package com.pp.pagkaingpinoy.dagger.component.activities;

import com.pp.pagkaingpinoy.dagger.modules.TableNumberModule;
import com.pp.pagkaingpinoy.dagger.scopes.UserScope;
import com.pp.pagkaingpinoy.ui.activities.tablenumber.TableNumberActivity;
import dagger.Subcomponent;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Subcomponent(modules = { TableNumberModule.class }) public interface TableNumberComponent {
  TableNumberActivity inject(TableNumberActivity tableNumberActivity);
}
