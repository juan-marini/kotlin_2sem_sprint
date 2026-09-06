package br.com.educamais.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.educamais.app.navigation.EducaMaisNavHost
import br.com.educamais.app.ui.theme.EducaMaisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducaMaisTheme {
                EducaMaisNavHost()
            }
        }
    }
}
