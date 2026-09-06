package br.com.educamais.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.educamais.app.model.Conquista

// Cadeado em texto no lugar de ícone: sem biblioteca de ícones no projeto.
@Composable
fun CartaoConquista(conquista: Conquista, modifier: Modifier = Modifier) {
    val alfa = if (conquista.desbloqueada) 1f else 0.45f
    SuperficieCartao(modifier = modifier.fillMaxWidth()) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = if (conquista.desbloqueada) "🏆" else "🔒",
                style = MaterialTheme.typography.headlineMedium
            )
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = conquista.titulo,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = alfa)
                )
                Text(
                    text = conquista.descricao,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = alfa * 0.85f)
                )
            }
        }
    }
}
