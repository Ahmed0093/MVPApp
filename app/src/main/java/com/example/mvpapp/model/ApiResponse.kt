
package com.example.mvpapp.model


data class ApiResponse (

	val status : String,
	val copyright : String,
	val num_results : Int,
	val results : List<Results>
)