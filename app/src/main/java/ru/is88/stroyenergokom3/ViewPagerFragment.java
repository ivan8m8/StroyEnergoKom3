package ru.is88.stroyenergokom3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ViewPagerFragment extends Fragment {

    interface OnParentBackPressed {
        void onParentBackPressed();
    }

    private Toast mToast;
    private ViewPager mViewPagerLayout;

    private OnParentBackPressed mOnParentBackPressed;

    public ViewPagerFragment() {}

    public static ViewPagerFragment newInstance() {
        return new ViewPagerFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnParentBackPressed)
            mOnParentBackPressed = (OnParentBackPressed) context;
    }

    @SuppressLint("ShowToast")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToast = Toast.makeText(getContext(), "You switched a fragment", Toast.LENGTH_SHORT);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mViewPagerLayout = view.findViewById(R.id.viewPager);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        mViewPagerLayout.setAdapter(myPagerAdapter);

        // TASK #1
        mViewPagerLayout.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                // no action, ISP violation
            }

            @Override
            public void onPageSelected(int i) {
                mToast.show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                // no action, ISP violation
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    // TASK #2
    public void childOnBackPressed() {
        if (mViewPagerLayout != null) {
            if (mViewPagerLayout.getCurrentItem() != 0)
                mViewPagerLayout.setCurrentItem(0, true);
            else
                mOnParentBackPressed.onParentBackPressed();
        }
    }
}
