package com.example.xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var al:ArrayList<Student>
    lateinit var al1:ArrayList<Student>

    lateinit var rv:RecyclerView
    lateinit var txt :Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        al = ArrayList()
        rv = findViewById(R.id.rv)
        fetchData()
    }

    fun fetchData(){
        try{
            val parser = MyXmlPullParserHandler()
            val iStream = assets.open("studentdetails.xml")
            al1 = parser.parse(iStream)
            Log.d("al1","$al1")
            for(student in al1){
                txt =Student(student.id,student.name,student.marks)
                al.add(txt)
            }
            rv.adapter?.notifyDataSetChanged()
            rv.adapter = MyAdapter(al)
            rv.layoutManager = LinearLayoutManager(this)

        }catch (e: IOException) {
            println("ISSUE: $e")
            Log.d("ISSUE","ISSUE: $e")
        }
    }
}