package com.pp.pagkaingpinoy;

import android.os.Build;
import android.os.Handler;
import android.view.View;
import com.pp.pagkaingpinoy.dagger.application.BaseApplication;
import com.pp.pagkaingpinoy.managers.AppActivityManager;
import com.pp.pagkaingpinoy.ui.activities.BaseActivity;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Inject AppActivityManager appActivityManager;

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_main);
  }

  @Override protected void setupViewElements() {
    initLaunchStartScreen();
  }

  @Override protected void setupToolbar() {

  }

  @Override protected boolean isActionBarBackButtonEnabled() {
    return false;
  }

  @Override protected void injectDaggerComponent() {
    BaseApplication.get(this).createMainActivityComponent(this).inject(this);
  }

  @Override public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (hasFocus && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      getWindow().getDecorView()
          .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
              | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
              | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
              | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
              | View.SYSTEM_UI_FLAG_FULLSCREEN
              | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
  }

  private void initLaunchStartScreen() {
    new Handler().postDelayed(() -> {
      appActivityManager.launchTableActivity(this);
    }, 2000);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    BaseApplication.get(this).releaseMainActivityComponent();
  }
}
