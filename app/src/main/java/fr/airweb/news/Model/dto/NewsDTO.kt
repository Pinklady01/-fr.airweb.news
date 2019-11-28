package fr.airweb.news.Model.dto

import com.google.gson.annotations.SerializedName

data class NewsDTO (var nid: Int = 0,
                    var type: String? = null,
                    var date: String? = null,
                    var title: String? = null,
                    var picture: String? = null,
                    var content: String? = null,
                    var dateformated: String? = null)