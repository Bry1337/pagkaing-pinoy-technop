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

  public void breakfastTotalPrice(int totalPrice) {
    sharedPreferences.edit().putInt(SharedPreferenceKeys.BREAKFAST_TOTAL_PRICE, totalPrice).apply();
  }

  public void lunchOrder(StringBuilder stringBuilder) {
    sharedPreferences.edit().putString(SharedPreferenceKeys.LUNCH, stringBuilder.toString()).apply();
  }

  public void lunchTotalPrice(int totalPrice) {
    sharedPreferences.edit().putInt(SharedPreferenceKeys.LUNCH_TOTAL_PRICE, totalPrice).apply();
  }

  public void dinnerOrder(StringBuilder stringBuilder) {
    sharedPreferences.edit().putString(SharedPreferenceKeys.DINNER, stringBuilder.toString()).apply();
  }

  public void dinnerTotalPrice(int totalPrice) {
    sharedPreferences.edit().putInt(SharedPreferenceKeys.DINNER_TOTAL_PRICE, totalPrice).apply();
  }

  public void dessertOrder(StringBuilder stringBuilder) {
    sharedPreferences.edit().putString(SharedPreferenceKeys.DESSERT, stringBuilder.toString()).apply();
  }

  public void dessertTotalPrice(int totalPrice) {
    sharedPreferences.edit().putInt(SharedPreferenceKeys.DESSERT_TOTAL_PRICE, totalPrice).apply();
  }

  public void drinksOrder(StringBuilder stringBuilder) {
    sharedPreferences.edit().putString(SharedPreferenceKeys.DRINKS, stringBuilder.toString()).apply();
  }

  public void drinksTotalPrice(int totalPrice) {
    sharedPreferences.edit().putInt(SharedPreferenceKeys.DRINKS_TOTAL_PRICE, totalPrice).apply();
  }

  public String getBreakfastOrder() {
    return sharedPreferences.getString(SharedPreferenceKeys.BREAKFAST, "");
  }

  public String getLunchOrder() {
    return sharedPreferences.getString(SharedPreferenceKeys.LUNCH, "");
  }

  public String getDinnerOrder() {
    return sharedPreferences.getString(SharedPreferenceKeys.DINNER, "");
  }

  public String getDessertOrder() {
    return sharedPreferences.getString(SharedPreferenceKeys.DESSERT, "");
  }

  public String getDrinksOrder() {
    return sharedPreferences.getString(SharedPreferenceKeys.DRINKS, "");
  }

  public int getBreakfastTotalAmount() {
    return sharedPreferences.getInt(SharedPreferenceKeys.BREAKFAST_TOTAL_PRICE, 0);
  }

  public int getLunchTotalAmount() {
    return sharedPreferences.getInt(SharedPreferenceKeys.LUNCH_TOTAL_PRICE, 0);
  }

  public int getDinnerTotalAmount() {
    return sharedPreferences.getInt(SharedPreferenceKeys.DINNER_TOTAL_PRICE, 0);
  }

  public int getDessertTotalAmount() {
    return sharedPreferences.getInt(SharedPreferenceKeys.DESSERT_TOTAL_PRICE, 0);
  }

  public int getDrinksTotalAmount() {
    return sharedPreferences.getInt(SharedPreferenceKeys.DRINKS_TOTAL_PRICE, 0);
  }

  public void clearBreakfastOrder() {
    sharedPreferences.edit().remove(SharedPreferenceKeys.BREAKFAST).apply();
  }

  public void clearLunchOrder() {
    sharedPreferences.edit().remove(SharedPreferenceKeys.LUNCH).apply();
  }

  public void clearDinnerOrder() {
    sharedPreferences.edit().remove(SharedPreferenceKeys.DINNER).apply();
  }

  public void clearDessertOrder() {
    sharedPreferences.edit().remove(SharedPreferenceKeys.DESSERT).apply();
  }

  public void clearDrinksOrder() {
    sharedPreferences.edit().remove(SharedPreferenceKeys.DRINKS).apply();
  }

  public void clearBreakfastTotalPrice() {
    sharedPreferences.edit().remove(SharedPreferenceKeys.BREAKFAST_TOTAL_PRICE).apply();
  }

  public void clearLunchTotalPrice() {
    sharedPreferences.edit().remove(SharedPreferenceKeys.BREAKFAST_TOTAL_PRICE).apply();
  }

  public void clearDinnerTotalPrice() {
    sharedPreferences.edit().remove(SharedPreferenceKeys.BREAKFAST_TOTAL_PRICE).apply();
  }

  public void clearDessertTotalPrice() {
    sharedPreferences.edit().remove(SharedPreferenceKeys.DESSERT_TOTAL_PRICE).apply();
  }

  public void clearDrinksTotalPrice() {
    sharedPreferences.edit().remove(SharedPreferenceKeys.DRINKS_TOTAL_PRICE).apply();
  }

  public void clearAll() {
    sharedPreferences.edit().clear().apply();
  }
}
