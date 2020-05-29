package com.example.human.donate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.human.R

private const val RED_CROSS = "https://www.redcross.org/donate/donation"
private const val COLATION_FOR_HOMELESS = "https://www.coalitionforthehomeless.org/donate/"
private const val VETERAN_DONATION = "https://interland3.donorperfect.net/weblink/weblink.aspx?name=vetsinc&id=1"
private const val TARGET_URL = "MYURL"

class DonateFragment: Fragment(), View.OnClickListener {

    lateinit var mRedCross: CardView
    lateinit var mColationforHomeless: CardView
    lateinit var mVeterans: CardView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.mila_service_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRedCross = view.findViewById(R.id.red_cross)
        mColationforHomeless = view.findViewById(R.id.colation_for_homeless)
        mRedCross.setOnClickListener(this)
        mColationforHomeless.setOnClickListener(this)
        mVeterans = view.findViewById(R.id.veteran_donation)
        mVeterans.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.red_cross -> donate(RED_CROSS)
            R.id.colation_for_homeless -> donate(COLATION_FOR_HOMELESS)
            R.id.veteran_donation -> donate(VETERAN_DONATION)
        }
    }

    private fun donate(targetUrl: String) {
        val intent = Intent(context, DonateWebViewActivity::class.java)
        intent.putExtra(TARGET_URL, targetUrl)
        activity?.startActivity(intent)
    }
}