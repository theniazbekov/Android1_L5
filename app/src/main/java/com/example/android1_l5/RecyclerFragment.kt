package com.example.android1_l5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android1_l5.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment(), OnItemClickListener {

    private var binding : FragmentRecyclerBinding? = null
    private val repository = RecyclerRepository()
    private val adapter = RecyclerAdapter(this)
    private var model: RecyclerModel? = null
    private var list: ArrayList<RecyclerModel>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecyclerBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = repository.getListOfCelebrities()
        adapter.setData(list)
        initialize()
        setOnClickListener()
        AddData()
    }

    private fun initialize() {
        binding?.rvListOfName?.adapter = adapter
    }

    private fun setOnClickListener() {
        binding?.btnAdd?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ThirdFragment())
                .addToBackStack("RecyclerFragment")
                .commit()
        }
    }

    override fun onClick(model: RecyclerModel?) {
        val bundle = Bundle()
        bundle.putSerializable("key", model)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,DetailFragment::class.java,bundle)
            .addToBackStack("RecyclerFragment")
            .commit()
    }

    private fun AddData() {
        parentFragmentManager.setFragmentResultListener("back", viewLifecycleOwner)
        { requestKey, result ->
            if (requestKey == "back") {
                model = result.getSerializable("OK") as RecyclerModel?
                model?.let { list?.add(it) }
                adapter.setData(list)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}