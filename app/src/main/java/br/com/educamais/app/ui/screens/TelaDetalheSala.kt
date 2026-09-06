package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.mock.buscarSalaPorId
import br.com.educamais.app.ui.components.BarraDeProgresso
import br.com.educamais.app.ui.components.EstadoVazio
import br.com.educamais.app.ui.theme.EducaMaisTokens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaDetalheSala(
    salaId: String?,
    aoVoltar: () -> Unit,
    aoConfirmarPresenca: (salaId: String) -> Unit
) {
    val sala = salaId?.let { buscarSalaPorId(it) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(sala?.titulo ?: "Sala de estudo") },
                navigationIcon = { TextButton(onClick = aoVoltar) { Text("Voltar") } }
            )
        }
    ) { paddingInterno ->
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
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                if (sala.aoVivo) {
                    Text(
                        text = "AO VIVO",
                        style = MaterialTheme.typography.labelLarge,
                        color = EducaMaisTokens.cores.risco
                    )
                }

                Text(
                    text = sala.horario,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Curso relacionado: ${sala.cursoRelacionado}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(text = "Mediador: ${sala.mediador}", style = MaterialTheme.typography.bodyMedium)
                Text(text = sala.descricao, style = MaterialTheme.typography.bodyMedium)

                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    BarraDeProgresso(progresso = sala.ocupacao)
                    Text(
                        text = if (sala.lotada) {
                            "Sala lotada (${sala.participantes}/${sala.capacidade})"
                        } else {
                            "${sala.participantes}/${sala.capacidade} participantes · " +
                                "${sala.vagasRestantes} vagas restantes"
                        },
                        style = MaterialTheme.typography.labelMedium
                    )
                }

                Button(
                    onClick = { aoConfirmarPresenca(sala.id) },
                    enabled = !sala.lotada,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(if (sala.lotada) "Sala lotada" else "Confirmar presença")
                }
            }
        }
    }
}
