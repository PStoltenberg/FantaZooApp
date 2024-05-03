package com.example.fantazooapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import com.example.fantazooapp.Fragments.AnimalFragment;
import com.example.fantazooapp.Fragments.HabitatFragment;
import com.example.fantazooapp.Fragments.StartFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initGui();
        fragmentChanger(StartFragment.class);

    }

    void initGui(){
        findViewById(R.id.nav_btnAnimal).setOnClickListener(v -> {
            fragmentChanger(AnimalFragment.class);
        });

        findViewById(R.id.nav_btnHabitat).setOnClickListener(v -> {
            fragmentChanger(HabitatFragment.class);
        });

        findViewById(R.id.nav_btnZooKeeper).setOnClickListener(v -> {
            // fragmentChanger(WatchlistFragment.class);
        });

        findViewById(R.id.topNav_btnSearch).setOnClickListener(v -> {
            // fragmentChanger(SearchFragment.class);
        });

    }

    public void fragmentChanger(Class c){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, c, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();
    }
}