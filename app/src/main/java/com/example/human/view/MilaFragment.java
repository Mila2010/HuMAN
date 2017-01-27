package com.example.human.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.human.R;

/**
 * Created by Millochka on 1/27/17.
 */

public class MilaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mila_service_fragment, container, false);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(
//                R.layout.mila_service_fragment, container, false);
////        Bundle args = getArguments();
////        ((TextView) rootView.findViewById(android.R.id.text1)).setText(
////                Integer.toString(args.getInt(ARG_OBJECT)));
//        return rootView;
//    }

}
