package com.yanytskyi.dima.netronic.presentation.screens.users

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.yanytskyi.dima.netronic.R
import com.yanytskyi.dima.netronic.databinding.FragmentUsersBinding
import com.yanytskyi.dima.netronic.presentation.adapters.UserAdapter
import com.yanytskyi.dima.netronic.presentation.screens.splash.SplashFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users) {

    private lateinit var binding: FragmentUsersBinding
    private val viewModel: UsersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUsersBinding.bind(view)

        binding.countInput.addTextChangedListener {
            if(it.toString().isNotEmpty() && it.toString().isNotBlank()) {
                viewModel.onEvent(UsersScreenEvent.OnCountChanged(it.toString().toInt()))
            }
        }

        binding.getProfiles.setOnClickListener {
            viewModel.onEvent(UsersScreenEvent.GetUsers)
        }

        binding.history.setOnClickListener {
            val actionUsersToHistory = UsersFragmentDirections
                .actionUsersFragmentToHistoryFragment()
            findNavController().navigate(actionUsersToHistory)
        }

        lifecycleScope.launch {
            viewModel.usersState.collect {
                if(it.data.isNotEmpty()){
                    val historyAdapter = UserAdapter(it.data){ user ->
                        val actionUsersToUserInfo = UsersFragmentDirections
                            .actionUsersFragmentToUserInfoFragment(user)
                        findNavController().navigate(actionUsersToUserInfo)
                    }
                    binding.usersRecycler.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = historyAdapter
                    }
                }

                if(it.message.isNotEmpty()){
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }

                binding.progressBar2.visibility = if(it.loading) { View.VISIBLE } else { View.INVISIBLE }
            }
        }
    }
}