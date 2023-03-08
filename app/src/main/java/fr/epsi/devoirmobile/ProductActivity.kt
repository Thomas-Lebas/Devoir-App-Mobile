package fr.epsi.devoirmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val title = intent.extras?.getString("title")
        setHeaderTitle(title.toString())
        showBack()

        val products = arrayListOf<Product>()

        val httpClient = OkHttpClient().newBuilder().build()
        val request = Request.Builder()
            .url(intent.extras!!.getString("url").toString())
            .get()
            .build()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_products)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val productAdapter = ProductAdapter(products)
        recyclerView.adapter = productAdapter

        httpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace();
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    Log.e("HTTP Error", "Something didn't load, or wasn't successful")
                } else {
                    val productResponse = ProductList(response.body!!.string())
                    products.addAll(productResponse)
                    runOnUiThread { productAdapter.notifyDataSetChanged() }
                }

            }

        })

    }

    fun ProductList(jsonString: String): ArrayList<Product>{
        val products = arrayListOf<Product>()
        val jsProducts = JSONObject(jsonString)
        val jsArrayProducts = jsProducts.getJSONArray("items")

        for (i in 0 until jsArrayProducts.length()) {
            val jsCat = jsArrayProducts.getJSONObject(i)
            val product = Product(
                jsCat.optString("name", "unknown"),
                jsCat.optString("description", "unknown"),
                jsCat.optString("picture_url", "unknown")
            )
            products.add(product)
        }
        return products

    }
}