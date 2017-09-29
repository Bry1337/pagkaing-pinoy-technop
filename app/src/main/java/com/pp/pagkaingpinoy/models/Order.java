package com.pp.pagkaingpinoy.models;

import com.google.firebase.database.Exclude;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bry1337 on 29/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class Order {

  private static final String SERVED_DEFAULT_VALUE = "IN PROGRESS";

  @SerializedName("id") private int id;

  @SerializedName("orders") private StringBuilder orders = new StringBuilder();

  @SerializedName("amount") private String amount;

  @SerializedName("table_number") private String tableNumber;

  @SerializedName("served") private String served;

  public Order() {
    // Intended to be empty.
  }

  public Order(int id, StringBuilder orders, String amount, String tableNumber) {
    this.id = id;
    this.orders = orders;
    this.amount = amount;
    this.tableNumber = tableNumber;
    this.served = SERVED_DEFAULT_VALUE;
  }

  @Exclude public Map<String, Object> toMap() {
    HashMap<String, Object> result = new HashMap<>();
    result.put("id", id);
    result.put("orders", orders.toString());
    result.put("amount", amount);
    result.put("table_number", tableNumber);
    result.put("served", served);

    return result;
  }
}
