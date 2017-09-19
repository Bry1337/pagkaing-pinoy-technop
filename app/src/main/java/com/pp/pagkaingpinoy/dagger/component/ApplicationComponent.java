package com.pp.pagkaingpinoy.dagger.component;

import com.pp.pagkaingpinoy.dagger.component.activities.DashboardActivityComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.MainActivityComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.TableNumberComponent;
import com.pp.pagkaingpinoy.dagger.modules.ApplicationModule;
import com.pp.pagkaingpinoy.dagger.modules.DashboardActivityModule;
import com.pp.pagkaingpinoy.dagger.modules.MainActivityModule;
import com.pp.pagkaingpinoy.dagger.modules.TableNumberModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@Singleton @Component(modules = { ApplicationModule.class }) public interface ApplicationComponent {

  MainActivityComponent plus(MainActivityModule mainActivityModule);

  TableNumberComponent plus(TableNumberModule tableNumberModule);

  DashboardActivityComponent plus(DashboardActivityModule dashboardActivityModule);
}
