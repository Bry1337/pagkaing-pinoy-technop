package com.pp.pagkaingpinoy.ui.activities.dinner;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.dagger.application.BaseApplication;
import com.pp.pagkaingpinoy.models.Menu;
import com.pp.pagkaingpinoy.ui.activities.ToolBarBaseActivity;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class DinnerActivity extends ToolBarBaseActivity {

  @Inject DinnerPresenter presenter;

  @BindView(R.id.rvDinner) RecyclerView rvDinner;

  private DinnerAdapter dinnerAdapter;
  private List<Menu> breakfastList;

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_dinner);
  }

  @Override protected void setupViewElements() {
    presenter.initLunchList();
    initAdapter();
  }

  @Override protected boolean isActionBarBackButtonEnabled() {
    return true;
  }

  @Override protected void injectDaggerComponent() {
    BaseApplication.get(this).createDinnerComponent(this).inject(this);
  }

  public void setBreakfastList(List<Menu> breakfastList) {
    this.breakfastList = breakfastList;
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    BaseApplication.get(this).releaseDinnerActivityComponent();
  }

  private void initAdapter() {
    dinnerAdapter = new DinnerAdapter(this, breakfastList);
    rvDinner.setLayoutManager(new GridLayoutManager(this, 2));
    rvDinner.setAdapter(dinnerAdapter);
  }
}
