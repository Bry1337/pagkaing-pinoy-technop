package com.pp.pagkaingpinoy.ui.activities.breakfast;

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

public class BreakfastActivity extends ToolBarBaseActivity {

  @Inject BreakfastPresenter presenter;
  @Inject SharedPreferenceManager sharedPreferenceManager;
  @Inject AppActivityManager appActivityManager;

  @BindView(R.id.rvBreakfastMenu) RecyclerView rvBreakfastMenu;

  private BreakfastAdapter breakfastAdapter;
  private List<Menu> breakfastList;

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_breakfast);
  }

  @Override protected void setupViewElements() {
    breakfastList = new ArrayList<>();
    presenter.initBreakfastList();
    initBreakfastMenu();
  }

  @Override protected boolean isActionBarBackButtonEnabled() {
    return true;
  }

  @Override protected void injectDaggerComponent() {
    BaseApplication.get(this).createBreakfastActivityComponent(this).inject(this);
  }

  private void initBreakfastMenu() {
    breakfastAdapter = new BreakfastAdapter(this, breakfastList, presenter);
    rvBreakfastMenu.setLayoutManager(new GridLayoutManager(this, 2));
    rvBreakfastMenu.setAdapter(breakfastAdapter);
  }

  public void setBreakfastList(List<Menu> breakfastList) {
    this.breakfastList.clear();
    this.breakfastList.addAll(breakfastList);
    breakfastAdapter.notifyDataSetChanged();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    BaseApplication.get(this).releaseBreakfastActivityComponent();
  }

  @Override public void onBackPressed() {
    handleMenuBuilder();
  }

  private void handleMenuBuilder() {
    if (presenter.getStringBuilder().length() > 0) {
      sharedPreferenceManager.breakfastOrder(presenter.getStringBuilder());
      sharedPreferenceManager.breakfastTotalPrice(presenter.getTotalPrice());
      appActivityManager.returnToDashboard(this);
    } else {
      finish();
    }
  }
}
