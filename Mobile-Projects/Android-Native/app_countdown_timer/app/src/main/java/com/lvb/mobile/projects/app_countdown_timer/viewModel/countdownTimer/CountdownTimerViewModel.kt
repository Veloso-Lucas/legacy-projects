package com.lvb.mobile.projects.app_countdown_timer.viewModel.countdownTimer

import androidx.lifecycle.ViewModel
import com.lvb.mobile.projects.app_countdown_timer.util.DateUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class CountdownTimerViewModel @Inject constructor(): ViewModel() {

    fun calculateMissingDaysForTimer(dateTimer: String) : Long {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date = sdf.parse(dateTimer) ?: Calendar.getInstance().time
        return daysBetweenDates(date)
    }

    private fun daysBetweenDates(endDateTimer: Date) : Long {

        val startDateValue = Calendar.getInstance().time

        val diff = endDateTimer.time - startDateValue.time

        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
    }

    fun startCountdownTime(date: String) : Long {

        val timeInSeconds = DateUtils.convertDateInMSeconds(date)
        return timeInSeconds

    }

}