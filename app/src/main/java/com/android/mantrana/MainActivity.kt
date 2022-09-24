package com.android.mantrana

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import com.android.mantrana.ui.Profile
import com.android.mantrana.ui.RelaxFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.watch_meditation_101.*
import kotlinx.android.synthetic.main.watch_meditation_101.view.*
import kotlinx.android.synthetic.main.watch_meditation_101.view.cancel_meditation_101_video
import kotlinx.android.synthetic.main.watch_mindfullness_video.view.*


class MainActivity : AppCompatActivity() {
    lateinit var inflateWatchMediation101Layount: View
    lateinit var inflateWatchMindfullnessVideoLayount: View
    private val TAG: String? = MainActivity::class.simpleName
    lateinit var viewGroup: ViewGroup
    lateinit var builder: AlertDialog.Builder

    //val videoUrl = "https://www.youtube.com/watch?v=o-kMJBWk9E0"

    @SuppressLint("ResourceType", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewGroup = findViewById<ViewGroup>(android.R.id.content)
        inflateWatchMediation101Layount = LayoutInflater
            .from(this)
            .inflate(R.layout.watch_meditation_101, viewGroup, false)

        inflateWatchMindfullnessVideoLayount = LayoutInflater
            .from(this)
            .inflate(R.layout.watch_mindfullness_video,viewGroup,false)


        hamburger.setOnClickListener {
            hamburger.snack("Your message")
        }
        val profile = findViewById<ImageButton>(R.id.profile)
        profile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }


        watch_meditation_101.setOnClickListener {
            alertDialogMeditation101Video()
        }


        watch_mindfullness_video.setOnClickListener {
            alertDialogMindfullnessVideo()
        }



    }



    private fun alertDialogMeditation101Video(){
        builder = AlertDialog.Builder(this)
        builder.setView(inflateWatchMediation101Layount)

        val mediaController = MediaController(this)
        inflateWatchMediation101Layount.watch_meditation_101_videoView.setMediaController(mediaController)
        mediaController.setAnchorView( inflateWatchMediation101Layount.watch_meditation_101_videoView)
        val path = "android.resource://" + packageName + "/" + R.raw.meditation_101_video
        inflateWatchMediation101Layount.watch_meditation_101_videoView.setVideoURI(Uri.parse(path))
        inflateWatchMediation101Layount.watch_meditation_101_videoView.requestFocus()
        inflateWatchMediation101Layount.watch_meditation_101_videoView.start()
        val alertDialog1 = builder.create()

        alertDialog1.show()
    }

    private fun alertDialogMindfullnessVideo() {
        val mindfullness_alert  = AlertDialog.Builder(this)
        mindfullness_alert.setView(inflateWatchMindfullnessVideoLayount)

        val mediaController = MediaController(this)
        inflateWatchMindfullnessVideoLayount.watch_mindfullness_video_videoView.setMediaController(mediaController)
        mediaController.setAnchorView( inflateWatchMindfullnessVideoLayount.watch_mindfullness_video_videoView)
        val path = "android.resource://" + packageName + "/" + R.raw.mindfullness_video
        inflateWatchMindfullnessVideoLayount.watch_mindfullness_video_videoView.setVideoURI(Uri.parse(path))
        inflateWatchMindfullnessVideoLayount.watch_mindfullness_video_videoView.requestFocus()
        inflateWatchMindfullnessVideoLayount.watch_mindfullness_video_videoView.start()
        val alertDialog2 = mindfullness_alert.create()

        alertDialog2.show()
    }







}


