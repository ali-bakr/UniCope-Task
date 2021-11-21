package com.aliaboubakr.taskunion.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aliaboubakr.taskunion.R
import com.aliaboubakr.taskunion.models.Result
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article_preview.view.*



class NewsAdapter:RecyclerView.Adapter<NewsAdapter.ResultViewHolder>() {

    inner class ResultViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    private val differCallback=object:DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.url==newItem.url
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem==newItem
        }


    }

    val differ=AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_article_preview,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val result = differ.currentList[position]
Log.e("position",position.toString())
        var url = ""
        result.media?.let {

            if (it.size!=0){
                url=it.get(0).media_metadata?.get(0)!!.url
            }

        }


        holder.itemView.apply {

            if (url.equals("")) {
                // ivArticleImage.background=resources.getDrawable(R.drawable.ic_launcher_background)
                ivArticleImage.setImageResource(R.drawable.ic_launcher_foreground)
            }

            else { Glide.with(this).load(url).into(ivArticleImage) }

            tvSource.text = result.source
            tvTitle.text = result.title
            tvDescription.text = result.abstract
            tvPublishedAt.text = result.published_date
            setOnClickListener {
                onItemClickListiner?.let { it(result) }
            }
        }

    }
    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListiner:((Result)->Unit)?=null

    fun onItemClickListner(listiner:(Result)->Unit){
        onItemClickListiner=listiner
    }
}