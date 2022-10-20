package com.yanytskyi.dima.netronic.presentation.screens.history

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.yanytskyi.dima.netronic.R
import com.yanytskyi.dima.netronic.databinding.FragmentHistoryBinding
import com.yanytskyi.dima.netronic.presentation.adapters.UserAdapter
import com.yanytskyi.dima.netronic.presentation.screens.users.UsersFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history) {

    private lateinit var binding: FragmentHistoryBinding
    private val viewModel: HistoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHistoryBinding.bind(view)

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        lifecycleScope.launch {
            viewModel.historyState.collect {
                if(it.data.isNotEmpty()){
                    val historyAdapter = UserAdapter(it.data) { user ->
                        val actionHistoryToUserInfo = HistoryFragmentDirections
                            .actionHistoryFragmentToUserInfoFragment(user)
                        findNavController().navigate(actionHistoryToUserInfo)
                    }
                    binding.historyRecycler.apply {
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = historyAdapter
                    }
                }

                if(it.message.isNotEmpty()){
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }

                binding.progressBar.visibility = if(it.loading) { View.VISIBLE } else { View.INVISIBLE }
            }
        }
    }
}