package com.example.my_youtube_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.PlayerUiController


class MainActivity : AppCompatActivity(), CellClickListener {
    private lateinit var myRV: RecyclerView
    private lateinit var rvAdapter: RecyclerViewAdapter
    lateinit var firsVid: YouTubePlayerView
    lateinit var secVid: YouTubePlayerView
    lateinit var thirdVid: YouTubePlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cardContainer: List<TubeCard> =
            listOf(
                TubeCard(
                    "لقاء ملزلز في برنامج المتهم ⚠ (حشرني بالأسئلة) !! ",
                    "06\u200F/11\u200F/2021 ",
                    "بريد إلكتروني : ◀ wsh3lek@gmail.com ",
                    R.drawable.thumb1
                ),
                TubeCard(
                    "3 Hours of Ambient Study Music To Concentrate - Improve your Focus and Concentration ",
                    "19\u200F/08\u200F/2021 ",
                    "selection of nature landscapes in the background.  This relaxing ambient study music for deep focus is perfect to play in the background while you focus on your work, keeping you relaxed and concentrated on your studies",
                    R.drawable.thumb2
                ),
                TubeCard(
                    "The Try Guys Bake Brownies Without A Recipe",
                    "12\u200F/12\u200F/2020",
                    "Let's bake! Enjoy another chaos and joy filled episode of Without A Recipe! Who's special brownies do you think will be the biggest hit with the judges? Get tickets to the Virtual World Premiere of Behind The Try today",
                    R.drawable.thumb3
                )
            )
        //set up rv
        myRV = findViewById(R.id.rvMain)
        rvAdapter = RecyclerViewAdapter(this, cardContainer, this)
        myRV.adapter = rvAdapter
        myRV.layoutManager = LinearLayoutManager(this)
        //set up videos view
        firsVid = findViewById(R.id.vid1)
        secVid = findViewById(R.id.vid2)
        thirdVid = findViewById(R.id.vid3)



        lifecycle.addObserver(firsVid)
        lifecycle.addObserver(secVid)
        lifecycle.addObserver(thirdVid)

        firsVid.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "6BGjSI0-SFM"
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })

        secVid.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "vu_KjaOKdts"
                youTubePlayer.loadVideo(videoId, 0f)
                firsVid.getPlayerUiController()
            }
        })

        thirdVid.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "xxn8bUcjukU"
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })
    }

    override fun onClickListener(position: Int) {
        when (position) {
            0 -> {
                firsVid.visibility = View.VISIBLE
                secVid.visibility = View.GONE
                thirdVid.visibility = View.GONE
            }
            1 -> {
                firsVid.visibility = View.GONE
                secVid.visibility = View.VISIBLE
                thirdVid.visibility = View.GONE
            }
            2 -> {
                firsVid.visibility = View.GONE
                secVid.visibility = View.GONE
                thirdVid.visibility = View.VISIBLE
            }
        }
    }
}