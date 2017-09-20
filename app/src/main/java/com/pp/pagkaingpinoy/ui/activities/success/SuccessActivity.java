package com.pp.pagkaingpinoy.ui.activities.success;

import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.ui.activities.ToolBarBaseActivity;

/**
 * Created by bry1337 on 20/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class SuccessActivity extends ToolBarBaseActivity {

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_success);
  }

  @Override protected void setupViewElements() {

  }

  @Override protected boolean isActionBarBackButtonEnabled() {
    return true;
  }

  @Override protected void injectDaggerComponent() {

  }
}
