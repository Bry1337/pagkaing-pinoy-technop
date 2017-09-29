package com.pp.pagkaingpinoy.ui.activities.lunch;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pp.pagkaingpinoy.managers.AppConstants;
import com.pp.pagkaingpinoy.models.Menu;
import com.pp.pagkaingpinoy.ui.utils.OnSingleItemClickListener;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class LunchPresenter implements OnSingleItemClickListener {

  private final LunchActivity activity;

  private StringBuilder stringBuilder;
  private int totalPrice;

  public LunchPresenter(LunchActivity activity) {
    this.activity = activity;
    this.stringBuilder = new StringBuilder();
    this.totalPrice = 0;
  }

  @Override public void onSingleItemClick(Object object) {
    Menu menu = (Menu) object;
    processTotalPrice(menu);
  }

  private void processTotalPrice(Menu menu) {
    if (menu != null) {
      stringBuilder.append(String.format("%s %s%s", menu.getQuantity(), menu.getName(), "\n"));
      totalPrice =
          totalPrice + (Integer.parseInt(String.valueOf(menu.getPrice())) * Integer.parseInt(menu.getQuantity()));
    }
  }

  public void initLunchList() {
    List<Menu> menuList = new ArrayList<>();
    DatabaseReference lunchReference = FirebaseDatabase.getInstance().getReference().child(AppConstants.LUNCH_MENU);
    lunchReference.addValueEventListener(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot snapShot : dataSnapshot.getChildren()) {
          HashMap<String, Object> td = (HashMap<String, Object>) snapShot.getValue();
          menuList.add(new Menu(td));
        }

        activity.setLunchList(menuList);
      }

      @Override public void onCancelled(DatabaseError databaseError) {

      }
    });
  }

  public StringBuilder getStringBuilder() {
    return stringBuilder;
  }

  public int getTotalPrice() {
    return totalPrice;
  }
}
