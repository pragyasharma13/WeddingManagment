package com.example.weddingmanagemnt1.MainUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.weddingmanagemnt1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;


public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private NavController navController;
    // SectionsPagerAdapterBottom sectionsPagerAdapter;

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //sectionsPagerAdapter = new SectionsPagerAdapterBottom(this, getSupportFragmentManager());

        setupNavigation();

    }

    private void setupNavigation() {

        navController = Navigation.findNavController(this, R.id.main_fragment);

        appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()) //Pass the ids of fragments from nav_graph which you dont want to show back button in toolbar
                        .setDrawerLayout(drawerLayout)
                        .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration); //Setup toolbar with back button and drawer icon according to appBarConfiguration
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        /*
         ** Listener for bottomNavigation must be called after been setupWithNavController
         ** This command will override NavigationUI.setupWithNavController(bottomNavigationView, navController)
         ** and the automatic transaction between fragments is lost
         * */
        //bottomNavigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {

        // replace navigation up button with nav drawer button when on start destination
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        // https://stackoverflow.com/questions/55990820/how-to-use-navigation-drawer-and-bottom-navigation-simultaneously-navigation-a
        // https://stackoverflow.com/questions/58345696/how-to-use-android-navigation-component-bottomnavigationview-navigationview
        // https://stackoverflow.com/questions/55667686/how-to-coordinate-a-navigation-drawer-with-a-buttom-navigation-view
        // https://ux.stackexchange.com/questions/125627/is-it-okay-to-use-both-nav-drawer-and-bottom-nav-in-home-screen-of-an-android-ap?newreg=da5d1cea03db496982a00b256647728d
        /**  if (menuItem.getItemId() == R.id.main_menusidehome) {
         //Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
         // startActivity(intent);
         //  Log.i(TAG, "onNavigationItemSelected: conta");
         }
         if (menuItem.getItemId() == R.id.main_menusideshop) {
         //Log.i(TAG, "onNavigationItemSelected: compra");
         }
         if (menuItem.getItemId() == R.id.main_menusidesearch) {
         //Log.i(TAG, "onNavigationItemSelected: estatistica");
         }**/

        return true;
    }
}