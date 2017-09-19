package com.pp.pagkaingpinoy.managers;

import android.app.Activity;
import android.content.Intent;
import com.pp.pagkaingpinoy.ui.activities.dashboard.DashboardActivity;
import com.pp.pagkaingpinoy.ui.activities.tablenumber.TableNumberActivity;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class AppActivityManager {

  public static final String TABLE_NUMBER = "tableNumber";

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
}
