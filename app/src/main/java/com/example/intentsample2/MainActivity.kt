package com.example.intentsample2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)

        val menuList : MutableList<MutableMap<String, String>> = mutableListOf()

        var menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "850円" )

        menuList.add(menu)

        menu = mutableMapOf("name" to "ヒレカツ定食", "price" to "900円" )

        menuList.add(menu)


        menu = mutableMapOf("name" to "刺身定食", "price" to "950円" )

        menuList.add(menu)


        menu = mutableMapOf("name" to "焼き魚定食", "price" to "700円" )

        menuList.add(menu)


        val from = arrayOf("name", "price")

        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleAdapter(applicationContext, menuList, android.R.layout.simple_list_item_2, from, to)

        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListner()


    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            if(parent != null){

                val item = parent.getItemAtPosition(position) as MutableMap<String, String>

                val menuName = item["name"]
                val menuPrice = item["price"]

                val intent = Intent(applicationContext, MenuThanksActivity::class.java)

                intent.putExtra("menuName", menuName)
                intent.putExtra("menuPrice", menuPrice)

                startActivity(intent)

            }




        }


    }
}
