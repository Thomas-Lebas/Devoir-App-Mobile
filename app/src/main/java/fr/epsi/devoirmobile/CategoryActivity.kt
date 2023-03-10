package fr.epsi.devoirmobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CategoryActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        setHeaderTitle(getString(R.string.title_category))
        showBack()

        val categories = arrayListOf<Category>()

        val httpClient = OkHttpClient().newBuilder().build()
        val request = Request.Builder()
            .url("https://www.ugarit.online/epsi/categories.json")
            .get()
            .build()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_category)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val categoryAdapter = CategoryAdapter(categories)
        recyclerView.adapter = categoryAdapter

        httpClient.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    Log.e("HTTP Error", "Something didn't load, or wasn't successful")
                } else {
                    val categoryResponse = categoryList(response.body!!.string())
                    categories.addAll(categoryResponse)
                    runOnUiThread { categoryAdapter.notifyDataSetChanged() }
                }

            }

        })

    }

    fun categoryList(jsonString: String): ArrayList<Category>{
        val categories = arrayListOf<Category>()
        val jsCategories = JSONObject(jsonString)
        val jsArrayCategories = jsCategories.getJSONArray("items")

        for (i in 0 until jsArrayCategories.length()) {
            val jsCat = jsArrayCategories.getJSONObject(i)
            val category = Category(
                jsCat.optString("category_id", "unknown"),
                jsCat.optString("title", "unknown"),
                jsCat.optString("products_url", "unknown")
            )
            categories.add(category)
        }
        return categories

    }
}