package com.pp.pagkaingpinoy;

import android.os.Build;
import android.view.View;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.pp.pagkaingpinoy.dagger.application.BaseApplication;
import com.pp.pagkaingpinoy.managers.AppActivityManager;
import com.pp.pagkaingpinoy.managers.AppConstants;
import com.pp.pagkaingpinoy.ui.activities.BaseActivity;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Inject AppActivityManager appActivityManager;

  private DatabaseReference mDatabaseBreakfast;
  private DatabaseReference mDatabaseLunch;
  private DatabaseReference mDatabaseDinner;
  private DatabaseReference mDatabaseDrinks;
  private DatabaseReference mDatabaseDessert;
  private FirebaseDatabase firebaseDatabase;

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_main);
  }

  @Override protected void setupViewElements() {
    processFireBaseControl();
    processBreakfastMenu();
    processLunchMenu();
    processDinnerMenu();
    processDrinksMenu();
    processDessertMenu();
    initLaunchStartScreen();
  }

  private void processBreakfastMenu() {
    mDatabaseBreakfast = firebaseDatabase.getReference(AppConstants.BREAKFAST_MENU);
    mDatabaseBreakfast.keepSynced(true);
    Query breakfastQuery = mDatabaseBreakfast.orderByKey();
    breakfastQuery.addValueEventListener(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
      }

      @Override public void onCancelled(DatabaseError databaseError) {

      }
    });
  }

  private void processLunchMenu() {
    mDatabaseLunch = firebaseDatabase.getReference(AppConstants.LUNCH_MENU);
    mDatabaseLunch.keepSynced(true);
    Query breakfastQuery = mDatabaseBreakfast.orderByKey();
    breakfastQuery.addValueEventListener(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
      }

      @Override public void onCancelled(DatabaseError databaseError) {

      }
    });
  }

  private void processDinnerMenu() {
    mDatabaseDinner = firebaseDatabase.getReference(AppConstants.DINNER_MENU);
    mDatabaseDinner.keepSynced(true);
    Query breakfastQuery = mDatabaseBreakfast.orderByKey();
    breakfastQuery.addValueEventListener(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
      }

      @Override public void onCancelled(DatabaseError databaseError) {

      }
    });
  }

  private void processDrinksMenu() {
    mDatabaseDrinks = firebaseDatabase.getReference(AppConstants.DRINKS_MENU);
    mDatabaseDrinks.keepSynced(true);
    Query breakfastQuery = mDatabaseBreakfast.orderByKey();
    breakfastQuery.addValueEventListener(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
      }

      @Override public void onCancelled(DatabaseError databaseError) {

      }
    });
  }

  private void processDessertMenu() {
    mDatabaseDessert = firebaseDatabase.getReference(AppConstants.DESSERT_MENU);
    mDatabaseDessert.keepSynced(true);
    Query breakfastQuery = mDatabaseBreakfast.orderByKey();
    breakfastQuery.addValueEventListener(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
      }

      @Override public void onCancelled(DatabaseError databaseError) {

      }
    });
  }

  private void processFireBaseControl() {
    firebaseDatabase = FirebaseDatabase.getInstance();
    firebaseDatabase.setPersistenceEnabled(true);
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
    //new Handler().postDelayed(() -> {
    appActivityManager.launchTableActivity(this);
    //}, 2000);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    BaseApplication.get(this).releaseMainActivityComponent();
  }
}
