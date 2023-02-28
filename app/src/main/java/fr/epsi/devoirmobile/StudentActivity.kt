package fr.epsi.devoirmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class StudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val image=findViewById<ImageView>(R.id.imageViewEtudiant)
        Picasso.get().load("https://th.bing.com/th/id/OIP.jeLpgEf9sLX7FK0s0CGZdgHaE7?pid=ImgDet&rs=1").into(image);

        setHeaderTitle(getString(R.string.title_student))
        showBack()
    }
}