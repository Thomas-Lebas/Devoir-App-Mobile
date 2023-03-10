package fr.epsi.devoirmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHeaderTitle(getString(R.string.main_title))

        val buttonInfo=findViewById<Button>(R.id.buttonInfo)
        buttonInfo.setOnClickListener {
            val newIntent = Intent(application, InfoActivity::class.java)
            startActivity(newIntent)
        }

        val buttonProduct=findViewById<Button>(R.id.buttonProduct)
        buttonProduct.setOnClickListener {
            val newIntent = Intent(application, CategoryActivity::class.java)
            startActivity(newIntent)
        }

    }
}