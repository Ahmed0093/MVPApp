package com.example.mvpapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpapp.R
import com.example.mvpapp.model.Results

/**
 * Created by Ahmed Abdullah on 9/21/2019.
 */
class Adapter2(private val mContext: Context, private val mListener: OnMovieClicked) : RecyclerView.Adapter<Adapter2.Companion.MoviesViewHolder>() {

    companion object {

        class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val mTitle: TextView = view.findViewById(R.id.title)
            val plot: TextView = view.findViewById(R.id.author)
            val publishDate: TextView = view.findViewById(R.id.publish_date)
            val image: ImageView = view.findViewById(R.id.profile_image)
            val arrowImage: ImageView = view.findViewById(R.id.arrow_image)
        }
    }

    private var resultss: List<Results> = ArrayList()

    fun setData(data: List<Results>) {
        this.resultss = data
       this.notifyDataSetChanged()
    }
    fun clearData() {
        resultss = emptyList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter2.Companion.MoviesViewHolder {
        return MoviesViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.article_item, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = resultss[position]
        holder.mTitle.text = item.title
        holder.plot.text = item.section
        Glide.with(mContext).load(item.url).centerInside().into(holder.image)
        holder.itemView.setOnClickListener { _ -> mListener.onClick(item) }

    }

    override fun getItemCount(): Int {
        return resultss.size
    }

    // TODO: Replace with RxView.clicks()
    interface OnMovieClicked {
        fun onClick(Results: Results)
    }
//    fun updateAdapter(updatedList: List<Results>) {
//        val result = DiffUtil.calculateDiff(PersonDiffUtilCallback(personList, updatedList))
//
//        resultss = updatedList.toMutableList()
//
//        result.dispatchUpdatesTo(this)
//    }

    private class ResultsDC : DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Results, newItem: Results) = oldItem == newItem
    }
}