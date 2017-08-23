package com.codex.android.podrola.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codex.android.podrola.R
import com.codex.android.podrola.model.Podcast
import kotlinx.android.synthetic.main.inflate_item_podcast_list.view.*

/**
 * Created by Mikabrytu on 22/08/17.
 */
class PodcastAdapter(val list: ArrayList<Podcast>): RecyclerView.Adapter<PodcastAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.inflate_item_podcast_list, parent, false)
        return ViewHolder(view)
    }

    fun updateList(list: ArrayList<Podcast>): Unit {
        this.list.clear()
        this.list.addAll(list)
        this.notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(podcast: Podcast): Unit {
            itemView.text_podcast_name.text = podcast.name
        }
    }
}