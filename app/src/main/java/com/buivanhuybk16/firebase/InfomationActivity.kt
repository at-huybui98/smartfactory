package com.buivanhuybk16.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_infomation.*

class InfomationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infomation)



        val author      = "Bùi Văn Huy"
        val version     = "1.0.0"
        val name        = "Smart Factory Project"
        val updatelate  = "16/06/2020"
        val st = "Tên ứng dụng:      $name\n" +
                        "Tác giả:           $author\n" +
                        "Phiên bản:         $version\n"+
                        "Cập nhập lần cuối: $updatelate"

        textView_infomation_app_show.text = st


    }
}
