package com.pp.pagkaingpinoy.ui.activities.lunch;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.models.Menu;
import com.pp.pagkaingpinoy.ui.utils.OnBindViewListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class LunchAdapter extends RecyclerView.Adapter<LunchAdapter.ViewHolder> {

  private LunchActivity activity;
  private List<Menu> breakfastList = new ArrayList<>();

  public LunchAdapter(LunchActivity activity, List<Menu> breakfastList) {
    this.activity = activity;
    this.breakfastList = breakfastList;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_breakfast_cardview, parent, false));
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
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

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    @Override public void onBind(Object object) {
      Menu breakfast = (Menu) object;
      displayBreakfastItem(breakfast);
    }

    private void displayBreakfastItem(Menu breakfast) {
      if (breakfast != null) {
        Uri uri = Uri.parse(breakfast.getImagePath());
        ivFood.setImageURI(uri);
        tvFoodName.setText(breakfast.getName());
        tvDescription.setText(breakfast.getDescription());
      }
    }
  }
}
