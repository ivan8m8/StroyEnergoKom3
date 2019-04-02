package ru.is88.stroyenergokom3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ru.is88.stroyenergokom3.fragments.PageFragment;
import ru.is88.stroyenergokom3.fragments.Task3Fragment;

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 1: return Task3Fragment.newInstance();
            default: return PageFragment.newInstance(position + 1);
        }
    }

    @Override
    public int getCount() {

        return 3;
    }
}
