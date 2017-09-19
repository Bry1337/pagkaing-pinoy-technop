package com.pp.pagkaingpinoy.ui.activities.dashboard;

import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.ui.utils.OnSingleItemClickListener;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class DashboardPresenter implements OnSingleItemClickListener {

  public DashboardActivity activity;

  public DashboardPresenter(DashboardActivity activity) {
    this.activity = activity;
  }

  @Override public void onSingleItemClick(Object object) {
    String navItem = (String) object;
    if (navItem.equals(activity.getString(R.string.breakfast))) {
      activity.appActivityManager.launchBreakfastActivity(activity);
    } else if (navItem.equals(activity.getString(R.string.lunch))) {
      activity.appActivityManager.launchLunchActivity(activity);
    } else if (navItem.equals(activity.getString(R.string.dinner))) {
      activity.appActivityManager.launchDinnerActivity(activity);
    }
  }
}
