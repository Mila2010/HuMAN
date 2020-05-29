package com.example.human.homless

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.human.R
import com.example.human.model.Shelters
import com.example.human.network.ShelterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

private const val WORKING = "Hemless"
private const val NOTWORKING = "HomlessNotWorking"

class HomelessOptionsFragment : Fragment() {

    lateinit var sheltersList: RecyclerView
    val adapter: HomelessAdapter = HomelessAdapter()
    private val mRetrofit: Retrofit =
            Retrofit.Builder().baseUrl("https://data.cityofnewyork.us/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    private lateinit var mSearch: SearchView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.homeless_service_fragment, container, false)
        sheltersList = view.findViewById(R.id.recyclerview)
        sheltersList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        sheltersList.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mSwipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout)
        mSearch = view.findViewById(R.id.search_shelter)
        mSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            var temp = adapter.getSheltersList()
            override fun onQueryTextSubmit(query: String): Boolean {
                filter(query, temp)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText, temp)
                return true
            }
        })
        mSwipeRefreshLayout.setOnRefreshListener { refreshItems() }

        startRetrofit(mRetrofit)
    }


    fun filter(text: String, list: List<Shelters>) {
        adapter.setSheltersList(list
                .filter {it.neighborhood.toLowerCase(Locale.getDefault()).contains(text.toLowerCase(Locale.getDefault()))})
    }

    private fun refreshItems() {
        startRetrofit(mRetrofit)
        adapter.notifyDataSetChanged()
        onItemsLoadComplete()
    }

    private fun onItemsLoadComplete() {
        mSwipeRefreshLayout.isRefreshing = false
    }

    private fun startRetrofit(retrofit: Retrofit) {
        val shelterResponse = retrofit.create(ShelterResponse::class.java)
        val call = shelterResponse.shelters
        call.enqueue(object : Callback<List<Shelters>> {
            override fun onResponse(call: Call<List<Shelters>>, response: Response<List<Shelters>>) {
                if (response.isSuccessful) {
                    Log.d(WORKING, "It is working")
                    response.body()?.let { adapter.setSheltersList(it)}
                }
            }

            override fun onFailure(call: Call<List<Shelters>>, t: Throwable) {
                print("Not working")
                Log.d(NOTWORKING, "It is not workig")
            }
        })
    }

}