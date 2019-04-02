package ru.is88.stroyenergokom3.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.is88.stroyenergokom3.R;

public class Task3Fragment2 extends Fragment {

    public Task3Fragment2() {}

    public static Task3Fragment2 newInstance() {
        Log.d("KSI", "A new instance of Task3Fragment2 has just been created");
        return new Task3Fragment2();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2_task3, container, false);
    }
}
