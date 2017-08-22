package com.codex.android.podrola

import android.media.MediaPlayer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val audioPath = "http://archive.org/download/PodQuest183/PodQuest183-GOTY.mp3"

    lateinit var mediaPlayer: MediaPlayer
    var playbackPosition: Int = 0
    var playing: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        mediaPlayer = MediaPlayer()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer.setDataSource(audioPath)
        mediaPlayer.prepare()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun play(view: View): Unit {
        if (playing) {
            // Pause
            playbackPosition = mediaPlayer.currentPosition
            mediaPlayer.pause()
            playing = false
        } else if (playbackPosition == 0) {
            // Play
            mediaPlayer.start()
            playing = true
        } else {
            // Continue
            mediaPlayer.seekTo(playbackPosition)
            mediaPlayer.start()
            playing = true
        }
    }
}
