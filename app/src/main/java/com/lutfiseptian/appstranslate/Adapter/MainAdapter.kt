package com.lutfiseptian.appstranslate.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.vipulasri.timelineview.TimelineView
import com.lutfiseptian.appstranslate.R
import com.lutfiseptian.appstranslate.model.ModelMain
import kotlinx.android.synthetic.main.list_item_translate.view.*

class MainAdapter(private val items: List<ModelMain>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_translate, parent, false)
        return ViewHolder(view , viewType)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]
        holder.tvTranslation.text = data.strTranslation
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return TimelineView.getTimeLineViewType(position , itemCount)
    }

    class ViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {
        var timelineView: TimelineView
        var tvTranslation: TextView

        init {
            timelineView = itemView.timelineView
            timelineView.initLine(viewType)
            tvTranslation = itemView.tvTranslation
        }
    }

}