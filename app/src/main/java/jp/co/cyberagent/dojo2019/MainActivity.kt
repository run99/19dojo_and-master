package jp.co.cyberagent.dojo2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myProfButton.setOnClickListener{
            val intent = Intent(this, CreateActivity::class.java)
            startActivity(intent)

        }

        expressButton.setOnClickListener{
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}
