package com.example.human.disabled;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.human.R;

import androidx.fragment.app.Fragment;

/**
 * Created by Millochka on 2/5/17.
 */

public class DisabledFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.disabled_service_fragment, container, false);

        return view;
    }

}
