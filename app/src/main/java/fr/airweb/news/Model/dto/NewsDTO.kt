package fr.airweb.news.Model.dto

import com.google.gson.annotations.SerializedName

data class NewsDTO (var nid: Int = 0,
                    var type: String,
                    var date: String,
                    var title: String,
                    var content: String,
                    var dateformated: String)