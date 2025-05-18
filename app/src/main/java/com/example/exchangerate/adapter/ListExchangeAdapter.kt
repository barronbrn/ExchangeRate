package com.example.exchangerate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangerate.model.Country
import com.example.exchangerate.R

class ListExchangeAdapter (private val listExchange: ArrayList<Country>,
                           private val onItemClick: (Country) -> Unit) : RecyclerView.Adapter<ListExchangeAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Country)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListExchangeAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_exchange, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (flag, countryName, buy, sell) = listExchange[position]
        holder.imgFlag.setImageResource(flag)
        holder.txtCountryName.text = countryName
        holder.txtPriceBuy.text = buy
        holder.txtPriceSell.text = sell
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listExchange[position])
        }
    }

    override fun getItemCount(): Int = listExchange.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgFlag: ImageView = itemView.findViewById(R.id.img_flag)
        var txtCountryName: TextView = itemView.findViewById(R.id.txt_country_name)
        var txtPriceBuy: TextView = itemView.findViewById(R.id.txt_price_buy)
        var txtPriceSell: TextView = itemView.findViewById(R.id.txt_price_sell)

    }

}
