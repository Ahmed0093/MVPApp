package com.example.mvpapp.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

//@Parcelize
//@SuppressLint("ParcelCreator")
data class Metadata (
	val url : String,
	val format : String,
	val height : Int,
	val width : Int
): Serializable