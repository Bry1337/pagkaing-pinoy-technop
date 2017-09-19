package com.pp.pagkaingpinoy.ui.activities.dashboard;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import butterknife.BindView;
import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.dagger.application.BaseApplication;
import com.pp.pagkaingpinoy.managers.AppActivityManager;
import com.pp.pagkaingpinoy.ui.activities.ToolBarBaseActivity;
import javax.inject.Inject;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class DashboardActivity extends ToolBarBaseActivity {

  @Inject NavMenuAdapter navMenuAdapter;

  @BindView(R.id.rvNavMenu) RecyclerView rvNavMenu;
  @BindView(R.id.nav_view) NavigationView navView;
  @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
  @BindView(R.id.tvTableNumber) TextView tvTableNumber;

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_dashboard);
  }

  @Override protected void setupViewElements() {
    setupNavigation();
    initNavigation();
    getIntentExtra();
  }

  @Override protected boolean isActionBarBackButtonEnabled() {
    return false;
  }

  @Override protected void injectDaggerComponent() {
    BaseApplication.get(this).createDashboardActivityComponent(this).inject(this);
  }

  @Override public void onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  private void getIntentExtra() {
    if (getIntent().getStringExtra(AppActivityManager.TABLE_NUMBER) != null) {
      tvTableNumber.setText(getIntent().getStringExtra(AppActivityManager.TABLE_NUMBER));
    }
  }

  private void setupNavigation() {
    final ActionBarDrawerToggle toggle =
        new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();
  }

  private void initNavigation() {
    rvNavMenu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    rvNavMenu.setAdapter(navMenuAdapter);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    BaseApplication.get(this).releaseDashboardActivityComponent();
  }
}
