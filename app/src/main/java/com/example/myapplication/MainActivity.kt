package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.graphics.Color


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var start:Button? = null
    var exit:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start = findViewById(R.id.start_game)
        exit = findViewById(R.id.exit)

        start?.setBackgroundColor(Color.BLUE)
        exit?.setBackgroundColor(Color.BLUE)
    }

    override fun onClick(p0: View?) {
        if(p0?.id == R.id.start_game){
            val starting = Intent(applicationContext, GameActivity::class.java)
            startActivity(starting)
        }
        if(p0?.id == R.id.exit){
            finish()
        }
    }
}