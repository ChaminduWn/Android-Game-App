package com.example.theflyingfish

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class GameView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private val fish: Array<Bitmap?> = arrayOfNulls(2)
    private var fishX: Int = 10
    private var fishY: Int = 0
    private var fishSpeed: Int = 0

    private var canvasWidth: Int = 0
    private var canvasHeight: Int = 0

    private var yellowX = 0
    private var yellowY = 0
    private var yellowSpeed = 16
    private val yellowPaint = Paint()

    private var greenX = 0
    private var greenY = 0
    private var greenSpeed = 20
    private val greenPaint = Paint()

    private var redX = 0
    private var redY = 0
    private var redSpeed = 22
    private val redPaint = Paint()

    private var score: Int = 0
    private var highestScore: Int = 0
    private var lifeCounterOfFish : Int = 0

    private var touch: Boolean = false

    private var backgroundImage: Bitmap? = null

    private val scorePaint: Paint = Paint()
    private val life: Array<Bitmap?> = arrayOfNulls(2)

    private var backgroundMediaPlayer: MediaPlayer? = null
    private var soundEffect1: MediaPlayer? = null
    private var soundEffect2: MediaPlayer? = null

    private val handler = Handler(Looper.getMainLooper())
    private var isFishStateOne = false

    init {
        backgroundMediaPlayer = MediaPlayer.create(context, R.raw.bg)
        backgroundMediaPlayer?.isLooping = true
        backgroundMediaPlayer?.start()

        soundEffect1 = MediaPlayer.create(context, R.raw.pop)
        soundEffect2 = MediaPlayer.create(context, R.raw.wrong)

        backgroundImage = BitmapFactory.decodeResource(resources, R.drawable.viewbg7)

        fish[0] = BitmapFactory.decodeResource(resources, R.drawable.puffer_fish3)
        fish[1] = BitmapFactory.decodeResource(resources, R.drawable.puffer_fish4)

        yellowPaint.color = Color.YELLOW
        yellowPaint.isAntiAlias = false

        greenPaint.color = Color.GREEN
        greenPaint.isAntiAlias = false

        redPaint.color = Color.RED
        redPaint.isAntiAlias = false

        scorePaint.color = Color.WHITE
        scorePaint.typeface = Typeface.DEFAULT_BOLD
        scorePaint.isAntiAlias = true
        scorePaint.textSize = 70f

        life[0] = BitmapFactory.decodeResource(resources, R.drawable.goldstar2)
        life[1] = BitmapFactory.decodeResource(resources, R.drawable.graystar3)

        fishY = 550
        score = 0
        val sharedPreferences = context.getSharedPreferences("FlyingFishPrefs", Context.MODE_PRIVATE)
        highestScore = sharedPreferences.getInt("highestScore", 0)
        lifeCounterOfFish = 3
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvasWidth = width
        canvasHeight = height

        backgroundImage?.let { canvas.drawBitmap(it, 0f, 0f, null) }

        val minFishY = fish[0]?.height ?: 0
        val maxFishY = canvasHeight - (fish[0]?.height ?: 0) * 3

        fishY += fishSpeed

        if (fishY < minFishY) {
            fishY = minFishY
        }

        if (fishY > maxFishY) {
            fishY = maxFishY
        }

        fishSpeed += 2

        if (touch) {
            fish[1]?.let { canvas.drawBitmap(it, fishX.toFloat(), fishY.toFloat(), null) }
            touch = false
            isFishStateOne = true
            handler.postDelayed({
                isFishStateOne = false
                invalidate()
            }, 300) // Delay of 300 milliseconds
        } else {
            if (isFishStateOne) {
                fish[1]?.let { canvas.drawBitmap(it, fishX.toFloat(), fishY.toFloat(), null) }
            } else {
                fish[0]?.let { canvas.drawBitmap(it, fishX.toFloat(), fishY.toFloat(), null) }
            }
        }

        yellowX -= yellowSpeed

        if (hitBallChecker(yellowX, yellowY)) {
            score += 10
            yellowX = -100
            soundEffect1?.start()
        }
        if (yellowX < 0) {
            yellowX = canvasWidth + 21
            yellowY = (Math.random() * (maxFishY - minFishY) + minFishY).toInt()
        }
        canvas.drawCircle(yellowX.toFloat(), yellowY.toFloat(), 25F, yellowPaint)

        greenX -= greenSpeed

        if (hitBallChecker(greenX, greenY)) {
            score += 20
            greenX = -100
            soundEffect1?.start()
        }
        if (greenX < 0) {
            greenX = canvasWidth + 21
            greenY = (Math.random() * (maxFishY - minFishY) + minFishY).toInt()
        }
        canvas.drawCircle(greenX.toFloat(), greenY.toFloat(), 25F, greenPaint)

        if (score > highestScore) {
            highestScore = score
            val sharedPreferences = context.getSharedPreferences("FlyingFishPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putInt("highestScore", highestScore)
            editor.apply()
        }

        redX -= redSpeed

        if (hitBallChecker(redX, redY)) {
            redX = -100
            lifeCounterOfFish--
            soundEffect2?.start()

            if (lifeCounterOfFish == 0) {
              //  Toast.makeText(context, "Game Over", Toast.LENGTH_SHORT).show()
                val gameOverIntent = Intent(context, GameOverActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    putExtra("score", score)
                    putExtra("highestScore", highestScore)
                }
                context.startActivity(gameOverIntent)
            }
        }
        if (redX < 0) {
            redX = canvasWidth + 21
            redY = (Math.random() * (maxFishY - minFishY) + minFishY).toInt()
        }
        canvas.drawCircle(redX.toFloat(), redY.toFloat(), 30F, redPaint)

        canvas.drawText("score: $score", 20f, 60f, scorePaint)

        for (i in 0 until 3) {
            val x = (450 + (life[0]?.width ?: 0) * 1.5 * i).toInt()
            val y = 30
            if (i < lifeCounterOfFish) {
                life[0]?.let { canvas.drawBitmap(it, x.toFloat(), y.toFloat(), null) }
            } else {
                life[1]?.let { canvas.drawBitmap(it, x.toFloat(), y.toFloat(), null) }
            }
        }
    }

    private fun hitBallChecker(x: Int, y: Int): Boolean {
        return fish[0]?.let {
            (fishX < x && x < (fishX + it.width) && fishY < y && y < (fishY + it.height))
        } ?: false
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            touch = true
            fishSpeed = -22
            return true
        }
        return super.onTouchEvent(event)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        backgroundMediaPlayer?.stop()
        backgroundMediaPlayer?.release()
        backgroundMediaPlayer = null
    }

}