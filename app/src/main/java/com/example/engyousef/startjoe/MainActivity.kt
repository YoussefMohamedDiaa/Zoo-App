package com.example.engyousef.startjoe

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animals
        listAnimals.add(Animal("Baboon","Baboon lives in India",R.drawable.baboon,false))
        listAnimals.add(Animal("Bulldog","Bulldog is a pet ",R.drawable.bulldog,true))
        listAnimals.add(Animal("Panda","Panda is rare ",R.drawable.panda,false))
        listAnimals.add(Animal("Swallow bird","Swallow bird is colorful ",R.drawable.swallow_bird,false))
        listAnimals.add(Animal("White Tiger","Tigers lives in India",R.drawable.white_tiger,true))
        listAnimals.add(Animal("Zebra","Zebra lives in Africa ",R.drawable.zebra,false))

        adapter = AnimalsAdapter(this,listAnimals)
        tvAllTicket.adapter=adapter
    }

    class AnimalsAdapter:BaseAdapter{
        var listAnimals = ArrayList<Animal>()
        var context:Context?=null
        constructor(context:Context, listAnimals : ArrayList<Animal>):super(){
           this.listAnimals=listAnimals
           this.context=context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
           val animal = listAnimals[position]
            if (animal.isKiller==true){
                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflater.inflate(R.layout.animal_killer_ticket,null)
                myView.textViewName.text=animal.name
                myView.tvDes.text=animal.des
                myView.imageViewName.setOnClickListener{
                    val intent = Intent(context, animalinfo::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)
                }
                myView.imageViewName.setImageResource(animal.image!!)
                return myView
            }else {

                var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflater.inflate(R.layout.animal_ticket, null)
                myView.textViewName.text = animal.name
                myView.tvDes.text = animal.des
                myView.imageViewName.setOnClickListener{
                    val intent = Intent(context, animalinfo::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)
                }
                myView.imageViewName.setImageResource(animal.image!!)
                return myView
            }
        }

        override fun getItem(position: Int): Any {
            return listAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listAnimals.size
        }

    }
}
