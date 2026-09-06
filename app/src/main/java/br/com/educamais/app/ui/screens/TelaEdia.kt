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

// Versão provisória: a Fase 9 substitui pelo chat completo (balões,
// sugestões, indicador de "consultando o material"), mantendo a assinatura
// — inclusive o argumento opcional cursoContexto vindo do detalhe do curso.
@Composable
fun TelaEdia(cursoContexto: String?, aoVoltar: () -> Unit) {
    Scaffold { paddingInterno ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingInterno)
                .padding(24.dp)
        ) {
            Text("Chat da EdIA (Fase 9 monta a tela final)")
            if (cursoContexto != null) {
                Text("Contexto recebido do curso: $cursoContexto")
            }
            Button(onClick = aoVoltar) { Text("Voltar") }
        }
    }
}
