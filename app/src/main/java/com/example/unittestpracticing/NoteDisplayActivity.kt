package com.example.unittestpracticing

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NoteDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_display)

        val intent = intent
        val noteTitle = intent.getStringExtra("note_title")
        val noteDescription = intent.getStringExtra("note_desc")

        val noteDetailsView = findViewById<TextView>(R.id.noteDetails)
        noteDetailsView.text = "Title: $noteTitle, Description: $noteDescription"
    }
}