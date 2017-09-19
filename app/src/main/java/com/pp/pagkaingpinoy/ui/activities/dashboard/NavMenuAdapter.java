/*
 * Copyright (c) 2017. GreatFeat Services, Inc.
 */

package com.pp.pagkaingpinoy.ui.activities.dashboard;

import android.content.Context;
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

  private DashboardActivity homeActivity;
  private Context context;
  private final List<String> navMenus = new ArrayList<>();

  public NavMenuAdapter(Context context) {
    this.context = context;
    initNavMenu();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_nav_menu_dashboard, parent, false));
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.onBind(navMenus.get(position));
  }

  @Override public int getItemCount() {
    return navMenus.size();
  }

  private void initNavMenu() {
    navMenus.add(context.getString(R.string.breakfast));
    navMenus.add(context.getString(R.string.lunch));
    navMenus.add(context.getString(R.string.dinner));
    navMenus.add(context.getString(R.string.drinks));
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements OnBindViewListener {

    @BindView(R.id.ivMenuIcon) ImageView ivPhoto;
    @BindView(R.id.tvMenuName) TextView tvName;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    @Override public void onBind(Object object) {
      String navItem = (String) object;
      if(navItem != null){
        tvName.setText(navItem);
      }
    }
  }
}
