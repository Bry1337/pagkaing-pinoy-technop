package com.pp.pagkaingpinoy.models;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class Menu extends HashMap<String, Object> {

  @SerializedName("id") private long id;

  @SerializedName("name") private String name;

  @SerializedName("description") private String description;

  @SerializedName("image_path") private String imagePath;

  @SerializedName("quantity") private String quantity;

  @SerializedName("price") private long price;

  public Menu() {
    //Intended to be empty.
  }

  public Menu(int id, String name, String description, String imagePath, String quantity, long price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.imagePath = imagePath;
    this.quantity = quantity;
    this.price = price;
  }

  public Menu(HashMap<String, Object> hashMap) {
    this.id = (long) hashMap.get("id");
    this.name = (String) hashMap.get("name");
    this.description = (String) hashMap.get("description");
    this.price = (long) hashMap.get("price");
    this.imagePath = (String) hashMap.get("image_path");
  }

  public long getId() {
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

  public long getPrice() {
    return price;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }
}
