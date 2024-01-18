package com.lolinet.unicornfantasian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lolinet.unicornfantasian.databinding.ActivityMainBinding
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.View
import android.webkit.WebSettings
import android.widget.Toast

public class MainActivity : AppCompatActivity() {

   private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.allowFileAccess = false
        webView.settings.allowContentAccess = false
        webView.settings.setSupportZoom(false)
        webView.settings.setTextSize(WebSettings.TextSize.NORMAL)
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        webView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

        // Tambahkan penanganan kesalahan
        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
                // Tampilkan pesan kesalahan
                Toast.makeText(this@MainActivity, "Terjadi kesalahan saat memuat halaman", Toast.LENGTH_SHORT).show()
            }
        }

        

        webView.loadUrl("https://unicornfantasian.com/")
    }
    
   override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}