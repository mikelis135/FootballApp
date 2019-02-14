package com.juangm.starwarsmvp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.juangm.starwarsmvp.R;
import com.juangm.starwarsmvp.ui.characters.view.CharactersFragment;
import com.juangm.starwarsmvp.ui.planets.view.PlanetsFragment;
import com.juangm.starwarsmvp.ui.starships.view.StarshipsFragment;

public class BottomNavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    PlanetsFragment planetsFragment;
    CharactersFragment charactersFragment;
    StarshipsFragment starshipsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        planetsFragment = new PlanetsFragment();
        charactersFragment = new CharactersFragment();
        starshipsFragment = new StarshipsFragment();

        showFragment(planetsFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_planets:
                                showFragment(planetsFragment);
                                break;
                            case R.id.action_schedules:
                                showFragment(charactersFragment);
                                break;
                            case R.id.action_music:
                                showFragment(starshipsFragment);
                                break;
                        }
                        return false;
                    }
                });
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.navigation_placeholder, fragment);
        fragmentTransaction.commit();
    }
}
