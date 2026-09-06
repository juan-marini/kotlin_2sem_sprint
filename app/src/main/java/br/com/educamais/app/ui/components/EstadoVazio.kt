package br.com.educamais.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

// Reutilizado tanto quando o filtro de cursos não retorna resultado quanto
// quando uma rota é aberta com um id inexistente (curso/sala não encontrado).
@Composable
fun EstadoVazio(
    emoji: String,
    titulo: String,
    mensagem: String,
    modifier: Modifier = Modifier,
    textoAcao: String? = null,
    aoClicarAcao: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = emoji, style = MaterialTheme.typography.headlineLarge)
        Text(text = titulo, style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
        Text(
            text = mensagem,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
        if (textoAcao != null && aoClicarAcao != null) {
            Button(onClick = aoClicarAcao) {
                Text(textoAcao)
            }
        }
    }
}
