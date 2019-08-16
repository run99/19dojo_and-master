package jp.co.cyberagent.dojo2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class GithubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)

        val github = intent.getStringExtra("GitHub")

        val myWebView = findViewById<View>(R.id.webView) as WebView
        myWebView.webViewClient = WebViewClient()
        myWebView.loadUrl("https://github.com/" +github)
    }
}
