package com.lvb.projects.app_finance.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lvb.projects.app_finance.MounthReportFragment
import com.lvb.projects.app_finance.WeekReportFragment
import com.lvb.projects.app_finance.YearReportFragment

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int) : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return numberOfTabs
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> {
                //MUSIC FRAGMENT
                val bundle = Bundle()
                bundle.putString("fragmentName", "Music Fragment")
                val musicFragment = WeekReportFragment()
                musicFragment.arguments = bundle
                return musicFragment
            }
            1 -> {
                // # Movies Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Movies Fragment")
                val moviesFragment = MounthReportFragment()
                moviesFragment.arguments = bundle
                return moviesFragment
            }
            2 -> {
                //MUSIC FRAGMENT
                // # Books Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Books Fragment")
                val booksFragment = YearReportFragment()
                booksFragment.arguments = bundle
                return booksFragment
            }
            else -> return WeekReportFragment()
        }
    }

}