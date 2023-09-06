package com.example.unittestpracticing

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        val noteTitleView = findViewById<EditText>(R.id.noteTitle)
        val noteDescView = findViewById<EditText>(R.id.noteDesc)
        val displayNote = findViewById<Button>(R.id.displayNote)

        displayNote.setOnClickListener {
            val noteTitle = noteTitleView.text.toString()
            val noteDescription = noteDescView.text.toString()

            if (noteTitle.isBlank() || noteDescription.isBlank()) {
                Toast.makeText(this, "Please enter valid note data", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(this, NoteDisplayActivity::class.java)
            intent.putExtra("note_title", noteTitle)
            intent.putExtra("note_desc", noteDescription)
            startActivity(intent)
        }
    }
}