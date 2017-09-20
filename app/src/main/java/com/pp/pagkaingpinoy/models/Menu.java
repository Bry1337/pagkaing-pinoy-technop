package com.pp.pagkaingpinoy.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class Menu {

  @SerializedName("id") private int id;

  @SerializedName("name") private String name;

  @SerializedName("description") private String description;

  @SerializedName("image_path") private String imagePath;

  @SerializedName("quantity") private String quantity;

  @SerializedName("price") private String price;

  public Menu() {
    //Intended to be empty.
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getImagePath() {
    return imagePath;
  }

  public String getQuantity() {
    return quantity;
  }

  public String getPrice() {
    return price;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }
}
