package com.pp.pagkaingpinoy.dagger.application;

import android.app.Application;
import android.content.Context;
import com.pp.pagkaingpinoy.MainActivity;
import com.pp.pagkaingpinoy.dagger.component.ApplicationComponent;
import com.pp.pagkaingpinoy.dagger.component.DaggerApplicationComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.DashboardActivityComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.MainActivityComponent;
import com.pp.pagkaingpinoy.dagger.component.activities.TableNumberComponent;
import com.pp.pagkaingpinoy.dagger.modules.ApplicationModule;
import com.pp.pagkaingpinoy.dagger.modules.DashboardActivityModule;
import com.pp.pagkaingpinoy.dagger.modules.MainActivityModule;
import com.pp.pagkaingpinoy.dagger.modules.TableNumberModule;
import com.pp.pagkaingpinoy.ui.activities.dashboard.DashboardActivity;
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

  public void releaseMainActivityComponent() {
    mainActivityComponent = null;
  }

  public void releaseTableNumberComponent() {
    tableNumberComponent = null;
  }

  public void releaseDashboardActivityComponent(){
    dashboardActivityComponent = null;
  }
}
