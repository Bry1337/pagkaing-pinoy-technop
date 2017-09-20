package com.pp.pagkaingpinoy.ui.activities.dashboard;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.dagger.application.BaseApplication;
import com.pp.pagkaingpinoy.managers.AppActivityManager;
import com.pp.pagkaingpinoy.managers.SharedPreferenceManager;
import com.pp.pagkaingpinoy.ui.activities.ToolBarBaseActivity;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class DashboardActivity extends ToolBarBaseActivity {

  @Inject NavMenuAdapter navMenuAdapter;
  @Inject DashboardPresenter dashboardPresenter;
  @Inject AppActivityManager appActivityManager;
  @Inject SharedPreferenceManager sharedPreferenceManager;

  @BindView(R.id.rvNavMenu) RecyclerView rvNavMenu;
  @BindView(R.id.nav_view) NavigationView navView;
  @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
  @BindView(R.id.tvTableNumber) TextView tvTableNumber;
  @BindView(R.id.tvBreakfastOrders) TextView tvBreakfastOrders;
  @BindView(R.id.tvLunchOrder) TextView tvLunchOrder;
  @BindView(R.id.tvDinnerOrder) TextView tvDinnerOrder;
  @BindView(R.id.tvRemoveBreakfastOrder) TextView tvRemoveBreakfastOrder;
  @BindView(R.id.tvRemoveLunchOrder) TextView tvRemoveLunchOrder;
  @BindView(R.id.tvRemoveDinnerOrder) TextView tvRemoveDinnerOrder;
  @BindView(R.id.tvTotalAmount) TextView tvTotalAmount;
  @BindView(R.id.tvDessertOrder) TextView tvDessertOrder;
  @BindView(R.id.tvRemoveDessertOrder) TextView tvRemoveDessertOrder;
  @BindView(R.id.tvDrinksOrder) TextView tvDrinksOrder;
  @BindView(R.id.tvRemoveDrinksOrder) TextView tvRemoveDrinksOrder;
  @BindView(R.id.fabFinalizeOrder) FloatingActionButton fabFinalizeOrder;

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

  @OnClick(R.id.tvRemoveBreakfastOrder) void removeBreakfastOrder() {
    sharedPreferenceManager.clearBreakfastOrder();
    handleRemoveOrders(tvBreakfastOrders, tvRemoveBreakfastOrder, sharedPreferenceManager.getBreakfastTotalAmount());
    sharedPreferenceManager.clearBreakfastTotalPrice();
  }

  @OnClick(R.id.tvRemoveLunchOrder) void removeLunchOrder() {
    sharedPreferenceManager.clearLunchOrder();
    handleRemoveOrders(tvLunchOrder, tvRemoveLunchOrder, sharedPreferenceManager.getLunchTotalAmount());
    sharedPreferenceManager.clearLunchTotalPrice();
  }

  @OnClick(R.id.tvRemoveDinnerOrder) void removeDinnerOrder() {
    sharedPreferenceManager.clearDinnerOrder();
    handleRemoveOrders(tvDinnerOrder, tvRemoveDinnerOrder, sharedPreferenceManager.getDinnerTotalAmount());
    sharedPreferenceManager.clearDinnerTotalPrice();
  }

  @OnClick(R.id.tvRemoveDessertOrder) void removeDessertOrder() {
    sharedPreferenceManager.clearDessertOrder();
    handleRemoveOrders(tvDessertOrder, tvRemoveDessertOrder, sharedPreferenceManager.getDessertTotalAmount());
    sharedPreferenceManager.clearDessertTotalPrice();
  }

  @OnClick(R.id.tvRemoveDrinksOrder) void removeDrinksOrder() {
    sharedPreferenceManager.clearDrinksOrder();
    handleRemoveOrders(tvDrinksOrder, tvRemoveDrinksOrder, sharedPreferenceManager.getDrinksTotalAmount());
    sharedPreferenceManager.clearDrinksTotalPrice();
  }

  @OnClick(R.id.fabFinalizeOrder) void finalizeOrder() {
    if (StringUtils.isNotEmpty(tvTotalAmount.getText().toString())) {
      dashboardPresenter.processAlertDialog();
    } else {
      Toast.makeText(this, getString(R.string.please_select_some_order_first), Toast.LENGTH_SHORT).show();
    }
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode) {
      case AppActivityManager.REQUEST_BREAKFAST:
        if (RESULT_OK == resultCode) {
          tvBreakfastOrders.setText(sharedPreferenceManager.getBreakfastOrder());
          processTotalAmount(sharedPreferenceManager.getBreakfastTotalAmount());
          tvRemoveBreakfastOrder.setVisibility(View.VISIBLE);
        }
        break;

      case AppActivityManager.REQUEST_LUNCH:
        if (RESULT_OK == resultCode) {
          tvLunchOrder.setText(sharedPreferenceManager.getLunchOrder());
          processTotalAmount(sharedPreferenceManager.getLunchTotalAmount());
          tvRemoveLunchOrder.setVisibility(View.VISIBLE);
        }
        break;

      case AppActivityManager.REQUEST_DINNER:
        if (RESULT_OK == resultCode) {
          tvDinnerOrder.setText(sharedPreferenceManager.getDinnerOrder());
          processTotalAmount(sharedPreferenceManager.getDinnerTotalAmount());
          tvRemoveDinnerOrder.setVisibility(View.VISIBLE);
        }
        break;

      case AppActivityManager.REQUEST_DESSERT:
        if (RESULT_OK == resultCode) {
          tvDessertOrder.setText(sharedPreferenceManager.getDessertOrder());
          processTotalAmount(sharedPreferenceManager.getDessertTotalAmount());
          tvRemoveDessertOrder.setVisibility(View.VISIBLE);
        }
        break;

      case AppActivityManager.REQUEST_DRINKS:
        if (RESULT_OK == resultCode) {
          tvDrinksOrder.setText(sharedPreferenceManager.getDrinksOrder());
          processTotalAmount(sharedPreferenceManager.getDrinksTotalAmount());
          tvRemoveDrinksOrder.setVisibility(View.VISIBLE);
        }
        break;

      default:
        break;
    }
  }

  private void processTotalAmount(int totalAmount) {
    if (StringUtils.isNotEmpty(tvTotalAmount.getText().toString())) {
      tvTotalAmount.setText(String.valueOf(Integer.parseInt(tvTotalAmount.getText().toString()) + totalAmount));
    } else {
      tvTotalAmount.setText(String.valueOf(totalAmount));
    }
  }

  private void handleRemoveOrders(TextView tvOrder, TextView tvRemoveOrder, int amount) {
    tvOrder.setText(StringUtils.EMPTY);
    tvRemoveOrder.setVisibility(View.GONE);
    if (StringUtils.isNotEmpty(tvTotalAmount.getText().toString())) {
      tvTotalAmount.setText(String.valueOf(Integer.parseInt(tvTotalAmount.getText().toString()) - amount));
    } else {
      tvTotalAmount.setText("0");
    }
  }
}
