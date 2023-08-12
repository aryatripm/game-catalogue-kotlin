package com.arya.gamecatalogue

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.arya.gamecatalogue.databinding.ActivityMainBinding
import com.arya.gamecatalogue.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener {
            var fragment: Fragment? = null
            var title = getString(R.string.app_name)
            when (it.itemId) {
                R.id.nav_home -> {
                    fragment = HomeFragment()
                    title = getString(R.string.app_name)
                }
                R.id.nav_favorite -> {
                    val uri = Uri.parse("gamecatalogueapp://favorite")
                    startActivity(Intent(Intent.ACTION_VIEW, uri))
                }
            }
            if (fragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            supportActionBar?.title = title

            binding.drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, HomeFragment())
                .commit()
            supportActionBar?.title = getString(R.string.app_name)
        }
    }
}