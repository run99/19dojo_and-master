package jp.co.cyberagent.dojo2019

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_create.GitHubText


class CreateActivity : AppCompatActivity() {

    var dataName : String? = null
    var dataTwitter : String? = null
    var dataGithub : String? = null

    var nameText : String? = null
    var twitterText : String? = null
    var githubText : String? = null

    val data :String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        var nameText = findViewById<EditText>(R.id.NameText)
        var twitterText = findViewById<EditText>(R.id.TwitterText)
        var githubText = findViewById<EditText>(R.id.GitHubText)

        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        //読み出し
        dataName = dataStore.getString("NAME", null)
        dataTwitter = dataStore.getString("TWITTER", null)
        dataGithub = dataStore.getString("GITHUB", null)

        nameText.setText(dataName)
        twitterText.setText(dataTwitter)
        githubText.setText(dataGithub)


        //val data = "ca-tech://dojo/share?iam=" + nameText.text + "&tw=" + twitterText.text + "&gh=" + githubText.text

        SaveButton.setOnClickListener {

            val name = nameText.text.toString()
            val twitter = twitterText.text.toString()
            val github = githubText.text.toString()

            //保存
            val editor = dataStore.edit()

            editor.putString("NAME", name)
            editor.putString("TWITTER", twitter)
            editor.putString("GITHUB", github)

            editor.apply()
            //

        }

        URLbutton.setOnClickListener {

            //val data = "ca-tech://dojo/share?iam=" + nameText.text + "&tw=" + twitterText.text + "&gh=" + githubText.text
           val data = Uri.Builder().scheme("ca-tech").authority("dojo").path("/share").
                appendQueryParameter("iam", nameText.text.toString()).
                appendQueryParameter("tw", twitterText.text.toString()).
                appendQueryParameter("gh", githubText.text.toString())


            val stringData  = data.toString()



            val intent = Intent(this, UrlActivity::class.java)
            intent.putExtra("DATA", stringData)

            startActivity(intent)
        }


        HomeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}
