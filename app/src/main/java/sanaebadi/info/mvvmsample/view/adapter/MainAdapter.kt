package sanaebadi.info.mvvmsample.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_phrase.view.*
import sanaebadi.info.mvvmsample.R
import sanaebadi.info.mvvmsample.data.Phrase

class MainAdapter(private val data: ArrayList<Phrase> = arrayListOf()) :
    RecyclerView.Adapter<PhraseHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhraseHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_phrase, parent, false)

        return PhraseHolder(view)

    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PhraseHolder, position: Int) {
        holder.bind(data[position])
    }


    fun add(phrase: Phrase) {
        data.add(phrase)
        notifyDataSetChanged()

    }

    fun addAl(phrasees: List<Phrase>) {
        data.addAll(phrasees)
        notifyDataSetChanged()

    }

}


class PhraseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Phrase) {
        with(itemView) {
            txt_phrase.text = item.text
        }

    }
}


