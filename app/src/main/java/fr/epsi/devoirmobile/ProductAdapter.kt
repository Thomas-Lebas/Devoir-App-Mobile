package fr.epsi.devoirmobile

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter (private val products: ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.cell_product_ImageView)
        val productNameTextView: TextView = view.findViewById(R.id.cell_product_name)
        val productDescriptionTextView: TextView = view.findViewById(R.id.cell_product_description)
        val container: LinearLayout = view.findViewById(R.id.layout_product_linearLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.productNameTextView.text = product.name
        holder.productDescriptionTextView.text = product.description
        Picasso.get().load(product.picture_url).into(holder.imageView)

        holder.container.setOnClickListener {
            val newIntent = Intent(holder.imageView.context, DetailActivity::class.java)
            newIntent.putExtra("title", product.name)
            newIntent.putExtra("picture_url", product.picture_url)
            newIntent.putExtra("description", product.description)

            holder.itemView.context.startActivity(newIntent)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}
