package com.example.mvpapp.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.io.Serializable


data class Media (

	val type: String,
	val subtype: String,
	val caption: String,
	val copyright: String,
	val approved_for_syndication: Int,
	@SerializedName("media-metadata ") val metadata: List<Metadata>
): Serializable