package com.example.myrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myrecyclerview.R
import com.example.myrecyclerview.model.Hero
import kotlinx.android.synthetic.main.item_cardview_hero.view.*

class CardViewHeroAdapter(private val listHeroes: ArrayList<Hero>) :
    RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_hero, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listHeroes[position])
    }

    override fun getItemCount(): Int = listHeroes.size


    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hero: Hero) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_item_photo)

                tv_item_name.text = hero.name
                tv_item_detail.text = hero.detail



                btn_set_favorite.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "Favorite ${hero.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                btn_set_share.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "Share ${hero.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                itemView.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "Kamu memilih ${hero.name}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
}