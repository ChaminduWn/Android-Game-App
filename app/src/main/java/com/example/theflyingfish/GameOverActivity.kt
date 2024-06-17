package com.example.theflyingfish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class GameOverActivity : AppCompatActivity() {
    private lateinit var startGameAgain: Button
    private lateinit var displayScore: TextView
    private lateinit var displayHighestScore: TextView
    private var score: String? = null
    private var highestScore: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)


        val scoreInt = intent.getIntExtra("score", 0)
        val highestScoreInt = intent.getIntExtra("highestScore", 0)

        score = scoreInt.toString()
        highestScore = highestScoreInt.toString()

        startGameAgain = findViewById(R.id.play_again_btn)
        displayScore = findViewById(R.id.displayScore)
        displayHighestScore = findViewById(R.id.displayHighestScore)

//        startGameAgain.setOnClickListener {
//            val mainIntent = Intent(this@GameOverActivity, StartActivity::class.java)
//            startActivity(mainIntent)
//        }
        score?.let {
            val formattedScore = getString(R.string.game_over_score, it)
            displayScore.text = formattedScore
        }

        highestScore?.let {
            val formattedHighestScore = getString(R.string.game_over_high_score, it)
            displayHighestScore.text = formattedHighestScore
        }
    }
}
