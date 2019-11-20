package fr.airweb.news.ViewModel

import fr.airweb.news.Model.dto.NewsList
import retrofit2.Call
import retrofit2.http.GET

interface GetNewService {

    @GET("/psg/psg.json")
    fun getAllNews() : Call<NewsList>
}