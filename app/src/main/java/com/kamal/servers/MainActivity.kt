package com.kamal.servers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kamal.fragment.fragments.FragmentServer1
import com.kamal.fragment.fragments.FragmentServer2
import com.kamal.fragment.fragments.FragmentServer3
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav1.setOnNavigationItemSelectedListener {
            if(it.itemId == R.id.navigation_server1)
            {
                createFragment(FragmentServer1())
            }
            else if(it.itemId == R.id.navigation_server2)
            {
                createFragment(FragmentServer2())
            }
            else if(it.itemId == R.id.navigation_server3)
            {
//                createFragment(FragmentServer3())
                createDialogeFragment()
            }
            return@setOnNavigationItemSelectedListener true
        }
        nav1.selectedItemId = R.id.navigation_server1
    }
    private fun createDialogeFragment() {
        val dialogue = FragmentServer3()
        dialogue.show(supportFragmentManager,"")
    }

    private fun createFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .commit()
    }
}