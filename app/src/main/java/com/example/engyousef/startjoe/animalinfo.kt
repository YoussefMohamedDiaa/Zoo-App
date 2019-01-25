package com.example.engyousef.startjoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animalinfo.*
import kotlinx.android.synthetic.main.animal_ticket.*

class animalinfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animalinfo)

        val b:Bundle=intent.extras
        val name= b.getString("name")
        val des= b.getString("des")
        val image= b.getInt("image")

        tvName.text=name
        textView2.text=des
        tvImage.setImageResource(image)

    }
}
