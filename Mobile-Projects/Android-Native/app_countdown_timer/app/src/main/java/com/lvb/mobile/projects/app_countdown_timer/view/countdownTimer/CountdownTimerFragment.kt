package com.lvb.mobile.projects.app_countdown_timer.view.countdownTimer

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.lvb.mobile.projects.app_countdown_timer.R
import com.lvb.mobile.projects.app_countdown_timer.databinding.FragmentCountdownTimerBinding
import com.lvb.mobile.projects.app_countdown_timer.util.DateUtils
import com.lvb.mobile.projects.app_countdown_timer.view.base.BaseFragment
import com.lvb.mobile.projects.app_countdown_timer.viewModel.countdownTimer.CountdownTimerViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class CountdownTimerFragment :
    BaseFragment<FragmentCountdownTimerBinding, CountdownTimerViewModel>() {

    override val viewModel: CountdownTimerViewModel by viewModels()

    private var daysMissing: String = ""
    private var selectedDate: String = ""
    private var selectedFullDateTime: String = ""


    private val menuItemCallback = object : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) = menuInflater.inflate(R.menu.custom_menu_task_config, menu)
        override fun onMenuItemSelected(menuItem: MenuItem): Boolean = true
    }

    /*
        -------------------------------------------------------- FRAGMENT LIFECYCLE ---------------------------------------------------------
    */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
    super.onCreateView(inflater, container, savedInstanceState)

        setupToolbar()

        activity?.addMenuProvider(menuItemCallback, this.viewLifecycleOwner)

        binding.editTextSelectedDate.setOnClickListener {
            activity?.let { it1 ->
                DateUtils.dateTimePicker(it1)
            }
        }

        binding.btnStartCount.setOnClickListener {

            val mili = viewModel.startCountdownTime(selectedFullDateTime)
            object : CountDownTimer(mili/*30000*/, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

                    val calendar: Calendar = Calendar.getInstance()
                    calendar.timeInMillis = millisUntilFinished
                    val time = sdf.format(calendar.time)

                    binding.editTextTimerName.setText("Time remaining: $time" /*+ millisUntilFinished / 1000*/)
                }

                override fun onFinish() {
                    binding.editTextTimerName.setText("done!")
                }
            }.start()
        }

        collectObserver()

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        activity?.removeMenuProvider(menuItemCallback)
    }

    /*
        -------------------------------------------------------- BASE FRAGMENT CONFIG ---------------------------------------------------------
    */

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCountdownTimerBinding =
        FragmentCountdownTimerBinding.inflate(inflater, container, false)

    companion object {
        fun newInstance() = CountdownTimerFragment()
    }

    /*
        -------------------------------------------------------- COMPONENTS CONFIG ---------------------------------------------------------
    */

    private fun setupToolbar() = with(binding) {
        val activity = (activity as AppCompatActivity)

        appToolbar.toolbarTitle.text = "Countdown Timer"

        activity.setSupportActionBar(appToolbar.toolbar)
        activity.supportActionBar?.elevation = 0F
        activity.supportActionBar?.setDisplayShowTitleEnabled(false)
        activity.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


    /*
        -------------------------------------------------------- OBSERVER INIT ---------------------------------------------------------
    */

    private fun collectObserver() {
        collectObserverDate()
        collectObserverTime()
    }


    private fun collectObserverDate() = lifecycleScope.launch {
        DateUtils.selectedDate.collect {selectedDateTime ->
            if (selectedDateTime.isNotEmpty()) {
                daysMissing = viewModel.calculateMissingDaysForTimer(selectedDateTime).toString()
                selectedDate = selectedDateTime
            }
        }
    }

    private fun collectObserverTime() = lifecycleScope.launch {
        DateUtils.selectedTime.collect {selectedTime ->
            if (selectedTime.isNotEmpty()) {
                selectedFullDateTime = "$selectedDate $selectedTime"
                binding.editTextSelectedDate.text = "$daysMissing days\n$selectedTime"
            }

        }

    }
}