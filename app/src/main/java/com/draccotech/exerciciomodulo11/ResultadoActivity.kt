package com.draccotech.exerciciomodulo11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.draccotech.exerciciomodulo11.databinding.ActivityJogador1Binding
import com.draccotech.exerciciomodulo11.databinding.ActivityResultadoBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding
    lateinit var bottomNav: BottomNavigationView
    lateinit var drawer : DrawerLayout
    lateinit var navDrawer: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarResult)

        bottomNav = binding.bottomNav
        drawer = binding.root
        navDrawer = binding.navigationDrawer

        setupBottomNavigation()
        setupDrawer()
    }

    private fun setupDrawer() {
        navDrawer.setNavigationItemSelectedListener {
            drawer.closeDrawers()
            when(it.itemId){
                R.id.menu_jogador -> {
                    val intent = Intent(binding.root.context, Jogador1Activity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.menu_result -> {
                    true
                }
                else -> false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_option_reiniciar -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                true
            }
            else -> false
        }
    }

    private fun setupBottomNavigation() {
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bottom_menu_jogador -> {
                    val intent = Intent(this, Jogador1Activity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.bottom_menu_result -> {
                    true
                }
                else -> {false}
            }
        }
    }
}