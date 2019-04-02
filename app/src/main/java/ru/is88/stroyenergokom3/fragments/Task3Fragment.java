package ru.is88.stroyenergokom3.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.is88.stroyenergokom3.R;

public class Task3Fragment extends Fragment {

    public interface OnTask3FragmentButtonClickListener {
        void onTask3FragmentButtonClicked();
    }

    private OnTask3FragmentButtonClickListener mOnTask3FragmentButtonClickListener;
    
    public Task3Fragment() {}

    public static Task3Fragment newInstance() {
        return new Task3Fragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnTask3FragmentButtonClickListener)
            mOnTask3FragmentButtonClickListener = (OnTask3FragmentButtonClickListener) context;
        else
            throw new IllegalStateException("OnTask3FragmentButtonClickListener must be implemented");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnTask3FragmentButtonClickListener.onTask3FragmentButtonClicked();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
