package com.draccotech.exerciciomodulo11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.draccotech.exerciciomodulo11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAppBar()
        initializedGame()

    }

    private fun setupAppBar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Jokenpô"
    }

    private fun initializedGame(){
        binding.button.setOnClickListener {
            val intent = Intent(this, Jogador1Activity::class.java)
            startActivity(intent)
        }
    }

}