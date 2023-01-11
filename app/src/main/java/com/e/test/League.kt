package com.e.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class League : AppCompatActivity() {
    private lateinit var leagueselected:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        leagueselected=findViewById(R.id.textView2)
        val dato= intent.getStringExtra("dato")
        leagueselected.text= dato

    }

}