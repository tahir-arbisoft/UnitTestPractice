package com.example.unittestpracticing

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.unittestpracticing.cat.CatManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val helper = Helper()
//        helper.isPalindrome("hello")
//        helper.isPalindrome("level")
//        helper.isPalindrome("a")
//        helper.isPalindrome("")

        val catManager = CatManager()
        catManager.populateCatFromAssets(this, "cats.json")

        val ownerName = findViewById<TextView>(R.id.ownerName)
        ownerName.text = catManager.getCurrentCat().owner
        ownerName.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(intent, "Select App"))
        }

        findViewById<Button>(R.id.prevButton).setOnClickListener {
            val cat = catManager.getPreviousCat()
            ownerName.text = cat.owner
        }

        findViewById<Button>(R.id.nextButton).setOnClickListener {
            val cat = catManager.getNextCat()
            ownerName.text = cat.owner
        }
    }
}