package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView

class GameActivity : AppCompatActivity(), View.OnClickListener {

    var update_btn = ButtonClass(20.0, 1.0)
    var person = ButtonClass(100.0, 1.0)
    var octopus = ButtonClass(800.0, 8.0)
    var centipede = ButtonClass(4000.0, 40.0)
    var machie_gun = ButtonClass(20000.0, 200.0)


    var knocks:Double = 1.0
    var money:Double = 0.0
    var hand:Double = 1.0
    var auto_knock = 0.0

    var hp: TextView? = null
    var show_money: TextView? = null
    var btn: Button? = null
    var btn_update: Button? = null
    var btn_person: Button? = null
    var btn_octopus: Button? = null
    var btn_centipide: Button? = null
    var btn_machine_gun: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        hp = findViewById(R.id.counter)
        show_money = findViewById(R.id.money)

        btn = findViewById(R.id.btn)
        btn_update = findViewById(R.id.update)
        btn_person = findViewById(R.id.person)
        btn_octopus = findViewById(R.id.octopus)
        btn_centipide = findViewById(R.id.centipide)
        btn_machine_gun = findViewById(R.id.machine_gun)

        btn?.setBackgroundColor(Color.GRAY)
    }

    var timer: CountDownTimer = object : CountDownTimer(10000000000, 100){
        override fun onTick(p0: Long) {
            knocks -= auto_knock
            money += auto_knock
            money =  (Math.round(money * 100).toDouble() / 100)
            show_money?.text = "$money"

            knocks = (Math.round(knocks * 100).toDouble() / 100)
            hp?.text = "$knocks"

            if (money >= update_btn.c){
                btn_update?.setBackgroundColor(Color.GREEN)
            }
            else{
                btn_update?.setBackgroundColor(Color.BLACK)
            }

            if (money >= person.c){
                btn_person?.setBackgroundColor(Color.GREEN)
            }
            else{
                btn_person?.setBackgroundColor(Color.BLACK)
            }

            if (money >= octopus.c){
                btn_octopus?.setBackgroundColor(Color.GREEN)
            }
            else{
                btn_octopus?.setBackgroundColor(Color.BLACK)
            }

            if (money >= centipede.c){
                btn_centipide?.setBackgroundColor(Color.GREEN)
            }
            else{
                btn_centipide?.setBackgroundColor(Color.BLACK)
            }

            if (money >= machie_gun.c){
                btn_machine_gun?.setBackgroundColor(Color.GREEN)
            }
            else{
                btn_machine_gun?.setBackgroundColor(Color.BLACK)
            }

            if(knocks <= 0)
            {
                onFinish()
            }
        }

        override fun onFinish() {
            val starting = Intent(applicationContext, ExitActivity::class.java)
            startActivity(starting)
        }
    }

    init{
        timer.start()
    }

    override fun onClick(p0: View?) {
        if(p0?.id == R.id.btn) {
            knocks -= hand * update_btn.mult
            money += hand * update_btn.mult
        }
        if(p0?.id == R.id.update){
            if(money >= update_btn.c){
                money -= update_btn.c
                update_btn.mult += 0.1
                update_btn.c *= 1.2
            }
        }
        if(p0?.id == R.id.person){
            if(money >= person.c){
                money -= person.c
                auto_knock += person.k
                person.c *= 1.2
            }
        }
        if(p0?.id == R.id.octopus){
            if(money >= octopus.c){
                money -= octopus.c
                auto_knock += octopus.k
                octopus.c *= 1.2
            }
        }
        if(p0?.id == R.id.centipide){
            if(money >= centipede.c){
                money -= centipede.c
                auto_knock += centipede.k
                centipede.c *= 1.2
            }
        }
        if(p0?.id == R.id.machine_gun){
            if(money >= machie_gun.c){
                money -= machie_gun.c
                auto_knock += machie_gun.k
                machie_gun.c *= 1.2
            }
        }

        money =  (Math.round(money * 100).toDouble() / 100)
        show_money?.text = "$money"

        knocks = (Math.round(knocks * 100).toDouble() / 100)
        hp?.text = "$knocks"
    }
}
