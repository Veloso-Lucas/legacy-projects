package com.lvb.mobile.projects.app_countdown_timer.view.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lvb.mobile.projects.app_countdown_timer.R
import com.lvb.mobile.projects.app_countdown_timer.databinding.TimerTypeBinding

class TaskTypeAdapter : RecyclerView.Adapter<TaskTypeAdapter.TaskTypeViewHolder>() {

    inner class TaskTypeViewHolder(val binding: TimerTypeBinding) :
        RecyclerView.ViewHolder(binding.root)

    var types: List<String> = emptyList()
    private var selectedRadio: Int = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskTypeViewHolder {
        return TaskTypeViewHolder(
            TimerTypeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskTypeViewHolder, position: Int) {
        holder.binding.radioButton.apply {
            text = types[position]
            isChecked = position == selectedRadio

            if (isChecked) {
                holder.binding.radioButtonLayout.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.white))
                setTextColor(ColorStateList.valueOf(resources.getColor(R.color.app_primary_color)))
            }

            else {
                holder.binding.radioButtonLayout.backgroundTintList = null
                setTextColor(ColorStateList.valueOf(resources.getColor(R.color.white)))
            }

            setOnCheckedChangeListener { _, b ->
                if (b) {
                    selectedRadio = holder.adapterPosition
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun getItemCount(): Int = types.size


}