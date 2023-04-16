package com.example.project2

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DirectoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directory)

        // Get a reference to the directory list view
        val directoryListView = findViewById<ListView>(R.id.directory_list_view)

        // Create a list of directory items (replace with actual data from database)
        val directoryItems = listOf(
            DirectoryItem("John Smith", "555-555-1234", "jsmith@example.com"),
            DirectoryItem("Natalie Rose", "876-339-0961", "ithod@ucc.edu.jm"),
            DirectoryItem("Ms. Bryanna Chang", "876-555-5678", "bchang@faculty.ucc.edu.jm"),
            DirectoryItem("Winsome Bennett", "876-555-5678", "itprogrammeoffice@ucc.edu.jm"),
            DirectoryItem("Otis Osbourne", "876-555-1910", "itfaculty@ucc.edu.jm")
            // ...
        )

        // Create an adapter to display the directory items in the list view
        val adapter = DirectoryListAdapter(this, directoryItems)
        directoryListView.adapter = adapter

        // Set an onItemClickListener to handle clicks on directory items
        directoryListView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItem = parent.getItemAtPosition(position) as DirectoryItem
                val phoneIntent = Intent(Intent.ACTION_DIAL)
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:${selectedItem.email}")
                }
                startActivity(phoneIntent)
                startActivity(emailIntent)
            }
    }
}

class DirectoryListAdapter(context: Context, private val directoryItems: List<DirectoryItem>) : ArrayAdapter<DirectoryItem>(context, 0, directoryItems) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val directoryItem = directoryItems[position]
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.directory_item, parent, false)
        }
        val nameTextView = view!!.findViewById<TextView>(R.id.directory_item_name)
        val phoneTextView = view.findViewById<TextView>(R.id.directory_item_phone)
        val emailTextView = view.findViewById<TextView>(R.id.directory_item_email)
        val photoImageView = view.findViewById<ImageView>(R.id.directory_item_photo)
        val callButton = view.findViewById<ImageButton>(R.id.directory_item_call_button)
        val emailButton = view.findViewById<ImageButton>(R.id.directory_item_email_button)

        nameTextView.text = directoryItem.name
        phoneTextView.text = directoryItem.phone
        emailTextView.text = directoryItem.email
        photoImageView.setImageResource(R.drawable.ic_person_foreground)

        callButton.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL)
            phoneIntent.data = Uri.parse("tel:${directoryItem.phone}")
            context.startActivity(phoneIntent)
        }

        emailButton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:${directoryItem.email}")
            context.startActivity(Intent.createChooser(emailIntent, "Send email"))
        }

        return view
    }
}


data class DirectoryItem(val name: String, val phone: String, val email: String)
