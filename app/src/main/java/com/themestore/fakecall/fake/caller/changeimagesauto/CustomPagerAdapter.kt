package com.themestore.fakecall.fake.caller.changeimagesauto
import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class CustomPagerAdapter(private val context: Context, private val viewPager: ViewPager) : PagerAdapter() {

    private val images = arrayOf(R.drawable.image1, R.drawable.image2, R.drawable.iamge3)
    private val handler = Handler(Looper.getMainLooper())

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.slide_layout, container, false)

        val imageView: ImageView = view.findViewById(R.id.imageView)
        imageView.setImageResource(images[position])

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    // Method to start auto-scrolling after a delay
    fun startAutoScroll() {
        handler.postDelayed(autoScrollRunnable, 1000) // 1000 milliseconds = 1 second
    }

    // Runnable to perform auto-scrolling
    private val autoScrollRunnable: Runnable = object : Runnable {
        override fun run() {
            val currentItem = viewPager.currentItem
            val nextItem = (currentItem + 1) % count
            viewPager.setCurrentItem(nextItem, true) // set smoothScroll to true for a smooth transition

            handler.postDelayed(this, 1000) // Schedule the next auto-scroll after 1 second
        }
    }
}
