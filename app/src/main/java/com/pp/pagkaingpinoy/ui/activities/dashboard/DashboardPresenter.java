package com.pp.pagkaingpinoy.ui.activities.dashboard;

import android.support.v7.app.AlertDialog;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.managers.AppConstants;
import com.pp.pagkaingpinoy.models.Order;
import com.pp.pagkaingpinoy.ui.utils.OnSingleItemClickListener;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

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
      writeNewOrders(activity.tvTableNumber.getText().toString(), getAmount(), getOrders());
      activity.appActivityManager.finishOrders(activity);
    });
    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, activity.getString(R.string.cancel), ((dialogInterface, i) -> {
      alertDialog.dismiss();
    }));
    alertDialog.show();
  }

  private void writeNewOrders(String tableNumber, String amount, StringBuilder orders) {
    DatabaseReference ordersReference = FirebaseDatabase.getInstance().getReference();
    String key = ordersReference.child(AppConstants.ORDERS).push().getKey();
    Order post = new Order(Integer.parseInt(tableNumber), orders, amount, tableNumber);
    Map<String, Object> postValues = post.toMap();

    Map<String, Object> childUpdates = new HashMap<>();
    childUpdates.put("/orders/" + Integer.parseInt(tableNumber), postValues);

    ordersReference.updateChildren(childUpdates);
  }

  private StringBuilder getOrders() {
    StringBuilder orders = new StringBuilder();
    if (StringUtils.isNotEmpty(activity.tvBreakfastOrders.getText().toString())) {
      orders.append(String.format("%s \n", activity.tvBreakfastOrders.getText().toString()));
    }

    if (StringUtils.isNotEmpty(activity.tvLunchOrder.getText().toString())) {
      orders.append(String.format("%s \n", activity.tvLunchOrder.getText().toString()));
    }

    if (StringUtils.isNotEmpty(activity.tvDinnerOrder.getText().toString())) {
      orders.append(String.format("%s \n", activity.tvDinnerOrder.getText().toString()));
    }

    if (StringUtils.isNotEmpty(activity.tvDrinksOrder.getText().toString())) {
      orders.append(String.format("%s \n", activity.tvDrinksOrder.getText().toString()));
    }

    if (StringUtils.isNotEmpty(activity.tvDessertOrder.getText().toString())) {
      orders.append(String.format("%s \n", activity.tvDessertOrder.getText().toString()));
    }

    return orders;
  }

  private String getAmount() {
    if (StringUtils.isNotEmpty(activity.tvTotalAmount.getText().toString())) {
      return activity.tvTotalAmount.getText().toString();
    }
    return "0";
  }
}
