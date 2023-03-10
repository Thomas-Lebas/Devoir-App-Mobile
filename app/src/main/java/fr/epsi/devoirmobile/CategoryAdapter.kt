package fr.epsi.devoirmobile

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter (private val categories: ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val categoryName: TextView = view.findViewById(R.id.category_name)
        val layoutCategory: LinearLayout = view.findViewById(R.id.layoutCategory)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_category, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryName.text = category.title

        holder.layoutCategory.setOnClickListener {
            val newIntent = Intent(holder.itemView.context, ProductActivity::class.java)
            newIntent.putExtra("title", category.title)
            newIntent.putExtra("url", category.products_url)
            holder.itemView.context.startActivity(newIntent)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}