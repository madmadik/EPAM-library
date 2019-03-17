package kz.epamlibrary.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_category.view.*
import kz.epamlibrary.R
import kz.epamlibrary.entity.Category
import kz.epamlibrary.explore.CategorySearchActivity
import kz.epamlibrary.network.Constant.CATEGORY_ID
import kz.epamlibrary.network.Constant.CATEGORY_NAME

class CategoriesAdapter(private val categories: ArrayList<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {


    class CategoryViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.CategoryViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)

        return CategoryViewHolder(item)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]

        if (position % 7 == 0) {
            holder.itemView.category_image.setImageResource(R.drawable.ic_category_arts)
        } else if (position % 7 == 1) {
            holder.itemView.category_image.setImageResource(R.drawable.ic_category_novel)
        } else if (position % 7 == 2) {
            holder.itemView.category_image.setImageResource(R.drawable.ic_category_history)
        } else if (position % 7 == 3) {
            holder.itemView.category_image.setImageResource(R.drawable.ic_category_design)
        } else if (position % 7 == 4) {
            holder.itemView.category_image.setImageResource(R.drawable.ic_category_all)
        } else if (position % 7 == 5) {
            holder.itemView.category_image.setImageResource(R.drawable.ic_category_bibliographies)
        } else if (position % 7 == 6) {
            holder.itemView.category_image.setImageResource(R.drawable.ic_category_business)
        } else if (position % 7 == 7) {
            holder.itemView.category_image.setImageResource(R.drawable.ic_category_law)
        } else if (position % 7 == 8) {
            holder.itemView.category_image.setImageResource(R.drawable.ic_category_calendars)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CategorySearchActivity::class.java)
            intent.putExtra(CATEGORY_ID, category.id)
            intent.putExtra(CATEGORY_NAME, category.name)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}