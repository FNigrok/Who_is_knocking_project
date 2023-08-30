package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ExitActivity : AppCompatActivity(), View.OnClickListener {

    var start:Button? = null
    var exit:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        exit = findViewById(R.id.exit)

        exit?.setBackgroundColor(Color.BLUE)
    }

    override fun onClick(p0: View?) {

        if(p0?.id == R.id.exit){
            finish()
        }
    }
}