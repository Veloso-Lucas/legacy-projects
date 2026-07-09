package com.lvb.projects.app_finance

import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.lvb.projects.app_finance.adapter.TabsPagerAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val tab_layout = findViewById<TabLayout>(R.id.tab_layout)
        val tab_viewpager = findViewById<ViewPager2>(R.id.tabs_viewpager)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            toolbar.overflowIcon?.colorFilter = BlendModeColorFilter(resources.getColor(R.color.black, null), BlendMode.SRC_ATOP)
        }

        //toolbar.overflowIcon = ContextCompat.getDrawable(this, R.drawable.ic_my_menu)

        //
        //  TAB CONFIGURATION
        //
        tab_layout.setSelectedTabIndicatorColor(Color.WHITE)
        tab_layout.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        tab_layout.tabTextColors = ContextCompat.getColorStateList(this, R.color.white)
        tab_layout.tabMode = TabLayout.MODE_FIXED
        tab_layout.isInlineLabel = true

        val numberOfTabs = 3
        
        val adapter = TabsPagerAdapter(supportFragmentManager, lifecycle, numberOfTabs)
        tab_viewpager.adapter = adapter


        // ENABLE SWIPE
        tab_viewpager.isUserInputEnabled = true

        // Link the TabLayout and the ViewPager2 together and Set Text & Icons
        TabLayoutMediator(tab_layout, tab_viewpager) {tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Music"
                    tab.setIcon(R.drawable.music_icon)
                }
                1 -> {
                    tab.text = "Movies"
                    tab.setIcon(R.drawable.movies_icon)
                }
                2 -> {
                    tab.text = "Books"
                    tab.setIcon(R.drawable.menu_book_icon)
                }
            }

            tab.icon?.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                Color.WHITE,
                BlendModeCompat.SRC_ATOP
            )

        }.attach()
        
        

        setSupportActionBar(toolbar) // ADD TOOLBAR IN ACTIVITY MAIN
        supportActionBar?.setDisplayShowTitleEnabled(false) // REMOVE TOOLBAR DEFAULT TITLE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}