package sanaebadi.info.mvvmsample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phrase")
data class Phrase(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var text: String
)