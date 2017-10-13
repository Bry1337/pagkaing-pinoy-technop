package com.pp.pagkaingpinoy.ui.activities.lunch;

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
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class LunchActivity extends ToolBarBaseActivity {

  @Inject LunchPresenter lunchPresenter;
  @Inject AppActivityManager appActivityManager;
  @Inject SharedPreferenceManager sharedPreferenceManager;

  @BindView(R.id.rvLunchMenu) RecyclerView rvLunchMenu;

  private LunchAdapter lunchAdapter;
  private List<Menu> lunchList;

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_lunch);
  }

  @Override protected void setupViewElements() {
    lunchList = new ArrayList<>();
    lunchPresenter.initLunchList();
    initAdapter();
  }

  @Override protected boolean isActionBarBackButtonEnabled() {
    return true;
  }

  @Override protected void injectDaggerComponent() {
    BaseApplication.get(this).createLunchActivityComponent(this).inject(this);
  }

  public void setLunchList(List<Menu> breakfastList) {
    this.lunchList.clear();
    this.lunchList.addAll(breakfastList);
    lunchAdapter.notifyDataSetChanged();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    BaseApplication.get(this).releaseLunchActivityComponent();
  }

  private void initAdapter() {
    lunchAdapter = new LunchAdapter(this, lunchList, lunchPresenter);
    rvLunchMenu.setLayoutManager(new GridLayoutManager(this, 2));
    rvLunchMenu.setAdapter(lunchAdapter);
  }

  @Override public void onBackPressed() {
    handleMenuBuilder();
  }

  private void handleMenuBuilder() {
    if (lunchPresenter.getStringBuilder().length() > 0) {
      sharedPreferenceManager.lunchOrder(lunchPresenter.getStringBuilder());
      sharedPreferenceManager.lunchTotalPrice(lunchPresenter.getTotalPrice());
      appActivityManager.returnToDashboard(this);
    } else {
      finish();
    }
  }
}
