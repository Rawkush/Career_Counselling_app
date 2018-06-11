package com.example.ankush.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class explore extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private selectionPageAdapter mySelectionPageAdapter;
    private ViewPager mViewPager;
    private final String FILE_NAME = "RemmemberMe.txt";
    private checker checker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mySelectionPageAdapter = new selectionPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        checker = new checker();

        if(checker.check()){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Goto main page",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            checker.creatingFile();
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Goto login page",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
/*
        if(!checking.check()){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Goto Login page",
                    Toast.LENGTH_SHORT);

            checking.createAndLogIn();

            toast.show();
        }else{

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Goto main page",
                    Toast.LENGTH_SHORT);

            toast.show();
        }
*/


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.scholarship) {

            Intent intent = new Intent(this, scholoarshipTabbedActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        //selectionPageAdapter adapter= new selectionPageAdapter(getSupportFragmentManager());
        mySelectionPageAdapter.addFreagment(new AlphabetDisplayListActivity(), "List");
        mySelectionPageAdapter.addFreagment(new tab2(), "tab2");
        viewPager.setAdapter(mySelectionPageAdapter);
    }

    public class checker {

        private boolean check;

        public checker() {
            check = false;
        }

        // creating file
        public void creatingFile() {

            // String text = mEditText.getText().toString();
            FileOutputStream fos = null;

            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                // fos.write(text.getBytes());

                //   mEditText.getText().clear();
                Toast.makeText(getApplicationContext(), "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // for writing enable below code to catch error
            /*
            catch (IOException e) {
                e.printStackTrace();
            }
            */ finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }


        public boolean check() {

            FileInputStream fis = null;

            try {
                fis = openFileInput(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String text;
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Goto main page",
                        Toast.LENGTH_SHORT);
                check = true;
                toast.show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();


                check = false;

            }
            /*
            catch (IOException e) {
                e.printStackTrace();
            }
            */ finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return check;

        }


    }
}