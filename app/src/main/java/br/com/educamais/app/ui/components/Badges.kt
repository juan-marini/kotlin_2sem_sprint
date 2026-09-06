package br.com.educamais.app.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.educamais.app.model.RiscoEvasao
import br.com.educamais.app.ui.theme.EducaMaisTokens

@Composable
private fun Selo(texto: String, cor: Color, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(50),
        color = cor.copy(alpha = 0.12f),
        contentColor = cor
    ) {
        Text(
            text = texto,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun BadgeRisco(risco: RiscoEvasao, modifier: Modifier = Modifier) {
    val cores = EducaMaisTokens.cores
    val cor = when (risco) {
        RiscoEvasao.BAIXO -> cores.sucesso
        RiscoEvasao.MEDIO -> cores.atencao
        RiscoEvasao.ALTO -> cores.risco
    }
    Selo(texto = risco.label, cor = cor, modifier = modifier)
}

@Composable
fun BadgeCategoria(categoria: String, modifier: Modifier = Modifier) {
    Selo(texto = categoria, cor = MaterialTheme.colorScheme.primary, modifier = modifier)
}

@Composable
fun BadgeObrigatorio(modifier: Modifier = Modifier) {
    Selo(texto = "Obrigatório", cor = EducaMaisTokens.cores.navy, modifier = modifier)
}
