package com.example.maturski

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.example.maturski.ui.theme.MaturskiTheme
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

val supabase = createSupabaseClient(
    supabaseUrl = "https://cinoocxghngoypiwzvnn.supabase.co",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNpbm9vY3hnaG5nb3lwaXd6dm5uIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzkyMDEwMDYsImV4cCI6MjA5NDc3NzAwNn0.GEwoohSozlk9c4S0TGSHIOUp-jFELBCiN-OCNLFcOAE"
) {

    install(Postgrest)
    install(Auth)
    install(Storage)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val user = com.example.maturski.supabase.auth.currentUserOrNull()

        val HomeFragment = Home()
        val RegisterFragment = RegisterFragment()
        val LoginFragment = LoginFragment()
        val RezervacijeFragment = RezervacijeFragment()
        val NoviSmestajFragment = NoviSmestajFragment()
        val ProfilFragment = ProfilFragment()

        PostaviFragment(LoginFragment)


        //Menjanje fragmenata
        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.main -> PostaviFragment(HomeFragment)
                R.id.rezervacije -> PostaviFragment(RezervacijeFragment)
                R.id.novi_smestaj -> PostaviFragment(NoviSmestajFragment)
                R.id.profil -> PostaviFragment(ProfilFragment())
            }
            true
        }
    }

    //Funkcija za menjanje fragmenata
    private fun PostaviFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}