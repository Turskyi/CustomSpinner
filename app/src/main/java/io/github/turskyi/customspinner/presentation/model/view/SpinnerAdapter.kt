package io.github.turskyi.customspinner.presentation.model.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import io.github.turskyi.customspinner.presentation.model.Language
import io.github.turskyi.customspinner.R
import kotlinx.android.synthetic.main.item_language.view.*

class SpinnerAdapter : BaseAdapter() {

    var onItemClickListener: ((item: Language) -> Unit)? = null
    var languages: List<Language>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val myView = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_language, parent, false)
        val holder = myView.tag as? ItemRowHolder
            ?: ItemRowHolder(myView)
        myView.tag = holder
        holder.btnLanguage.text = languages?.get(position)?.language?.takeLast(2)
        myView.setOnClickListener {
            languages?.get(position)?.let { language -> onItemClickListener?.invoke(language) }
        }
        return myView
    }

    override fun getItem(position: Int) = null
    override fun getItemViewType(position: Int) = R.layout.item_language
    override fun getItemId(position: Int) = 0L
    override fun getCount() = languages?.size ?: 0

    private inner class ItemRowHolder(row: View) {
        val btnLanguage: Button = row.btnLanguage
    }
}