package fr.epsi.devoirmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setHeaderTitle(getString(R.string.title_detail))
        showBack()
    }
}