package com.example.project2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SocialMediaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media)

        // Load the URLs of UCC's social media accounts
        val facebookUrl = "https://www.facebook.com/uccjamaica"
        val twitterUrl = "https://twitter.com/UCCJamaica"
        val instagramUrl = "https://www.instagram.com/uccjamaica/?igshid=YmMyMTA2M2Y%3D"

        // Set up buttons to open the social media URLs in a web browser
        val facebookButton = findViewById<Button>(R.id.facebook_button)
        facebookButton.setOnClickListener {
            openUrlInBrowser(facebookUrl)
        }

        val twitterButton = findViewById<Button>(R.id.twitter_button)
        twitterButton.setOnClickListener {
            openUrlInBrowser(twitterUrl)
        }

        val instagramButton = findViewById<Button>(R.id.instagram_button)
        instagramButton.setOnClickListener {
            openUrlInBrowser(instagramUrl)
        }
    }

    private fun openUrlInBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}
