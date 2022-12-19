package com.example.pogoda.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.pogoda.MainViewModel
import com.example.pogoda.R
import com.example.pogoda.adapters.WeatherAdapter
import com.example.pogoda.adapters.WeatherModel
import com.example.pogoda.databinding.FragmentHoursBinding
import com.example.pogoda.databinding.FragmentMainBinding
import org.json.JSONArray
import org.json.JSONObject


class HoursFragment : Fragment() {
        private lateinit var binding: FragmentHoursBinding
        private lateinit var adapter: WeatherAdapter


        private val model:MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentHoursBinding.inflate(inflater,container,false)
                 return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()

        model.liveDataCurrent.observe(viewLifecycleOwner){

          adapter.submitList(getHoursList(it))

        }
    }

    private fun initRcView() = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter= WeatherAdapter()
        rcView.adapter= adapter



//        adapter.submitList(list)

    }

    private fun getHoursList(witem:WeatherModel):List<WeatherModel>{
        val  hoursArray = JSONArray(witem.hours)
        val list = ArrayList<WeatherModel>()
        for (i in 0 until hoursArray.length()){
            val item = WeatherModel(
                witem.city,

                (hoursArray[i] as JSONObject).getString("time"),
                (hoursArray[i] as JSONObject).getJSONObject("condition").getString("text"),
                (hoursArray[i] as JSONObject).getString("temp_c"),
                (hoursArray[i] as JSONObject).getJSONObject("condition").getString("icon"),

                "",
                "",
                ""
            )
            list.add(item)
        }
        return list
    }

    companion object {
           @JvmStatic
        fun newInstance() = HoursFragment()
    }
}