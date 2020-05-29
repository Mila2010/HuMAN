package com.example.human.donate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.human.R;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

/**
 * Created by Millochka on 1/27/17.
 */

public class DonateFragment extends Fragment implements ViewGroup.OnClickListener {

    private static final String TARGET_URL ="MYURL" ;
    CardView mRedCross;
    CardView mColationforHomeless;
    CardView mVeterans;

    private final String RED_CROSS = "https://www.redcross.org/donate/donation";
    private final String COLATION_FOR_HOMELESS = "https://www.coalitionforthehomeless.org/donate/";
    private final String VETERAN_DONATION = "https://interland3.donorperfect.net/weblink/weblink.aspx?name=vetsinc&id=1";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mila_service_fragment, container, false);
    }
    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);

        mRedCross = (CardView) view.findViewById(R.id.red_cross);
        mColationforHomeless = (CardView) view.findViewById(R.id.colation_for_homeless);
        mRedCross.setOnClickListener(this);
        mColationforHomeless.setOnClickListener(this);
        mVeterans=(CardView) view.findViewById(R.id.veteran_donation);
        mVeterans.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.red_cross:

                donate(RED_CROSS);
                break;
            case R.id.colation_for_homeless:
                donate(COLATION_FOR_HOMELESS);

                break;

            case R.id.veteran_donation:
                donate(VETERAN_DONATION);

            break;
        }


    }

    public void donate(String targetUrl){


        Intent intent = new Intent(getContext(), DonateWebView.class);
        intent.putExtra(TARGET_URL, targetUrl);
        getActivity().startActivity(intent);
    }
}
