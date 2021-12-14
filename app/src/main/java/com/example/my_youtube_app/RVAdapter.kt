package com.example.my_youtube_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_youtube_app.databinding.ItemRowBindingBinding

interface CellClickListener {
    fun onClickListener(position: Int)
}

class TubeCard(title: String, Date: String, subTitle: String, img: Int) {
    val title = title
    val Date = Date
    val subTitle = subTitle
    val thumbnail = img
}

class RecyclerViewAdapter(
    private val context: Context,
    private val container: List<TubeCard>, private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<RecyclerViewAdapter.CardViewHolder>() {
    class CardViewHolder(val binding: ItemRowBindingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val myView: Context
        return CardViewHolder(
            ItemRowBindingBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cards = container[position]
        holder.binding.apply {
            tvTitle.text = cards.title
            tvSubTitle.text = cards.subTitle
            tvDateTime.text = cards.Date
            tvImg.setImageResource(cards.thumbnail)
            holder.itemView.setOnClickListener {
                cellClickListener.onClickListener(position)
            }
        }


    }

    override fun getItemCount() = container.size
}