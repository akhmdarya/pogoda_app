package com.example.pogoda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.pogoda.databinding.ActivityMainBinding
import com.example.pogoda.fragment.MainFragment
import org.json.JSONObject

const val API_KEY="cc4676ce8a414b199a1101426220311"
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder, MainFragment.newInstance(" ", ""))
            .commit()

    }

//        binding.bGet.setOnClickListener{
//
//             getResult("London")
//        }
//    }

    private fun getResult(name: String){


      val url =   "https://api.weatherapi.com/v1/current.json?key=cc4676ce8a414b199a1101426220311&q=London&aqi=no"

        val queue= Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {response->
                val obj =JSONObject(response)
                val temp = obj.getJSONObject("current")
                Log.d("MyLog","Volley resp:" +
                        "${temp.getString("temp_c")}")
               // Toast.makeText(applicationContext, "text!!!!", Toast.LENGTH_SHORT).show()
            },
            {
                Log.d("MyLog","Volley error: $it")
            }
        )
        queue.add(stringRequest)
    }
}