package fr.airweb.news.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/***
 * Création of the "news" Entity table
 * with "nid" as the primary key.
 */
@Entity
class NewsApp_Entity {

    @PrimaryKey
    var nid: Int? = 0

    @ColumnInfo (name = "TYPE")
    var type: String? = null

    @ColumnInfo (name = "DATE")
    var date: String? = null

    @ColumnInfo (name = "TITLE")
    var title: String? = null

    @ColumnInfo (name = "CONTENT")
    var content: String? = null

    @ColumnInfo (name = "DATEFORMATED")
    var dateformated: String? = null
}