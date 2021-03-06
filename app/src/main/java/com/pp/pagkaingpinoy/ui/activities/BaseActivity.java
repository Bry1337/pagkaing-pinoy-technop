package com.pp.pagkaingpinoy.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public abstract class BaseActivity extends AppCompatActivity {

  private Unbinder unbinder;

  protected abstract void setupActivityLayout();

  protected abstract void setupViewElements();

  protected abstract void setupToolbar();

  protected abstract boolean isActionBarBackButtonEnabled();

  protected abstract void injectDaggerComponent();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupActivityLayout();
    unbinder = ButterKnife.bind(this);
    injectDaggerComponent();
    setupToolbar();
    setupViewElements();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    unbinder.unbind();
  }
}
