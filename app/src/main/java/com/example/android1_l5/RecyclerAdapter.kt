package com.example.android1_l5

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android1_l5.databinding.ItemNameBinding

class RecyclerAdapter (onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerAdapter.CelebritiesViewHolder>(), View.OnClickListener {

    private var list: MutableList<RecyclerModel>? = null
    private val onItemClickListener: OnItemClickListener

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listCelebrity: MutableList<RecyclerModel>?) {
        this.list = listCelebrity
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebritiesViewHolder {
        return CelebritiesViewHolder(
            ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CelebritiesViewHolder, position: Int) {
        holder.itemView.setOnClickListener(this)
        holder.onBind(list!![position])
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    init {
        this.onItemClickListener = onItemClickListener
    }

    override fun onClick(view: View) {
        onItemClickListener.onClick(view.tag as RecyclerModel)
    }

    class CelebritiesViewHolder(private val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(celebrities: RecyclerModel) {
            Glide.with(binding.ivImage.context).load(celebrities.imageUrl).into(binding.ivImage)
            binding.tvName.text = celebrities.name
            binding.tvAge.text = celebrities.age.toString()
            binding.tvFamily.text = celebrities.family
            itemView.tag = celebrities
        }
    }
}