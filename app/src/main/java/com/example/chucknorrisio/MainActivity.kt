package com.example.chucknorrisio

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        getJokeBtn.setOnClickListener {
            val queue = Volley.newRequestQueue(this)
            val url = "https://api.chucknorris.io/jokes/random"

            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    var responseObj = JSONObject(response.toString())

                    jokeText.text = responseObj.getString("value")
            },
                Response.ErrorListener { jokeText.text = "No response. Maybe check your internet connection?" })
            queue.add(stringRequest)
        }
    }
/*
//  This code creates a menu button (three dots or ellipses) to select settings or other options

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
*/
}
