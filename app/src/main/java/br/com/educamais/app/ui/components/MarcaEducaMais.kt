package br.com.educamais.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.educamais.app.ui.theme.EducaMaisTokens

// Usado no fundo com gradiente do login e no cabeçalho da tela Sobre.
@Composable
fun MarcaEducaMais(modifier: Modifier = Modifier) {
    val cores = EducaMaisTokens.cores
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Brush.linearGradient(listOf(cores.azulEletrico, cores.ciano))),
            contentAlignment = Alignment.Center
        ) {
            Text("✦", style = MaterialTheme.typography.headlineMedium, color = Color.White)
        }
        Text(
            text = "EducaMais",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )
        Text(
            text = "EdIA — Inteligência que aprende com você",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White.copy(alpha = 0.85f),
            textAlign = TextAlign.Center
        )
    }
}
