package com.pp.pagkaingpinoy.managers;

import android.app.Activity;
import android.content.Intent;
import com.pp.pagkaingpinoy.ui.activities.TableNumberActivity;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class AppActivityManager {

  public void launchTableActivity(Activity activity) {
    final Intent intent = new Intent(activity, TableNumberActivity.class);
    activity.startActivity(intent);
    activity.finish();
  }
}
