package com.draccotech.exerciciomodulo11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.draccotech.exerciciomodulo11.databinding.ActivityJogador1Binding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class Jogador1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityJogador1Binding
    lateinit var bottomNav: BottomNavigationView
    lateinit var drawer : DrawerLayout
    lateinit var navDrawer: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityJogador1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarJogador)

        bottomNav = binding.bottomNav
        drawer = binding.root
        navDrawer = binding.navigationDrawer

        initializeSpinner()
        setupBottomNavigation()
        setupDrawer()
    }

    private fun setupDrawer() {
        navDrawer.setNavigationItemSelectedListener {
            drawer.closeDrawers()
            when(it.itemId){
                R.id.menu_jogador -> {
                    true
                }
                R.id.menu_result -> {
                    val intent = Intent(binding.root.context, ResultadoActivity::class.java)
                    startActivity(intent)
                    finish()
                    true}
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
                R.id.bottom_menu_jogador -> {true}
                R.id.bottom_menu_result -> {
                    val intent = Intent(this, ResultadoActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else -> {false}
            }
        }
    }

    private fun initializeSpinner(){
        //Criando um array de valores
        val valores = arrayOf("Pedra", "Papel", "Tesoura")

        //Criando um ArrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, valores)

        //Definindo o layout do Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //Conectando o ArrayAdapter ao Spinner
        binding.spinner.adapter = adapter
    }
}