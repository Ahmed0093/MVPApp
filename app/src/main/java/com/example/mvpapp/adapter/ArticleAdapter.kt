package com.example.mvpapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpapp.R
import com.example.mvpapp.imagemodule.ImageLoader
import com.example.mvpapp.model.Results
import kotlinx.android.synthetic.main.article_item.view.*

/**
 * Created by Ahmed Abdullah on 9/21/2019.
 */
class ArticleAdapter(
    private val mListener: OnArticleItemClicked,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<ArticleAdapter.Companion.ArticleViewHolder>() {

    companion object {

        class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val titleText: TextView = view.title
            val authorName: TextView = view.author
            val publishDate: TextView = view.publish_date
            val image: ImageView = view.profile_image
            val arrowImage: ImageView = view.arrow_image
        }
    }

    private var resultsList: List<Results> = ArrayList()

    fun setData(data: List<Results>) {
        this.resultsList = data
        this.notifyDataSetChanged()
    }

    fun clearData() {
        resultsList = emptyList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleAdapter.Companion.ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.article_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = resultsList[position]
        holder.titleText.text = item.title
        holder.authorName.text = item.section
        imageLoader.providesGlide().load(item.url).centerInside().into(holder.image)
        holder.itemView.setOnClickListener { _ -> mListener.onClick(item) }

    }

    override fun getItemCount(): Int {
        return resultsList.size
    }

    interface OnArticleItemClicked {
        fun onClick(Results: Results)
    }


}