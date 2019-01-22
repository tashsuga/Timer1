package com.onespan.takeshisugai.timer1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
//import java.util.logging
//import android.os.Handler

class MainActivity : AppCompatActivity() {

    private var mTimer: Timer? = null

    // タイマー用の時間のための変数
    private var mTimerSec = 0.0

    private var mHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_button.setOnClickListener {
            if (mTimer == null){
                mTimer = Timer()
                mTimer!!.schedule(object : TimerTask() {
                    override fun run() {
                        mTimerSec += 0.1
                        mHandler.post {
                            timer.text = String.format("%.1f", mTimerSec)
                        }
                    }
                }, 100, 100) // 最初に始動させるまで 100ミリ秒、ループの間隔を 100ミリ秒 に設定
            }
        }

        /*

        start_button.setOnClickListener {
            if (mTimer == null) {
                mTimer = Timer()
                mTimer!!.schedule(object : TimerTask() {
                    override fun run() {
                        mTimerSec += 0.1
                        mHandler.post {
                            timer.text = String.format("%.1f", mTimerSec)
                        }
                    }
                }, 100, 100) // 最初に始動させるまで 100ミリ秒、ループの間隔を 100ミリ秒 に設定
            }
        }

      */
        pause_button.setOnClickListener()
        run {
            if (mTimer != null) {
                mTimer!!.cancel()
                mTimer = null
            }
        }

        reset_button.setOnClickListener
        val function = {
            mTimerSec = 0.0
            timer.text = String.format("%.1f", mTimerSec)
        }
  
    }
}


