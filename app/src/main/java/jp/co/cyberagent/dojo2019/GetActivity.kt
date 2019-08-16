package jp.co.cyberagent.dojo2019

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_get.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class GetActivity : AppCompatActivity() {

    /*var index : Int? = null
    var index2 : Int? = null
    var index3: Int? = null
    var index4 : Int? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get)

        //ListActivityから受け取った値
        val getName = intent.getStringExtra("name")
        val getGithub = intent.getStringExtra("github")
        val getTwitter = intent.getStringExtra("twitter")


        //Urlの文字列を分割
       /* index = dataResult.indexOf("=")
        index2 = dataResult.indexOf("&")
        index3 = dataResult.indexOf("tw")
        index4 = dataResult.indexOf("&gh")

        getName = dataResult.substring(index!! + 1, index2!!)
        getTwitter = dataResult.substring(index3!! + 3, index4!!)
        getGithub = dataResult.substring(index4!! + 4)*/


        val nameText = findViewById<TextView>(R.id.nameText)
        nameText.text = getName

        val githubText = findViewById<TextView>(R.id.githubText)
        githubText.text = getGithub

        val twitterText = findViewById<TextView>(R.id.twitterText)
        twitterText.text = getTwitter
    }

    fun cancel (view: View){
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    fun add(view: View) {

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database-name").build()

        val profile = Profile()
       // profile.uid = Random().nextInt()
        profile.name = nameText.text as String?
        profile.github = githubText.text as String?
        profile.twitter = twitterText.text as String?

        thread {
            db.profileDao().insert(profile)
        }
        finish()
    }
}
