package ru.is88.stroyenergokom3;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ViewPagerFragment.OnParentBackPressed {

    private static final String VIEWPAGER_TAG = "VPT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, ViewPagerFragment.newInstance(), VIEWPAGER_TAG)
                .commit();
    }

    // TASK #2
    @Override
    public void onBackPressed() {

        ViewPagerFragment f = (ViewPagerFragment) getSupportFragmentManager().findFragmentByTag(VIEWPAGER_TAG);
        if (f != null && f.isVisible()) {
            f.childOnBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onParentBackPressed() {
        super.onBackPressed();
    }
}
