package jp.co.cyberagent.dojo2019

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AndroidRuntimeException
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class UrlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url)

        val data = intent.getStringExtra("DATA")
        val size = 500


        //保存と書き出し
        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        val editor = dataStore.edit()

        editor.putString("DATA", data)

        editor.apply()

        val dataData = dataStore.getString("DATA", data)
        //

        val dataText = findViewById<TextView>(R.id.textView)
        dataText.text = dataData


        try {
            val barcodeEncoder = BarcodeEncoder()
            //QRコードをBitmapで作成
            val bitmap = barcodeEncoder.encodeBitmap(dataData, BarcodeFormat.QR_CODE, size, size)

            //作成したQRコードを画面上に配置
            val imageViewQrCode = findViewById<View>(R.id.trashButton) as ImageView
            imageViewQrCode.setImageBitmap(bitmap)

        } catch (e: WriterException) {
            throw AndroidRuntimeException("Barcode Error.", e)
        }


    }
}
