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

        if (position % 2 == 0) {
            holder.itemView.category_image.setImageResource(R.drawable.ic_category_all)
        } else {
            holder.itemView.category_image.setImageResource(R.drawable.ic_category_design)
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