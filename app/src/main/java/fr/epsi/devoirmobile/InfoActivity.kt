package fr.epsi.devoirmobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class InfoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        setHeaderTitle(getString(R.string.title_info))
        showBack()

        val buttonStudents=findViewById<Button>(R.id.buttonStudents)
        buttonStudents.setOnClickListener {
            val newIntent = Intent(application, StudentActivity::class.java)
            startActivity(newIntent)
        }


    }

}