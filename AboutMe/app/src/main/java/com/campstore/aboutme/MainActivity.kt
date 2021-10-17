package com.campstore.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.campstore.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName:MyName = MyName("Abdulsamad Suleiman")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickName(it)
//        }
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {

       binding.apply {
//           nicknameText.text = binding.nicknameEdit.text
           myName?.nickname = binding.nicknameEdit.text.toString()

           invalidateAll()
           nicknameEdit.visibility = View.GONE
           doneButton.visibility = View.GONE
           nicknameText.visibility = View.VISIBLE
       }


          // Hide Keyboard
        val imm= getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)




    }
}