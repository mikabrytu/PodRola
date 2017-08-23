package com.codex.android.podrola.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.codex.android.podrola.R
import com.codex.android.podrola.adapter.PodcastAdapter
import com.codex.android.podrola.model.Podcast

import kotlinx.android.synthetic.main.activity_podcast_list.*
import kotlinx.android.synthetic.main.content_podcast_list.*

class PodcastListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_podcast_list)
        setSupportActionBar(toolbar)

        //retrieveData()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recycler_podcast_list.layoutManager = LinearLayoutManager(this)

        val podcastList = ArrayList<Podcast>()
        podcastList.add(Podcast("Jovem Nerd"))
        podcastList.add(Podcast("Podquest"))
        podcastList.add(Podcast("Matando Robôs Gigantes"))
        podcastList.add(Podcast("99Vidas"))
        podcastList.add(Podcast("Mamilos"))
        podcastList.add(Podcast("RapaduraCast"))

        recycler_podcast_list.adapter = PodcastAdapter(podcastList)
    }

    // TODO: get response, convert to array of Podcast model object and update adapter
    private fun retrieveData() {
        val queue: RequestQueue = Volley.newRequestQueue(this)

        var request: StringRequest = StringRequest(Request.Method.GET,
                "http://fipeapi.appspot.com/api/1/carros/marcas.json",
                Response.Listener {
                    //
                },
                Response.ErrorListener {
                    //
                })
        request.retryPolicy = DefaultRetryPolicy(3000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

        queue.add(request)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.home) {
            super.onBackPressed();
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
