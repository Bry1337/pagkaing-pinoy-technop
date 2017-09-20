package com.pp.pagkaingpinoy.ui.activities.breakfast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pp.pagkaingpinoy.models.Menu;
import com.pp.pagkaingpinoy.ui.utils.OnSingleItemClickListener;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class BreakfastPresenter implements OnSingleItemClickListener {

  private final BreakfastActivity activity;

  private StringBuilder stringBuilder;
  private int totalPrice;

  public BreakfastPresenter(BreakfastActivity activity) {
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
      totalPrice = totalPrice + (Integer.parseInt(menu.getPrice()) * Integer.parseInt(menu.getQuantity()));
    }
  }

  public void initBreakfastList() {
    try {
      JSONObject jsonObject = new JSONObject(loadJSONFromAsset());
      JSONArray jsonArray = jsonObject.getJSONArray("items");
      Type listType = new TypeToken<List<Menu>>() {
      }.getType();
      activity.setBreakfastList(new Gson().fromJson(jsonArray.toString(), listType));
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  private String loadJSONFromAsset() {
    String json;
    try {
      InputStream is = activity.getAssets().open("breakfast_menu.json");
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");
    } catch (IOException ex) {
      ex.printStackTrace();
      return null;
    }
    return json;
  }

  public StringBuilder getStringBuilder() {
    return stringBuilder;
  }

  public int getTotalPrice() {
    return totalPrice;
  }
}
