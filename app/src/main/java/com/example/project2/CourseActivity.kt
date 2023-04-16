package com.example.project2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        // Get a reference to the courses list view
        val coursesListView = findViewById<ListView>(R.id.courses_list_view)

        // Create a list of course items (replace with actual data from database)
        val coursesItems = listOf(
            CourseItem(
                "ITT200",
                "Object Oriented Programming using C++",
                3,
                "",
                "An introductory course in computer science that covers the use of object oriented programming using C++"
            ),
            CourseItem(
                "ITT203",
                "Data Structures and File Management",
                3,
                "ITT200",
                "A course that covers fundamental data structures and algorithms commonly used in computer science."
            ),
            CourseItem(
                "MKT201",
                "Principles of Marketing",
                3,
                "None",
                "A course that covers that covers the basics of marketing."
            ),
            CourseItem(
                "SPA101",
                "Introduction to Spanish",
                3,
                "None",
                "A course that that introduces the basis of the Spanish language"
            ),
            CourseItem(
                "ITT101",
                "Computer Information Systems",
                3,
                "None",
                "None"
            ),
            CourseItem(
                "ITT201",
                "Data Communications and Networks 1",
                3,
                "ITT101",
                "A course that covers fundamental data communications and networks commonly used in computer science."
            ),
            CourseItem(
                "ITT116",
                "Computer Essentials and Troubleshooting 1",
                3,
                "ITT101",
                "None"
            ),
            CourseItem(
                "SOC100",
                "Introduction to Sociology",
                3,
                "None",
                "An introductory course that covers the fundamentals of Sociology"
            ),
            CourseItem(
                "ITT103",
                "Programming Techniques",
                3,
                "ITT101",
                "None"
            ),
            CourseItem(
                "ITT420",
                "Mobile App Development",
                3,
                "None",
                "A course that teaches you the basics as to how mobile apps are created."
            )
            // ...
        )

        // Create an adapter to display the course items in the list view
        val adapter = CoursesListAdapter(this, coursesItems)
        coursesListView.adapter = adapter

        // Set an onItemClickListener to handle clicks on course items
        coursesListView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItem = parent.getItemAtPosition(position) as CourseItem
                // Do something with the selected course item, e.g., start a new activity to show details
            }
    }
}

class CoursesListAdapter(context: Context, private val coursesItems: List<CourseItem>) :
    ArrayAdapter<CourseItem>(context, 0, coursesItems) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val courseItem = coursesItems[position]
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false)
        }
        val codeTextView = view!!.findViewById<TextView>(R.id.course_item_code)
        val nameTextView = view.findViewById<TextView>(R.id.course_item_name)
        val creditsTextView = view.findViewById<TextView>(R.id.course_item_credits)
        val prerequisitesTextView = view.findViewById<TextView>(R.id.course_item_prerequisites)
        val descriptionTextView = view.findViewById<TextView>(R.id.course_item_description)

        codeTextView.text = courseItem.code
        nameTextView.text = courseItem.name
        creditsTextView.text = "Credits: ${courseItem.credits}"
        prerequisitesTextView.text =
            if (courseItem.prerequisites.isNotBlank()) "Prerequisites: ${courseItem.prerequisites}" else ""
        descriptionTextView.text = courseItem.description

        return view
    }
}

data class CourseItem(
    val code: String,
    val name: String,
    val credits: Int,
    val prerequisites: String,
    val description: String
)
