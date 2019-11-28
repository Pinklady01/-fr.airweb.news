package fr.airweb.news.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NewsApp_DAO {

    @Insert
    fun saveNews(news : NewsApp_Entity)

    @Query("select * from NewsApp_Entity")
    fun readNews() : List<NewsApp_Entity>

    @Query("delete from NewsApp_Entity")
    fun nukeTableNewsApp()
}