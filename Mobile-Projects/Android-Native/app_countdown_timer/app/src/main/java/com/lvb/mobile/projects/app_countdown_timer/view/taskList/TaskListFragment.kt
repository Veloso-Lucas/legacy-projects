package com.lvb.mobile.projects.app_countdown_timer.view.taskList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lvb.mobile.projects.app_countdown_timer.R
import com.lvb.mobile.projects.app_countdown_timer.databinding.FragmentTaskListBinding
import com.lvb.mobile.projects.app_countdown_timer.view.adapter.TaskTypeAdapter
import com.lvb.mobile.projects.app_countdown_timer.view.base.BaseFragment
import com.lvb.mobile.projects.app_countdown_timer.viewModel.taskList.TaskListViewModel

class TaskListFragment : BaseFragment<FragmentTaskListBinding, TaskListViewModel>() {

    private val taskTypeAdapter by lazy { TaskTypeAdapter() }

    override val viewModel: TaskListViewModel by viewModels()

    private val menuItemCallback = object : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) = menuInflater.inflate(R.menu.custom_menu_add, menu)
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

        setupRecyclerView()
        setupToolbar()

        activity?.addMenuProvider(menuItemCallback, this.viewLifecycleOwner)

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
    ): FragmentTaskListBinding = FragmentTaskListBinding.inflate(inflater, container, false)

    companion object {
        fun newInstance() = TaskListFragment()
    }

    /*
        -------------------------------------------------------- COMPONENTS CONFIG ---------------------------------------------------------
    */

    private fun setupToolbar() {
        val activity = (activity as AppCompatActivity)

        binding.appToolbarAddTask.toolbarTitle.text = "Task List"
        activity.setSupportActionBar(binding.appToolbarAddTask.toolbar)
        activity.supportActionBar?.elevation = 0F
        activity.supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setupRecyclerView() {
        taskTypeAdapter.types = listOf("LUC", "VESLOTER", "Sport", "Rest", "Other")

        binding.rvTaskType.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = taskTypeAdapter
        }
    }
}