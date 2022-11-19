package com.example.android1_l5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.android1_l5.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var binding : FragmentDetailBinding? = null
    private var model: RecyclerModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data
    }

    private val data: Unit
        private get() {
            val argument = arguments
            if (argument != null) {
                model = argument.getSerializable("key") as RecyclerModel?
                binding?.image?.let { it.context?.let { it1 -> Glide.with(it1).load(model?.imageUrl).into(binding?.image!!) } }
                binding?.tvName?.text = model?.name
                binding?.tvFamily?.text = model?.family
                binding?.tvAge?.text = model?.age.toString()
            }
        }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}