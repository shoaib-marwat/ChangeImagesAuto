package com.themestore.fakecall.fake.caller.changeimagesauto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val adapter = CustomPagerAdapter(this, viewPager)
        viewPager.adapter = adapter

        // Start auto-scrolling
        adapter.startAutoScroll()
    }
}