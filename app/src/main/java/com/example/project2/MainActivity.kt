package com.example.project2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val directoryButton = findViewById<Button>(R.id.btn_directory)
        directoryButton.setOnClickListener {
            val intent = Intent(this, DirectoryActivity::class.java)
            startActivity(intent)
        }

        val coursesButton = findViewById<Button>(R.id.btn_courses)
        coursesButton.setOnClickListener {
            val intent = Intent(this, CoursesActivity::class.java)
            startActivity(intent)
        }

        val admissionButton = findViewById<Button>(R.id.btn_admissions)
        admissionButton.setOnClickListener {
            val intent = Intent(this, AdmissionsActivity::class.java)
            startActivity(intent)
        }

        val socialButton = findViewById<Button>(R.id.btn_social)
        socialButton.setOnClickListener {
            val intent = Intent(this, SocialMediaActivity::class.java)
            startActivity(intent)
        }
    }
}
