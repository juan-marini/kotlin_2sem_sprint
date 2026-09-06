package br.com.educamais.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Representa o pilar multicanal (modo áudio) apenas na interface, sem
// reprodução real nesta Sprint. Um dos poucos lugares com gradiente cheio.
@Composable
fun BlocoModoAudio(modifier: Modifier = Modifier) {
    BlocoComGradienteMarca(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.large)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "🎧 Modo áudio",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
            Text(
                text = "Ouça o conteúdo das trilhas obrigatórias enquanto dirige, caminha " +
                    "ou está na linha de produção.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.9f)
            )
        }
    }
}
