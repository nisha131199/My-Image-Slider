package com.ongraph.myimageslider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.ongraph.imageslider.ViewPager
import com.ongraph.imageslider.ViewPager.setUpViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = arrayListOf(
            "https://hollywoodlife.com/wp-content/uploads/2022/10/Male-Stars-In-Colored-Suits-2.jpg?w=680",
            "https://beauty-around.com/images/sampledata/Hollywood_Actors/24zac-efron.jpg",
            "https://beauty-around.com/images/sampledata/Hollywood_Actors/23james_franco.jpg"
        )

        findViewById<ViewPager2>(R.id.viewPager).setUpViewPager(images)
    }

    override fun onPause() {
        super.onPause()
        // Stop auto-slide when activity is paused
        ViewPager.flushHandler()

    }

    override fun onResume() {
        super.onResume()
        ViewPager.startHandler()
    }

}