package com.lvb.mobile.projects.app_countdown_timer.util

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject


class DateUtils @Inject constructor(val context: ApplicationContext) {

    companion object {

        private val sdf by lazy {
            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        }

        private val _selectedDate = MutableStateFlow("")
        val selectedDate: StateFlow<String> = _selectedDate

        private val _selectedTime = MutableStateFlow("")
        val selectedTime: StateFlow<String> = _selectedTime


        fun dateTimePicker(Context: Context) {
            datePicker(Context, true)
        }

        private fun datePicker(context: Context, getTime: Boolean = false) {
            // Get Current Date
            val c = Calendar.getInstance()

            DatePickerDialog(
                context, { _, year, monthOfYear, dayOfMonth ->
                    _selectedDate.value =
                        sdf.parse("$dayOfMonth/${(monthOfYear + 1)}/$year")?.let { sdf.format(it) }
                            .toString()
                    if (getTime) {
                        timePicker(context)
                    }

                }, c[Calendar.YEAR], c[Calendar.MONTH], c[Calendar.DAY_OF_MONTH]

            ).show()
        }

        private fun timePicker(context: Context) {
            // Get Current Time
            val c = Calendar.getInstance()

            // Launch Time Picker Dialog
            TimePickerDialog(
                context,
                { _, hourOfDay, minute ->
                    _selectedTime.value = "$hourOfDay:$minute:00"
                },
                c[Calendar.HOUR_OF_DAY],
                c[Calendar.MINUTE],
                false
            ).show()
        }

        fun convertDateInMSeconds(date : String): Long {
            val sdfFullDate = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
            val dateFormat = sdfFullDate.parse(date)

            return dateFormat.time
        }
    }
}