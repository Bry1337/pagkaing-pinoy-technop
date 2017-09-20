package com.pp.pagkaingpinoy.dagger.application;

import android.app.Application;
import android.content.Context;
import com.pp.pagkaingpinoy.MainActivity;
import com.pp.pagkaingpinoy.dagger.component.ApplicationComponent;
import com.pp.pagkaingpinoy.dagger.component.DaggerApplicationComponent;
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
import com.pp.pagkaingpinoy.ui.activities.breakfast.BreakfastActivity;
import com.pp.pagkaingpinoy.ui.activities.dashboard.DashboardActivity;
import com.pp.pagkaingpinoy.ui.activities.dessert.DessertActivity;
import com.pp.pagkaingpinoy.ui.activities.dinner.DinnerActivity;
import com.pp.pagkaingpinoy.ui.activities.drinks.DrinksActivity;
import com.pp.pagkaingpinoy.ui.activities.lunch.LunchActivity;
import com.pp.pagkaingpinoy.ui.activities.tablenumber.TableNumberActivity;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class BaseApplication extends Application {

  private ApplicationComponent applicationComponent;

  private MainActivityComponent mainActivityComponent;

  private TableNumberComponent tableNumberComponent;

  private DashboardActivityComponent dashboardActivityComponent;

  private BreakfastActivityComponent breakfastActivityComponent;

  private LunchActivityComponent lunchActivityComponent;

  private DinnerActivityComponent dinnerActivityComponent;

  private DessertActivityComponent dessertActivityComponent;

  private DrinksActivityComponent drinksActivityComponent;

  public static BaseApplication get(Context context) {
    return (BaseApplication) context.getApplicationContext();
  }

  @Override public void onCreate() {
    super.onCreate();
    initAppComponent();
  }

  private void initAppComponent() {
    applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  public MainActivityComponent createMainActivityComponent(final MainActivity mainActivity) {
    mainActivityComponent = applicationComponent.plus(new MainActivityModule(mainActivity));
    return mainActivityComponent;
  }

  public TableNumberComponent createTableNumberComponent(final TableNumberActivity tableNumberActivity) {
    tableNumberComponent = applicationComponent.plus(new TableNumberModule(tableNumberActivity));
    return tableNumberComponent;
  }

  public DashboardActivityComponent createDashboardActivityComponent(final DashboardActivity dashboardActivity) {
    dashboardActivityComponent = applicationComponent.plus(new DashboardActivityModule(dashboardActivity));
    return dashboardActivityComponent;
  }

  public BreakfastActivityComponent createBreakfastActivityComponent(final BreakfastActivity breakfastActivity) {
    breakfastActivityComponent = applicationComponent.plus(new BreakfastActivityModule(breakfastActivity));
    return breakfastActivityComponent;
  }

  public LunchActivityComponent createLunchActivityComponent(final LunchActivity lunchActivity) {
    lunchActivityComponent = applicationComponent.plus(new LunchActivityModule(lunchActivity));
    return lunchActivityComponent;
  }

  public DinnerActivityComponent createDinnerComponent(final DinnerActivity dinnerActivity) {
    dinnerActivityComponent = applicationComponent.plus(new DinnerActivityModule(dinnerActivity));
    return dinnerActivityComponent;
  }

  public DessertActivityComponent createDessertComponent(final DessertActivity dessertActivity) {
    dessertActivityComponent = applicationComponent.plus(new DessertActivityModule(dessertActivity));
    return dessertActivityComponent;
  }

  public DrinksActivityComponent createDrinksComponent(final DrinksActivity drinksActivity) {
    drinksActivityComponent = applicationComponent.plus(new DrinksActivityModule(drinksActivity));
    return drinksActivityComponent;
  }

  public void releaseMainActivityComponent() {
    mainActivityComponent = null;
  }

  public void releaseTableNumberComponent() {
    tableNumberComponent = null;
  }

  public void releaseDashboardActivityComponent() {
    dashboardActivityComponent = null;
  }

  public void releaseBreakfastActivityComponent() {
    breakfastActivityComponent = null;
  }

  public void releaseLunchActivityComponent() {
    lunchActivityComponent = null;
  }

  public void releaseDinnerActivityComponent() {
    dinnerActivityComponent = null;
  }

  public void releaseDessertComponent() {
    dessertActivityComponent = null;
  }

  public void releaseDrinkComponent() {
    drinksActivityComponent = null;
  }
}
