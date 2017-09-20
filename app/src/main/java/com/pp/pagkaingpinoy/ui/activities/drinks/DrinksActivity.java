package com.pp.pagkaingpinoy.ui.activities.drinks;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.dagger.application.BaseApplication;
import com.pp.pagkaingpinoy.managers.AppActivityManager;
import com.pp.pagkaingpinoy.managers.SharedPreferenceManager;
import com.pp.pagkaingpinoy.models.Menu;
import com.pp.pagkaingpinoy.ui.activities.ToolBarBaseActivity;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by bry1337 on 20/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class DrinksActivity extends ToolBarBaseActivity {

  @Inject DrinksPresenter presenter;
  @Inject SharedPreferenceManager sharedPreferenceManager;
  @Inject AppActivityManager appActivityManager;

  @BindView(R.id.rvDrinks) RecyclerView rvDrinks;

  private DrinksAdapter dinnerAdapter;
  private List<Menu> breakfastList;

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_drinks);
  }

  @Override protected void setupViewElements() {
    presenter.initDrinksList();
    initAdapter();
  }

  @Override protected boolean isActionBarBackButtonEnabled() {
    return true;
  }

  @Override protected void injectDaggerComponent() {
    BaseApplication.get(this).createDrinksComponent(this).inject(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    BaseApplication.get(this).releaseDrinkComponent();
  }

  public void setBreakfastList(List<Menu> breakfastList) {
    this.breakfastList = breakfastList;
  }

  private void initAdapter() {
    dinnerAdapter = new DrinksAdapter(this, breakfastList, presenter);
    rvDrinks.setLayoutManager(new GridLayoutManager(this, 2));
    rvDrinks.setAdapter(dinnerAdapter);
  }

  @Override public void onBackPressed() {
    handleMenuBuilder();
  }

  private void handleMenuBuilder() {
    if (presenter.getStringBuilder().length() > 0) {
      sharedPreferenceManager.drinksOrder(presenter.getStringBuilder());
      sharedPreferenceManager.drinksTotalPrice(presenter.getTotalPrice());
      appActivityManager.returnToDashboard(this);
    } else {
      finish();
    }
  }
}
