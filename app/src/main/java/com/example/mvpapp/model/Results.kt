package com.example.mvpapp.model

import kotlinx.android.parcel.RawValue
import java.io.Serializable

//@Parcelize
//@SuppressLint("ParcelCreator")
data class Results(

    val url: String,
    val adx_adx_keywordswords: String,
    val column: String,
    val section: String,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    val published_date: String,
    val source: String,
    val id: Long,
    val asset_id: Long,
    val views: Int,
    val des_facet: @RawValue Object?,
    val org_facet: @RawValue Object?,
    val per_facet: @RawValue Object?,
    val geo_facet: @RawValue Object?,
    val media: @RawValue List<Media>,
    val uri: String
) : Serializable