package com.example.exchangerate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exchangerate.databinding.ActivityDetailBinding
import com.example.exchangerate.model.Country

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari intent
        val country = intent.getParcelableExtra<Country>(MainActivity.EXTRA_COUNTRY)

        country?.let {
            binding.txtCountryName.text = it.countryName
            binding.txtBuy.text = "Harga Beli: ${it.buy}"
            binding.txtSell.text = "Harga Jual: ${it.sell}"
        }
    }
}
