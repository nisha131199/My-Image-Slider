package com.ongraph.imageslider

import android.os.Handler
import android.os.Looper
import androidx.viewpager2.widget.ViewPager2

object ViewPager {

    private var myHandler: Handler? = null
    private var runnable: Runnable? = null
    private const val SLIDE_DELAY: Long = 2000
    private const val MIN_DELAY_TO_START_LOOP: Long = 1000
    private var pagePosition = 0

    fun ViewPager2.setUpViewPager(
        images: ArrayList<String>,
        minDelay: Long = MIN_DELAY_TO_START_LOOP,
        slideDelay: Long = SLIDE_DELAY
    ) {
        val adapter = ImageSliderAdapter(images)
        this.adapter = adapter

        // Optional: Set the orientation
        orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // Set up the auto slide logic
        myHandler = Handler(Looper.getMainLooper())

        runnable = object : Runnable {
            override fun run() {
                // Move to the next item
                if (pagePosition < images.size) {
                    pagePosition ++
                } else {
                    pagePosition = 0
                }
                setCurrentItem(pagePosition, true)
                myHandler?.postDelayed(this, slideDelay)
            }
        }
        runnable?.let {
            myHandler?.postDelayed(it, minDelay)
        }
    }

    fun flushHandler() {
        runnable?.let { myHandler?.removeCallbacks(it) }
    }

    fun startHandler() {
        runnable?.let { myHandler?.post(it) }
    }
}