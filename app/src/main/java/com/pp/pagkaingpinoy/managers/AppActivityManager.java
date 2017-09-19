package com.pp.pagkaingpinoy.managers;

import android.app.Activity;
import android.content.Intent;
import com.pp.pagkaingpinoy.ui.activities.breakfast.BreakfastActivity;
import com.pp.pagkaingpinoy.ui.activities.dashboard.DashboardActivity;
import com.pp.pagkaingpinoy.ui.activities.dinner.DinnerActivity;
import com.pp.pagkaingpinoy.ui.activities.lunch.LunchActivity;
import com.pp.pagkaingpinoy.ui.activities.tablenumber.TableNumberActivity;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class AppActivityManager {

  public static final String TABLE_NUMBER = "tableNumber";
  public static final int REQUEST_BREAKFAST = 1000;

  public void launchTableActivity(Activity activity) {
    final Intent intent = new Intent(activity, TableNumberActivity.class);
    activity.startActivity(intent);
    activity.finish();
  }

  public void launchDashboardActivity(Activity activity, String tableNumber) {
    final Intent intent = new Intent(activity, DashboardActivity.class);
    intent.putExtra(TABLE_NUMBER, tableNumber);
    activity.startActivity(intent);
    activity.finish();
  }

  public void launchBreakfastActivity(Activity activity) {
    final Intent intent = new Intent(activity, BreakfastActivity.class);
    activity.startActivityForResult(intent, REQUEST_BREAKFAST);
  }

  public void launchLunchActivity(Activity activity) {
    final Intent intent = new Intent(activity, LunchActivity.class);
    activity.startActivity(intent);
  }

  public void launchDinnerActivity(Activity activity) {
    final Intent intent = new Intent(activity, DinnerActivity.class);
    activity.startActivity(intent);
  }

  public void returnToDashboard(Activity activity){
    Intent intent = new Intent();
    activity.setResult(Activity.RESULT_OK, intent);
    activity.finish();
  }
}
