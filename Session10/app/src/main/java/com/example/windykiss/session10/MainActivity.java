package com.example.windykiss.session10;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String TAG = MainActivity.class.getName();

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawer;
    private MenuItem menuItem;
    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        //Floating Button


        //Drawer layout & Navigation View
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        setDefaultMain();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        menuItem = menu.findItem(R.id.action_change);
        menuItem.setVisible(false);
        //lay search View
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        searchView = (SearchView) menuItem.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if( id == R.id.action_send){
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        switch (id) {
            case R.id.nav_article:
                setTitle("Article");

                changeFragment(new Fragment01(), true);

                setDefaultMenuBar();


                menuItem.setIcon(R.drawable.ic_menu_share);
                menuItem.setVisible(true);
                menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "WindyKiss");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "This is my fking awesome app!!! https://www.facebook.com/fly.windykiss");
                        startActivity(Intent.createChooser(sharingIntent, "Share via"));
                        return false;
                    }
                });


                break;
            case R.id.nav_pay:
                setTitle("Pay");

                changeFragment(new Fragment02(), true);

                menuItem.setIcon(R.drawable.ic_menu_send);
                menuItem.setVisible(true);
                menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        actionBar.hide();

                        changeFragment(new Fragment03(), true);
                        return false;
                    }
                });
                break;
            case R.id.nav_setting:
                setTitle("Setting");

                changeFragment(new Fragment04(), true);
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void changeFragment(Fragment fragment, boolean addToStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, fragment);
        if (addToStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    public void setDefaultMenuBar() {
        actionBar.show();

        toggle.setDrawerIndicatorEnabled(false);
        //set icon
        toggle.setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_black_24px);

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "POP");
                Log.d(TAG, String.format("PopStack Size : %d", getSupportFragmentManager().getBackStackEntryCount()));
                getSupportFragmentManager().popBackStack();
                setDefaultMain();
            }
        });
    }

    public void setDefaultMain() {
        //edit toggle
        //remove basic
        toggle.setDrawerIndicatorEnabled(false);
        //set icon
        toggle.setHomeAsUpIndicator(R.drawable.ic_menu_black_24px);
        //add Listener
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
                toggle.syncState();
            }
        });


        menuItem.setVisible(false);
        setTitle("MainActivity");

    }

    public void popAll() {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        actionBar.show();
        setDefaultMain();
    }

}
