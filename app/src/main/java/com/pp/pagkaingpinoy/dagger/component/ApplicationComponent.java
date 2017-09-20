package com.pp.pagkaingpinoy.dagger.component;

import com.pp.pagkaingpinoy.dagger.component.activities.BreakfastActivityComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.DashboardActivityComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.DessertActivityComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.DinnerActivityComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.DrinksActivityComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.LunchActivityComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.MainActivityComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.TableNumberComponent;
import com.pp.pagkaingpinoy.dagger.modules.ApplicationModule;
import com.pp.pagkaingpinoy.dagger.modules.BreakfastActivityModule;
import com.pp.pagkaingpinoy.dagger.modules.DashboardActivityModule;
import com.pp.pagkaingpinoy.dagger.modules.DessertActivityModule;
import com.pp.pagkaingpinoy.dagger.modules.DinnerActivityModule;
import com.pp.pagkaingpinoy.dagger.modules.DrinksActivityModule;
import com.pp.pagkaingpinoy.dagger.modules.LunchActivityModule;
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

  BreakfastActivityComponent plus(BreakfastActivityModule breakfastActivityModule);

  LunchActivityComponent plus(LunchActivityModule lunchActivityModule);

  DinnerActivityComponent plus(DinnerActivityModule dinnerActivityModule);

  DessertActivityComponent plus(DessertActivityModule dessertActivityModule);

  DrinksActivityComponent plus(DrinksActivityModule drinksActivityModule);
}
