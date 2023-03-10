package fr.epsi.devoirmobile

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setHeaderTitle(getString(R.string.title_detail))
        showBack()

        val imageView = findViewById<ImageView>(R.id.product_details_ImageView)
        val pictureUrl = intent.extras!!.getString("picture_url")
        Picasso.get()
            .load(pictureUrl)
            .into(imageView)

        val descriptionTextView = findViewById<TextView>(R.id.product_details_description_textView)
        val description = intent.extras!!.getString("description")
        descriptionTextView.text = description
    }
}