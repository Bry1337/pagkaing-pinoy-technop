package com.pp.pagkaingpinoy.ui.activities.drinks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.models.Menu;
import com.pp.pagkaingpinoy.ui.utils.OnBindViewListener;
import com.pp.pagkaingpinoy.ui.utils.OnSingleItemClickListener;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by bry1337 on 20/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.ViewHolder> {

  private DrinksActivity activity;
  private List<Menu> breakfastList = new ArrayList<>();
  private OnSingleItemClickListener listener;

  public DrinksAdapter(DrinksActivity activity, List<Menu> breakfastList, OnSingleItemClickListener listener) {
    this.activity = activity;
    this.breakfastList = breakfastList;
    this.listener = listener;
  }

  @Override public DrinksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new DrinksAdapter.ViewHolder(
        LayoutInflater.from(activity).inflate(R.layout.item_breakfast_cardview, parent, false));
  }

  @Override public void onBindViewHolder(DrinksAdapter.ViewHolder holder, int position) {
    Menu breakfast = breakfastList.get(position);
    holder.onBind(breakfast);
  }

  @Override public int getItemCount() {
    return breakfastList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements OnBindViewListener {

    @BindView(R.id.ivFood) ImageView ivFood;
    @BindView(R.id.tvFoodName) TextView tvFoodName;
    @BindView(R.id.tvDescription) TextView tvDescription;
    @BindView(R.id.tvPrice) TextView tvPrice;
    @BindView(R.id.edtQuantity) EditText edtQuantity;
    @BindView(R.id.btnAddToOrder) Button btnAddToOrder;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    @Override public void onBind(Object object) {
      Menu menu = (Menu) object;
      displayDessertItem(menu);

      btnAddToOrder.setOnClickListener(view -> {
        if (validate()) {
          handleAddToOrder(menu);
        }
      });
    }

    private void handleAddToOrder(Menu breakfast) {
      breakfast.setQuantity(edtQuantity.getText().toString());
      listener.onSingleItemClick(breakfast);
      edtQuantity.getText().clear();
      Toast.makeText(activity, activity.getString(R.string.your_order_has_been_added), Toast.LENGTH_SHORT).show();
    }

    private void displayDessertItem(Menu breakfast) {
      if (breakfast != null) {
        //Uri uri = Uri.parse(breakfast.getImagePath());
        //ivFood.setImageURI(uri);
        tvFoodName.setText(breakfast.getName());
        tvDescription.setText(breakfast.getDescription());
        tvPrice.setText(String.format("P %s", breakfast.getPrice()));
        Glide.with(activity).load(breakfast.getImagePath()).centerCrop().crossFade().into(ivFood);
      }
    }

    private boolean validate() {
      if (StringUtils.isEmpty(edtQuantity.getText().toString())) {
        Toast.makeText(activity, activity.getString(R.string.quantity_cannot_be_empty), Toast.LENGTH_SHORT).show();
        return false;
      } else if (edtQuantity.getText().toString().equals("0")) {
        Toast.makeText(activity, activity.getString(R.string.quantity_cannot_be_zero), Toast.LENGTH_SHORT).show();
        return false;
      }
      return true;
    }
  }
}
