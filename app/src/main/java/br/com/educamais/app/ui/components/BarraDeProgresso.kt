package br.com.educamais.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BarraDeProgresso(
    progresso: Float,
    modifier: Modifier = Modifier,
    corPreenchimento: Color = MaterialTheme.colorScheme.primary,
    corTrilha: Color = MaterialTheme.colorScheme.outline,
    altura: Dp = 8.dp
) {
    val progressoLimitado = progresso.coerceIn(0f, 1f)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(altura)
            .clip(RoundedCornerShape(50))
            .background(corTrilha.copy(alpha = 0.4f))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progressoLimitado)
                .height(altura)
                .clip(RoundedCornerShape(50))
                .background(corPreenchimento)
        )
    }
}
