package com.yanytskyi.dima.netronic.presentation.screens.splash

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yanytskyi.dima.netronic.R
import com.yanytskyi.dima.netronic.databinding.FragmentSplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)

        val animation: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.scale)
        animation.reset()
        binding.logo.apply {
            clearAnimation()
            startAnimation(animation)
        }

        Timer().schedule(object : TimerTask(){
            override fun run() {
                lifecycleScope.launch(Dispatchers.Main) {
                    val actionSplashToUsers = SplashFragmentDirections
                        .actionSplashFragmentToUsersFragment()
                    findNavController().navigate(actionSplashToUsers)
                }
            }
        }, 2000)
    }
}