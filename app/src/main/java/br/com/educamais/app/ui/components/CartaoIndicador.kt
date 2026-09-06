package br.com.educamais.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CartaoIndicador(
    emoji: String,
    valor: String,
    rotulo: String,
    modifier: Modifier = Modifier
) {
    SuperficieCartao(modifier = modifier.fillMaxWidth()) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(text = emoji, style = MaterialTheme.typography.titleLarge)
            Text(text = valor, style = MaterialTheme.typography.titleLarge)
            Text(
                text = rotulo,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}
