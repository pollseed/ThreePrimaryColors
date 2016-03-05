package com.example.shn.myapplication

import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val main: RelativeLayout = findViewById(R.id.main) as RelativeLayout

        val firstText: TextView = findViewById(R.id.hello_textView) as TextView

        val button = findViewById(R.id.main)
        button.setOnClickListener {
            view ->  Log.d("button click", "OK")

            firstText.setTextColor(Color.TRANSPARENT)

            val textView: TextView = findViewById(R.id.hello_textView) as TextView
            val bg: BackGround = getColor(textView)
            main.setBackgroundColor(bg.color)
            textView.setText(bg.text)
        }

    }

    private enum class BackGroundColor {
        BLUE, RED, YELLOW
    }

    private class BackGround(text: String, color: Int) {
        val text = text
        val color = color
    }

    private fun getColor(textView: TextView): BackGround {
        var color: Int
        var text: String
        if (BackGroundColor.BLUE.name.equals(textView.text)) {
            text = BackGroundColor.YELLOW.name
            color = Color.YELLOW
        } else if (BackGroundColor.RED.name.equals(textView.text)){
            text = BackGroundColor.BLUE.name
            color = Color.BLUE
        } else {
            text = BackGroundColor.RED.name
            color = Color.RED
        }
        return BackGround(text, color)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        object: AsyncTask<Unit, Unit, String>() {
            override fun doInBackground(vararg p0: Unit?): String? {
                throw UnsupportedOperationException()
            }
        }
    }
}
