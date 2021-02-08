package id.calocallo.gunbatker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import id.calocallo.gunbatker.databinding.ActivitySplashBinding
import id.calocallo.gunbatker.landing.LandingActivity
import id.calocallo.gunbatker.utils.setFromUrl

class SplashActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgSplash.setFromUrl("https://i.ibb.co/HC5ZPgD/splash-screen1.png")
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LandingActivity::class.java))
            finish()
        },3000)
    }
}