package com.lvb.mobile.projects.app_countdown_timer.view.addTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lvb.mobile.projects.app_countdown_timer.R
import com.lvb.mobile.projects.app_countdown_timer.databinding.FragmentAddTaskBinding
import com.lvb.mobile.projects.app_countdown_timer.view.adapter.TaskTypeAdapter
import com.lvb.mobile.projects.app_countdown_timer.view.base.BaseFragment
import com.lvb.mobile.projects.app_countdown_timer.viewModel.addTask.AddTaskViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [AddTaskFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddTaskFragment : BaseFragment<FragmentAddTaskBinding, AddTaskViewModel>() {

    private val taskTypeAdapter by lazy { TaskTypeAdapter() }

    override val viewModel: AddTaskViewModel by viewModels()

    /*
        -------------------------------------------------------- FRAGMENT LIFECYCLE ---------------------------------------------------------
    */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        super.onCreateView(inflater, container, savedInstanceState)

        setupRecycleView()
        setupToolbar()

        return binding.root
    }

    /*
        -------------------------------------------------------- BASE FRAGMENT CONFIG ---------------------------------------------------------
    */

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddTaskBinding = FragmentAddTaskBinding.inflate(inflater, container, false)

    companion object {
        fun newInstance() = AddTaskFragment()
    }

    /*
        -------------------------------------------------------- COMPONENTS CONFIG ---------------------------------------------------------
    */

    private fun setupToolbar() {
        val activity = (activity as AppCompatActivity)

        binding.appToolbarAddTask.toolbarTitle.text = "Add Task"
        activity.setSupportActionBar(binding.appToolbarAddTask.toolbar)
        activity.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.elevation = 0F
        activity.supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setupRecycleView() {

        taskTypeAdapter.types = listOf("Work", "Study", "Sport", "Rest", "Other")

        binding.rvTaskType.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = taskTypeAdapter
        }
    }

}