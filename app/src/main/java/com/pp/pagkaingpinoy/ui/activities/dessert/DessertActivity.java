package com.pp.pagkaingpinoy.ui.activities.dessert;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.dagger.application.BaseApplication;
import com.pp.pagkaingpinoy.managers.AppActivityManager;
import com.pp.pagkaingpinoy.managers.SharedPreferenceManager;
import com.pp.pagkaingpinoy.models.Menu;
import com.pp.pagkaingpinoy.ui.activities.ToolBarBaseActivity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by bry1337 on 20/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class DessertActivity extends ToolBarBaseActivity {

  @Inject DessertPresenter presenter;
  @Inject SharedPreferenceManager sharedPreferenceManager;
  @Inject AppActivityManager appActivityManager;

  @BindView(R.id.rvDessertMenu) RecyclerView rvDessertMenu;

  private DessertAdapter dessertAdapter;
  private List<Menu> dessertList;

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_dessert);
  }

  @Override protected void setupViewElements() {
    dessertList = new ArrayList<>();
    presenter.initDessertList();
    initDessertList();
  }

  @Override protected boolean isActionBarBackButtonEnabled() {
    return true;
  }

  @Override protected void injectDaggerComponent() {
    BaseApplication.get(this).createDessertComponent(this).inject(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    BaseApplication.get(this).releaseDessertComponent();
  }

  @Override public void onBackPressed() {
    handleMenuBuilder();
  }

  public void setDessertList(List<Menu> dessertList) {
    this.dessertList.clear();
    this.dessertList.addAll(dessertList);
    dessertAdapter.notifyDataSetChanged();
  }

  private void initDessertList() {
    dessertAdapter = new DessertAdapter(this, dessertList, presenter);
    rvDessertMenu.setLayoutManager(new GridLayoutManager(this, 2));
    rvDessertMenu.setAdapter(dessertAdapter);
  }

  private void handleMenuBuilder() {
    if (presenter.getStringBuilder().length() > 0) {
      sharedPreferenceManager.dessertOrder(presenter.getStringBuilder());
      sharedPreferenceManager.dessertTotalPrice(presenter.getTotalPrice());
      appActivityManager.returnToDashboard(this);
    } else {
      finish();
    }
  }
}
