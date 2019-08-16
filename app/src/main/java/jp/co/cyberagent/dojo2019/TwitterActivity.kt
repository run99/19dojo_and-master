package jp.co.cyberagent.dojo2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class TwitterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twitter)

        val twitter = intent.getStringExtra("Twitter")

        val myWebView = findViewById<View>(R.id.webView) as WebView
        myWebView.webViewClient = WebViewClient()
        myWebView.loadUrl("https://twitter.com/" +twitter)
    }
}
