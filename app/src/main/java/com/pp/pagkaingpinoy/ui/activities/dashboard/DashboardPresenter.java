package com.pp.pagkaingpinoy.ui.activities.dashboard;

import android.support.v7.app.AlertDialog;
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
    } else if (navItem.equals(activity.getString(R.string.dessert))) {
      activity.appActivityManager.launchDessertActivity(activity);
    } else if (navItem.equals(activity.getString(R.string.drinks))) {
      activity.appActivityManager.launchDrinksActivity(activity);
    }
  }

  public void processAlertDialog() {
    AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
    alertDialog.setTitle(activity.getString(R.string.notice));
    alertDialog.setMessage(String.format("%s \n%s %s", activity.getString(R.string.are_you_sure),
        activity.getString(R.string.total_amount_is), activity.tvTotalAmount.getText().toString()));
    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, activity.getString(R.string.yes), (dialogInterface, i) -> {
      activity.sharedPreferenceManager.clearAll();
      activity.appActivityManager.finishOrders(activity);
    });
    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, activity.getString(R.string.cancel), ((dialogInterface, i) -> {
      alertDialog.dismiss();
    }));
    alertDialog.show();
  }
}
