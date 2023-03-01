package fr.epsi.devoirmobile

import android.os.Bundle

class CategoryActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        setHeaderTitle(getString(R.string.title_product))
        showBack()

    }
}