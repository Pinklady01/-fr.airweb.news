package fr.airweb.news.Model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(NewsApp_Entity::class)],version = 1)
abstract class NewsApp_DB : RoomDatabase() {

    abstract fun useDAO(): NewsApp_DAO
}