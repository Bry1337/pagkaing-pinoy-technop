/*
 * Copyright (c) 2017. GreatFeat Services, Inc.
 */

package com.pp.pagkaingpinoy.ui.activities.dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.ui.utils.OnBindViewListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */
public class NavMenuAdapter extends RecyclerView.Adapter<NavMenuAdapter.ViewHolder> {

  private DashboardActivity activity;
  private final List<String> navMenus = new ArrayList<>();

  public NavMenuAdapter(DashboardActivity activity) {
    this.activity = activity;
    initNavMenu();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_nav_menu_dashboard, parent, false));
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.onBind(navMenus.get(position));
  }

  @Override public int getItemCount() {
    return navMenus.size();
  }

  private void initNavMenu() {
    navMenus.add(activity.getString(R.string.breakfast));
    navMenus.add(activity.getString(R.string.lunch));
    navMenus.add(activity.getString(R.string.dinner));
    navMenus.add(activity.getString(R.string.drinks));
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements OnBindViewListener {

    @BindView(R.id.ivMenuIcon) ImageView ivPhoto;
    @BindView(R.id.tvMenuName) TextView tvName;
    View itemView;

    public ViewHolder(View itemView) {
      super(itemView);
      this.itemView = itemView;
      ButterKnife.bind(this, itemView);
    }

    @Override public void onBind(Object object) {
      String navItem = (String) object;
      displayNavMenuItem(navItem);
      itemView.setOnClickListener(view -> {
        activity.dashboardPresenter.onSingleItemClick(navItem);
      });
    }

    private void displayNavMenuItem(String navItem) {
      if (navItem != null) {
        tvName.setText(navItem);
      }
    }
  }
}
