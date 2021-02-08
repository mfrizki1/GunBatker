package id.calocallo.gunbatker.landing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import id.calocallo.gunbatker.PagerAdapter
import id.calocallo.gunbatker.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*set adapter Fragment*/
        val adapter = PagerAdapter(this)
        binding.viewPager.adapter = adapter
        binding.wormDotsIndicator.setViewPager2(binding.viewPager)
        binding.viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                var currentPosition = position

                when (currentPosition) {
                    0 -> {
                        binding.btnBack.visibility = View.GONE
                    }
                    (adapter.itemCount - 1) -> {
                        binding.btnNext.visibility = View.GONE
                    }
                    else -> {
                        binding.btnBack.visibility = View.VISIBLE
                        binding.btnNext.visibility = View.VISIBLE
                    }
                }

                binding.btnBack.setOnClickListener {
                    currentPosition--
                    binding.viewPager.currentItem = currentPosition
                }

                binding.btnNext.setOnClickListener {
                    currentPosition++
                    binding.viewPager.currentItem = currentPosition
                }
            }
        })
    }
}