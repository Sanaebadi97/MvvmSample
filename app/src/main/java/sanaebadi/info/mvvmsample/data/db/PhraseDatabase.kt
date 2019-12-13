package sanaebadi.info.mvvmsample.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sanaebadi.info.mvvmsample.data.Phrase

@Database(entities = [Phrase::class], version = 1)
abstract class PhraseDatabase : RoomDatabase() {

    abstract fun phraseDao(): PhraseDao


    companion object {
        private var INSTANCE: PhraseDatabase? = null
        fun getInstance(context: Context): PhraseDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context, PhraseDatabase::class.java, "phrase_db"
                )

                    .addMigrations()
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE!!
        }
    }
}