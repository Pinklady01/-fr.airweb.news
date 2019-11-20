package fr.airweb.news.Model.dto

import com.google.gson.annotations.SerializedName

data class NewsList(@SerializedName ("News") var news: List<NewsDTO> ) {
}