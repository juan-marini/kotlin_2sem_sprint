package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.mock.buscarSalaPorId
import br.com.educamais.app.ui.components.EstadoVazio

// Versão provisória: a Fase 8 substitui pelo layout final. Já demonstra a
// busca por id e o retorno da confirmação de presença via savedStateHandle,
// que é montado no EducaMaisNavHost.
@Composable
fun TelaDetalheSala(
    salaId: String?,
    aoVoltar: () -> Unit,
    aoConfirmarPresenca: (salaId: String) -> Unit
) {
    val sala = salaId?.let { buscarSalaPorId(it) }
    Scaffold { paddingInterno ->
        if (sala == null) {
            EstadoVazio(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingInterno),
                emoji = "🔍",
                titulo = "Sala não encontrada",
                mensagem = "Essa sala de estudo pode ter sido encerrada ou o link está incorreto.",
                textoAcao = "Voltar",
                aoClicarAcao = aoVoltar
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingInterno)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Detalhe da sala (Fase 8 monta a tela final)")
                Text(sala.titulo)
                Text("${sala.participantes}/${sala.capacidade} participantes")
                Button(onClick = { aoConfirmarPresenca(sala.id) }) {
                    Text("Confirmar presença")
                }
                Button(onClick = aoVoltar) { Text("Voltar") }
            }
        }
    }
}
