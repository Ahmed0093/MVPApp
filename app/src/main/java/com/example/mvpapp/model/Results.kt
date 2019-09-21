package com.example.mvpapp.model
data class Results (

	val url : String,
	val adx_adx_keywordswords : String,
	val column : String,
	val section : String,
	val byline : String,
	val type : String,
	val title : String,
	val abstract : String,
	val published_date : String,
	val source : String,
	val id : Long,
	val asset_id : Long,
	val views : Int,
	val des_facet : Object,
	val org_facet :Object,
	val per_facet : Object,
	val geo_facet : Object,
	val media : List<Media>,
	val uri : String
) {
	constructor() : this("","","","","","","","","","",3,2,1,Object(),Object(),Object(),Object(), emptyList(),"")
}