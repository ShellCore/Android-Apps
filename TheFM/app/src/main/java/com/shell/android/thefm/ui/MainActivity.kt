package com.shell.android.thefm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.shell.android.thefm.R
import com.shell.android.thefm.ui.topartists.TopArtistsFragment
import com.shell.android.thefm.ui.topsongs.TopSongsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_top_artist -> {
                    replaceFragment(TopArtistsFragment())
                    true
                }
                R.id.nav_hyped_artist -> {
                    replaceFragment(TopSongsFragment())
                    true
                }
                else -> false
            }
        }

        replaceFragment(TopSongsFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}
