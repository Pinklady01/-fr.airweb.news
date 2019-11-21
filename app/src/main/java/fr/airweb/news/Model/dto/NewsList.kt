package fr.airweb.news.Model.dto

import com.google.gson.annotations.SerializedName

data class NewsList(var news: List<NewsDTO>? = null)