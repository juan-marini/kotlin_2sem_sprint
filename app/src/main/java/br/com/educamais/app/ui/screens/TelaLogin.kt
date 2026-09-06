package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Versão provisória: a Fase 6 substitui o corpo desta tela pelo layout
// final (gradiente, campos com validação, indicador de carregamento),
// mantendo a mesma assinatura usada pelo EducaMaisNavHost.
@Composable
fun TelaLogin(
    aoEntrar: () -> Unit,
    aoAbrirSobre: () -> Unit
) {
    Scaffold { paddingInterno ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("EducaMais — Login (Fase 6 monta a tela final)")
            Button(onClick = aoEntrar) { Text("Entrar") }
            TextButton(onClick = aoAbrirSobre) { Text("O que é o EducaMais?") }
        }
    }
}
