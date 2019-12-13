package sanaebadi.info.mvvmsample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sanaebadi.info.mvvmsample.data.Phrase

@Dao
interface PhraseDao {

    @Insert
    fun insert(phrase: Phrase)

    @Query("SELECT * FROM phrase")
    fun getAllPhrase(): List<Phrase>
}