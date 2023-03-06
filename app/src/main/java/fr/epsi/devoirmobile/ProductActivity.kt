package fr.epsi.devoirmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        setHeaderTitle(getString(R.string.title_product))
        showBack()
    }
}