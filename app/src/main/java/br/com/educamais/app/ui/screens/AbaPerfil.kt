package br.com.educamais.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.mock.conquistas
import br.com.educamais.app.mock.usuarioLogado
import br.com.educamais.app.ui.components.AvatarIniciais
import br.com.educamais.app.ui.components.BarraDeProgresso
import br.com.educamais.app.ui.components.CartaoConquista
import br.com.educamais.app.ui.components.CartaoIndicador

@Composable
fun AbaPerfil(
    aoAbrirSobre: () -> Unit,
    aoSair: () -> Unit
) {
    val usuario = usuarioLogado

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                AvatarIniciais(iniciais = usuario.iniciais, tamanho = 80.dp)
                Text(usuario.nome, style = MaterialTheme.typography.titleLarge)
                Text(
                    text = "${usuario.cargo} · ${usuario.area}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                Text(
                    text = "Nível ${usuario.nivel}",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                BarraDeProgresso(
                    progresso = usuario.xp / usuario.xpProximoNivel.toFloat(),
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "${usuario.xp} / ${usuario.xpProximoNivel} XP",
                    style = MaterialTheme.typography.labelMedium
                )
            }
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

        item { Text("Conquistas", style = MaterialTheme.typography.titleMedium) }

        items(conquistas) { conquista ->
            CartaoConquista(conquista = conquista)
        }

        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = aoAbrirSobre, modifier = Modifier.fillMaxWidth()) {
                    Text("Sobre o EducaMais")
                }
                Button(onClick = aoSair, modifier = Modifier.fillMaxWidth()) {
                    Text("Sair")
                }
            }
        }
    }
}
