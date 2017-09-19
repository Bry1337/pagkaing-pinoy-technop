package com.pp.pagkaingpinoy.ui.activities.tablenumber;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import com.pp.pagkaingpinoy.R;
import com.pp.pagkaingpinoy.dagger.application.BaseApplication;
import com.pp.pagkaingpinoy.managers.AppActivityManager;
import com.pp.pagkaingpinoy.ui.activities.ToolBarBaseActivity;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by bry1337 on 19/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class TableNumberActivity extends ToolBarBaseActivity {

  @Inject AppActivityManager appActivityManager;

  @BindView(R.id.edtTableNumber) EditText edtTableNumber;
  @BindView(R.id.btnDone) Button btnDone;

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_table_number);
  }

  @Override protected void setupViewElements() {

  }

  @Override protected boolean isActionBarBackButtonEnabled() {
    return true;
  }

  @Override protected void injectDaggerComponent() {
    BaseApplication.get(this).createTableNumberComponent(this).inject(this);
  }

  @OnClick(R.id.btnDone) void launchDashboardActivity() {
    if (validateTableNumber()) {
      appActivityManager.launchDashboardActivity(this, edtTableNumber.getText().toString());
    }
  }

  private boolean validateTableNumber() {
    if (StringUtils.isEmpty(edtTableNumber.getText().toString())) {
      Toast.makeText(this, getString(R.string.table_number_cannot_be_empty), Toast.LENGTH_SHORT).show();
      return false;
    }
    return true;
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    BaseApplication.get(this).releaseTableNumberComponent();
  }
}
