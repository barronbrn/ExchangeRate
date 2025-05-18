/*
Nama        : Dani Herawan
NIM         : 10122331
Kelas       : P.ANDRO 4
Tanggal     : Minggu, 18 Mei 2025
Jam Selesai : 14:35
*/

package com.example.exchangerate

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exchangerate.model.Country
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangerate.adapter.ListExchangeAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var rvExchange: RecyclerView
    private val list = ArrayList<Country>()

    companion object {
        const val EXTRA_COUNTRY = "EXTRA_COUNTRY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        rvExchange = findViewById(R.id.rv_exchange)
        rvExchange.setHasFixedSize(true)

        list.addAll(getListOfExchange())
        showRecyclerList()

    }

    fun getListOfExchange(): ArrayList<Country> {
        val dataFlag = resources.obtainTypedArray(R.array.data_flag)
        val dataCountryName = resources.getStringArray(R.array.data_country)
        val dataBuy = resources.getStringArray(R.array.data_price_buy)
        val dataSell = resources.getStringArray(R.array.data_price_sell)
        val listCountry = ArrayList<Country>()
        for (i in dataCountryName.indices) {
            val country = Country(dataFlag.getResourceId(i, -1), dataCountryName[i], dataBuy[i], dataSell[i])
            listCountry.add(country)
        }
        return listCountry
    }

    fun showRecyclerList() {
        val listExchangeAdapter = ListExchangeAdapter(list) {
            data -> showSelectedExchange(data)
        }
        listExchangeAdapter.setOnItemClickCallback(object : ListExchangeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Country) {
                showSelectedExchange(data)
            }
        })

        rvExchange.layoutManager = LinearLayoutManager(this)
        rvExchange.adapter = listExchangeAdapter
        rvExchange.setHasFixedSize(true)

    }

    private fun showSelectedExchange(exchange: Country) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(EXTRA_COUNTRY, exchange)
        startActivity(intent)
    }
}
