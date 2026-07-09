package com.lvb.mobile.projects.app_countdown_timer

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.lvb.mobile.projects.app_countdown_timer.databinding.ActivityMainBinding
import com.lvb.mobile.projects.app_countdown_timer.view.addTask.AddTaskFragment
import com.lvb.mobile.projects.app_countdown_timer.view.countdownTimer.CountdownTimerFragment
import com.lvb.mobile.projects.app_countdown_timer.view.taskList.TaskListFragment
import com.lvb.mobile.projects.app_countdown_timer.view.viewPager.SliderPagerAdapter


class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewPageAdapter by lazy {
        SliderPagerAdapter(supportFragmentManager, lifecycle)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        viewPageAdapter.apply {
            addFragment(TaskListFragment.newInstance())
            addFragment(CountdownTimerFragment.newInstance())
            addFragment(AddTaskFragment.newInstance())
        }

        binding.viewPager.apply {
            adapter = viewPageAdapter
        }

        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.viewPager.currentItem == 0) {
                    onBackPressedDispatcher.onBackPressed()
                } else {
                    binding.viewPager.currentItem -= 1
                }
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.action_add_task && binding.viewPager.currentItem == 0) {
            binding.viewPager.currentItem += 2
        }

        else if (binding.viewPager.currentItem == 0) {
            onBackPressedDispatcher.onBackPressed()
        }

        else if (item.itemId == android.R.id.home && binding.viewPager.currentItem == 2) {
            binding.viewPager.currentItem -= 2
        }

        else {
            binding.viewPager.currentItem -= 1
        }

        return super.onOptionsItemSelected(item)
    }

}
