package sanaebadi.info.mvvmsample.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import sanaebadi.info.mvvmsample.R
import sanaebadi.info.mvvmsample.data.Phrase
import sanaebadi.info.mvvmsample.view.adapter.MainAdapter
import sanaebadi.info.mvvmsample.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val adapter: MainAdapter by lazy {
        MainAdapter()
    }
    // setup the ViewModel
    private val mainViewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_phrase.adapter = adapter


        //listen for change and update the ui
        mainViewModel.getAllPhrases().observe(this, Observer { phrases ->
            if (phrases.isEmpty()) {
                txt_phrase_count.text = getString(R.string.no_data)
                return@Observer


            }

            adapter.addAl(phrases)

        })
        //load all data
        mainViewModel.loadAllData()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (R.id.action_add == item.itemId) {
            showDialogNewWord()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Show a input dialog to type a phrase
     * and add it in database
     */
    private fun showDialogNewWord() {
        val edtPhrase = EditText(this)

        AlertDialog.Builder(this)
            .setTitle("Type a phrase")
            .setView(edtPhrase)
            .setNegativeButton("Cancel", null)
            .setPositiveButton("Save") { dialogInterface, i ->
                val text = edtPhrase.text.toString()

                // if there is a text, save it
                if (!text.trim { it <= ' ' }.isEmpty()) {
                    val phrase = Phrase(1, text = text)
                    mainViewModel.savePhrase(phrase)

                    //TODO: save in room database
                }
            }
            .create()
            .show() // show dialog
    }
}
