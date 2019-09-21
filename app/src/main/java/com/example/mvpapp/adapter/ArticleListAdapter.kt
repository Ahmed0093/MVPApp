package com.example.mvpapp.adapter

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpapp.MainActivity
import com.example.mvpapp.R
import com.example.mvpapp.model.Results
import kotlinx.android.synthetic.main.article_item.view.*

/**
 * Created by Ahmed Abdullah on 9/20/2019.
 */
class ArticleListAdapter(val listener: (Results) -> Unit) : RecyclerView.Adapter<ArticleListAdapter.ArticleHolder>()  {
    private var realmpaylist: List<Results> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleListAdapter.ArticleHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ArticleHolder(view)
    }

    override fun getItemCount(): Int = realmpaylist.size

    override fun onBindViewHolder(holder: ArticleListAdapter.ArticleHolder, position: Int)= with(holder.itemView) {
        val articleResult = realmpaylist[position]
        setOnClickListener{listener(articleResult)}
    }
    fun setArticles (articles: List<Results>){
        this.realmpaylist = articles
        this.notifyDataSetChanged()
    }
    fun clearArticles (){
        this.realmpaylist = ArrayList()
        this.notifyDataSetChanged()
    }
    class ArticleHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val holderImageview:ImageView = itemView.findViewById(R.id.profile_image)
        private val holderTitleText: TextView = itemView.findViewById(R.id.publish_date)
        private val hTitle: TextView = itemView.findViewById(R.id.title)
        private val hAuthor: TextView = itemView.findViewById(R.id.author)
        private val moneyamount:ImageView = itemView.findViewById(R.id.arrow_image)
        }

    }



