package fr.airweb.news.Model.dto

import com.google.gson.annotations.SerializedName

data class NewsDTO (@SerializedName ("id") var nid: Int = 0, var type: String, var date: Int, var title: Long, var content: String, var dateformated: String){}