package com.pp.pagkaingpinoy.ui.activities.dessert;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pp.pagkaingpinoy.managers.AppConstants;
import com.pp.pagkaingpinoy.models.Menu;
import com.pp.pagkaingpinoy.ui.utils.OnSingleItemClickListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bry1337 on 20/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class DessertPresenter implements OnSingleItemClickListener {

  private final DessertActivity activity;

  private StringBuilder stringBuilder;
  private int totalPrice;

  public DessertPresenter(DessertActivity activity) {
    this.activity = activity;
    this.stringBuilder = new StringBuilder();
    this.totalPrice = 0;
  }

  @Override public void onSingleItemClick(Object object) {
    Menu menu = (Menu) object;
    processBreakFastOrder(menu);
  }

  private void processBreakFastOrder(Menu menu) {
    if (menu != null) {
      stringBuilder.append(String.format("%s %s%s", menu.getQuantity(), menu.getName(), "\n"));
      totalPrice =
          totalPrice + (Integer.parseInt(String.valueOf(menu.getPrice())) * Integer.parseInt(menu.getQuantity()));
    }
  }

  public void initDessertList() {
    List<Menu> menuList = new ArrayList<>();
    DatabaseReference dessertReference = FirebaseDatabase.getInstance().getReference().child(AppConstants.DESSERT_MENU);
    dessertReference.addValueEventListener(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot snapShot : dataSnapshot.getChildren()) {
          HashMap<String, Object> td = (HashMap<String, Object>) snapShot.getValue();
          menuList.add(new Menu(td));
        }

        activity.setDessertList(menuList);
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
