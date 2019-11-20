package fr.airweb.news.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    object RetrofitClientInstance {
        private var retrofit: Retrofit? = null
        private val BASE_URL = "https://airweb-demo.airweb.fr/"

        val retrofitInstance: Retrofit?
            get(){
                if(retrofit == null){
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        // url json: https://airweb-demo.airweb.fr/psg/psg.json
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }

                return retrofit
            }

    }