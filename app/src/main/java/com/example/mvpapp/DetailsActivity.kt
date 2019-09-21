package com.example.mvpapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvpapp.constants.Constants
import com.example.mvpapp.constants.Constants.SELECTED_Article
import com.example.mvpapp.model.Results
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity()  {
    private var selectedArticle: Results? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        getIntentData()

    }


    private fun getIntentData() {
        if (!intent.hasExtra(SELECTED_Article)) {
            Log.d("INTENT", "getIntentData: could not find selected article")
            finish()
            return
        }

        selectedArticle = intent.getSerializableExtra(SELECTED_Article) as Results?
        tvTitleDetails.text = selectedArticle?.title
//        tvPriceDetails.text = selectedArticle?.price.toString()+"$"
        tvDescription.text = selectedArticle?.section
//        glideRequestManager
//            .load(selectedArticle?.image?.link)
//            .placeholder(R.drawable.ic_mtrl_chip_checked_circle)
//            .apply(RequestOptions().override(selectedArticle?.image?.width?.toInt()!!, selectedArticle?.image?.height?.toInt()!!))
//            .into(ivAvatarDetails)

    }
}
