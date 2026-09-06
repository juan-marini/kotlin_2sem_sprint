package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.mock.alertaMaisCritico
import br.com.educamais.app.mock.cursosEmAndamento
import br.com.educamais.app.mock.salasDeHoje
import br.com.educamais.app.mock.saudacaoPorHorario
import br.com.educamais.app.mock.usuarioLogado
import br.com.educamais.app.ui.components.BlocoModoAudio
import br.com.educamais.app.ui.components.CartaoAlertaEvasao
import br.com.educamais.app.ui.components.CartaoCurso
import br.com.educamais.app.ui.components.CartaoIndicador
import br.com.educamais.app.ui.components.CartaoSalaEstudo

@Composable
fun AbaInicio(
    aoAbrirCurso: (String) -> Unit,
    aoAbrirSala: (String) -> Unit
) {
    val usuario = usuarioLogado
    val alerta = alertaMaisCritico()
    val emAndamento = cursosEmAndamento()
    val salasHoje = salasDeHoje()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                text = "${saudacaoPorHorario()}, ${usuario.primeiroNome}",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        item {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                CartaoIndicador(
                    emoji = "🔥",
                    valor = "${usuario.ofensivaDias}",
                    rotulo = "Dias de ofensiva",
                    modifier = Modifier.weight(1f)
                )
                CartaoIndicador(
                    emoji = "📚",
                    valor = "${usuario.cursosConcluidos}",
                    rotulo = "Cursos concluídos",
                    modifier = Modifier.weight(1f)
                )
                CartaoIndicador(
                    emoji = "⏱",
                    valor = "${usuario.horasEstudo}h",
                    rotulo = "Horas de estudo",
                    modifier = Modifier.weight(1f)
                )
            }
        }

        if (alerta != null) {
            item { CartaoAlertaEvasao(alerta = alerta) }
        }

        if (emAndamento.isNotEmpty()) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("Continue de onde parou", style = MaterialTheme.typography.titleMedium)
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(emAndamento, key = { it.id }) { curso ->
                            CartaoCurso(
                                curso = curso,
                                onClick = { aoAbrirCurso(curso.id) },
                                compacto = true
                            )
                        }
                    }
                }
            }
        }

        if (salasHoje.isNotEmpty()) {
            item { Text("Salas de estudo hoje", style = MaterialTheme.typography.titleMedium) }
            items(salasHoje, key = { it.id }) { sala ->
                CartaoSalaEstudo(sala = sala, onClick = { aoAbrirSala(sala.id) })
            }
        }

        item { BlocoModoAudio() }
    }
}
