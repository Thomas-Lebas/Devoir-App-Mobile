package fr.epsi.devoirmobile

import android.os.Bundle

class StudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        setHeaderTitle(getString(R.string.title_student))
        showBack()
    }
}