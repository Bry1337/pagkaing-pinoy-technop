package com.pp.pagkaingpinoy.managers;

import android.content.SharedPreferences;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class SharedPreferenceManager {

  private final SharedPreferences sharedPreferences;

  public SharedPreferenceManager(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }

  public void breakfastOrder(StringBuilder stringBuilder) {
    sharedPreferences.edit().putString(SharedPreferenceKeys.BREAKFAST, stringBuilder.toString()).apply();
  }

  public String getBreakfastOrder(){
    return sharedPreferences.getString(SharedPreferenceKeys.BREAKFAST, "");
  }
}
