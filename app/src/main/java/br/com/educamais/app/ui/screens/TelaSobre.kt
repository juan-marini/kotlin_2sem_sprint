package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Versão provisória: a Fase 9 substitui pelo layout final (marca, quatro
// pilares e escopo da sprint), mantendo a mesma assinatura.
@Composable
fun TelaSobre(aoVoltar: () -> Unit) {
    Scaffold { paddingInterno ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(24.dp)
        ) {
            Text("Sobre o EducaMais (Fase 9 monta a tela final)")
            Button(onClick = aoVoltar) { Text("Voltar") }
        }
    }
}
