package com.rasel.sinchcall

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sinch.android.rtc.Sinch
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sinchClient = Sinch.getSinchClientBuilder()
                .context(this)
                .userId("123456")
                .applicationKey("5fdfc69a-e3a0-4f49-9e4c-a3bfe67d4e75")
                .applicationSecret("IZ1NaqnTrECrPFH6N72YCg==")
                .environmentHost("sandbox.sinch.com")
                .build()

        sinchClient.setSupportCalling(true)
        sinchClient.start()

        buttonCall.setOnClickListener {
            sinchClient.callClient.callUser("call-recipient-id");
        }
    }
}
