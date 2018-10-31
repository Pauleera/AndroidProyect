package com.example.pfma9.mascarainfo104;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import android.view.View;
import android.widget.FrameLayout;


public class Main extends AppCompatActivity{

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private CursosFragment cursosFragment;
    private ForoFragment foroFragment;
    private PlanFragment planFragment;
    private MaterialFragment materialFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainNav = findViewById(R.id.btm_nav);
        mMainFrame = findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        cursosFragment = new CursosFragment();
        foroFragment = new ForoFragment();
        planFragment = new PlanFragment();
        materialFragment = new MaterialFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.id_Home:
                        setFragment(homeFragment);
                        return true;
                    case R.id.id_Cursos:
                        setFragment(cursosFragment);
                        return  true;
                    case R.id.id_Foro:
                        setFragment(foroFragment);
                        return  true;
                    case R.id.id_Planificacion:
                        setFragment(planFragment);
                        return  true;
                    case R.id.id_Material:
                        setFragment(materialFragment);
                        return  true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_nav, fragment);
        fragmentTransaction.commit();
    }

    public void onClick(View v){
        homeFragment.onClick(v);
    }

}
