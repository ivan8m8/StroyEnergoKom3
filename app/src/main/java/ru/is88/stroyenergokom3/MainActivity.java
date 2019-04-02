package ru.is88.stroyenergokom3;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import ru.is88.stroyenergokom3.fragments.Task3Fragment;
import ru.is88.stroyenergokom3.fragments.Task3Fragment2;
import ru.is88.stroyenergokom3.fragments.ViewPagerFragment;

public class MainActivity extends AppCompatActivity
        implements ViewPagerFragment.OnParentBackPressed, Task3Fragment.OnTask3FragmentButtonClickListener {

    private static final String VIEWPAGER_TAG = "VPT";
    private Task3Fragment2 mTask3Fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTask3Fragment2 = Task3Fragment2.newInstance();

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

    @Override
    public void onTask3FragmentButtonClicked() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, mTask3Fragment2)
                .addToBackStack(null)
                .commit();
    }
}
