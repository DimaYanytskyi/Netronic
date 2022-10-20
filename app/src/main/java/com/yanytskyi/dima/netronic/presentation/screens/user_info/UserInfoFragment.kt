package com.yanytskyi.dima.netronic.presentation.screens.user_info

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.yanytskyi.dima.netronic.R
import com.yanytskyi.dima.netronic.databinding.FragmentUserInfoBinding
import com.yanytskyi.dima.netronic.domain.model.User

class UserInfoFragment : Fragment(R.layout.fragment_user_info) {

    private lateinit var binding: FragmentUserInfoBinding
    private val args: UserInfoFragmentArgs by navArgs()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserInfoBinding.bind(view)

        val user = args.user

        binding.apply {
            Glide.with(requireContext()).load(user.thumbnailUrl).into(userPhoto)
            userFullname.text = "${user.firstName} ${user.secondName}"
            userUsername.text = user.username
            userEmail.text = user.email
            userCounry.text = user.country

        }

        binding.back2.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}