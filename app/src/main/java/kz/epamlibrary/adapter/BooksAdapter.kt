package kz.epamlibrary.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_book.view.*
import kz.epamlibrary.R
import kz.epamlibrary.entity.Book

class BooksAdapter(private val books: ArrayList<Book>) :
    RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {


    class BookViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): BooksAdapter.BookViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)

        return BookViewHolder(item)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]

        holder.itemView.title.text = book.title
        holder.itemView.author.text = book.author
        /*holder.itemView.owner.text = book.o*/
        holder.itemView.category.text = book.categories[0].name
        /*holder.itemView.rate.text = book*/

    }

    override fun getItemCount(): Int {
        return books.size
    }
}