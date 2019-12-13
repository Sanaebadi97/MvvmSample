package sanaebadi.info.mvvmsample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sanaebadi.info.mvvmsample.data.Phrase
import sanaebadi.info.mvvmsample.data.db.PhraseDao

class MainViewModel : ViewModel() {

    private val data = MutableLiveData<List<Phrase>>()

    private val phraseDao: PhraseDao
        get() {
            TODO()
        }

    fun getAllPhrases(): LiveData<List<Phrase>> = data

    fun loadAllData() {
        //TODO: load data

    }

    fun savePhrase(phrase: Phrase) {
        phraseDao.insert(phrase)
    }

}