package com.pp.pagkaingpinoy.ui.activities.lunch;

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

public class LunchPresenter implements OnSingleItemClickListener {

  private final LunchActivity activity;

  public LunchPresenter(LunchActivity activity) {
    this.activity = activity;
  }

  @Override public void onSingleItemClick(Object object) {

  }

  public void initLunchList() {
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
      InputStream is = activity.getAssets().open("lunch_menu.json");
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
}
