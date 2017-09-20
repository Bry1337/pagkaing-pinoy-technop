package com.pp.pagkaingpinoy.ui.activities.drinks;

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
 * Created by bry1337 on 20/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class DrinksPresenter implements OnSingleItemClickListener {

  private final DrinksActivity activity;

  private StringBuilder stringBuilder;
  private int totalPrice;

  public DrinksPresenter(DrinksActivity activity) {
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
      totalPrice = totalPrice + (Integer.parseInt(menu.getPrice()) * Integer.parseInt(menu.getQuantity()));
    }
  }

  public void initDrinksList() {
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
      InputStream is = activity.getAssets().open("drinks_menu.json");
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
