package com.arya.gamecatalogue.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arya.gamecatalogue.core.R
import com.arya.gamecatalogue.core.databinding.ItemGameBinding
import com.arya.gamecatalogue.core.domain.model.Game
import com.bumptech.glide.Glide

class GameAdapter : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    private var listData = ArrayList<Game>()
    var onItemClick: ((Game) -> Unit)? = null

    fun setData(newListData: List<Game>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemGameBinding.bind(itemView)

        fun bind(data: Game) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.backgroundImage)
                    .into(ivItemImage)
                tvItemTitle.text = data.name
                tvItemSubtitle.text = "Genres: ${data.genres}"
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder = GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false))

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

}