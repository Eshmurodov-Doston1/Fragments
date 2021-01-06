package com.example.android5lesson5task3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android5lesson5task3.fragments.FirstFragment
import com.example.android5lesson5task3.fragments.SecondFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var a1="first"
    var a2="second"
    var n:Int?=null
    var d:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var firstFragment = FirstFragment()
        var secondFragment = SecondFragment()
            add_btn.setOnClickListener {
                println(firstFragment.isVisible)
                if(firstFragment.isVisible==false) {
                    val supportFragmentManager = supportFragmentManager
                    val beginTransaction = supportFragmentManager.beginTransaction()
                    beginTransaction.add(R.id.container, firstFragment, a1)
                    beginTransaction.addToBackStack(a1)
                    beginTransaction.commit()
                    n=0
                    d=0
                }else if (firstFragment.isVisible==true){
                    Toast.makeText(this, "Siz Fragmentni ishlatdingiz", Toast.LENGTH_SHORT).show()
                }
            }
        remove_btn.setOnClickListener {
            if (firstFragment.isVisible==false || secondFragment.isVisible==false) {
                if (n == 0) {
                    if (a1 == "first") {
                        val supportFragmentManager = supportFragmentManager
                      //  var firstFragmentByTag =supportFragmentManager.findFragmentByTag(a1) as FirstFragment
                        val beginTransaction = supportFragmentManager.beginTransaction()
                        beginTransaction.remove(firstFragment)
                        supportFragmentManager.popBackStack()
                        beginTransaction.commit()
                    }
                } else if (n == 1) {
                    if (a2 == "second") {
                        val supportFragmentManager = supportFragmentManager
                        var firstFragmentByTag =
                                supportFragmentManager.findFragmentByTag(a2) as SecondFragment
                        val beginTransaction = supportFragmentManager.beginTransaction()
                        beginTransaction.remove(firstFragmentByTag)
                        supportFragmentManager.popBackStack()
                        beginTransaction.commit()
                        n = 0
                    }
                }
            }else {
                Toast.makeText(this, "Fragment yo`q", Toast.LENGTH_SHORT).show()
            }
        }
        replase_btn.setOnClickListener {
            var supportFragmentManager = supportFragmentManager
            n=1
            d=1
            val beginTransaction = supportFragmentManager.beginTransaction()
            beginTransaction.replace(R.id.container,secondFragment,a2)
            beginTransaction.addToBackStack(a2)
            beginTransaction.commit()
        }
        hide_btn.setOnClickListener {
            if (d==0) {
                if (a1=="first") {
                    var supportFragmentManager = supportFragmentManager
                    val beginTransaction = supportFragmentManager.beginTransaction()
                    beginTransaction.hide(firstFragment)
                    beginTransaction.commit()
                }
            }else if (d==1){
                if (a2=="second") {
                    var supportFragmentManager = supportFragmentManager
                    val beginTransaction = supportFragmentManager.beginTransaction()
                    beginTransaction.hide(secondFragment)
                    beginTransaction.commit()
                }
            }
        }
        show_btn.setOnClickListener {
            if (n==0){
                if (a1=="first"){
                    var supportFragmentManager = supportFragmentManager
                    val beginTransaction = supportFragmentManager.beginTransaction()
                    beginTransaction.show(firstFragment)
                    beginTransaction.commit()
                }
            }else if(n==1){
                if(a2=="second"){
                    var supportFragmentManager = supportFragmentManager
                    val beginTransaction = supportFragmentManager.beginTransaction()
                    beginTransaction.show(secondFragment)
                    beginTransaction.commit()
                }
            }

            }
        }
    }